package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;

import java.util.Comparator;

/**
 * A class which implements TileSearcher.
 */
public class TileSearcherImpl implements TileSearcher {

    private final MapProperties map;

    /**
     * A constructor for TileSearcherImpl.
     * @param map the map
     */
    public TileSearcherImpl(final MapProperties map) {
        this.map = map;
    }

    @Override
    public Point2D calcTPos(final int id, final Tileset ts) {
        var cols = ts.getColumns();
        var idOffset = id - ts.getFirstTileId();
        var x = idOffset % cols;
        var y = idOffset / cols;
        return new Point2D(x, y);
    }

    @Override
    public Tileset searchTileset(final int id) {
        return map.getTilesets().stream()
                .filter(t -> t.getFirstTileId() <= id)
                .max(Comparator.comparingInt(Tileset::getFirstTileId))
                .get();
    }
}
