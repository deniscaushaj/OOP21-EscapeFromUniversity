package escapefromuniversity.model.map;

import java.util.Comparator;

import escapefromuniversity.model.basics.Point2D;

public class TileDrawerImpl implements TileDrawer {

    private final MapProperties map;
    private final CanvasDrawer canvasDrawer;

    /**
     * Constructor of TileDrawerImpl.
     * @param map the properties of the map
     * @param canvasDrawer the canvas drawer
     */
    public TileDrawerImpl(final MapProperties map, final CanvasDrawer canvasDrawer) {
        this.map = map;
        this.canvasDrawer = canvasDrawer;
    }

    @Override
    public void drawTileByID(final int id, final Rectangle pos) {
        if (id == 0) {
            return;
        }
        var ts = this.searchTileset(id);
        var tPos = calcTPos(id, ts);
        var tileHeight = this.map.getTileHeight();
        var tileWidth = this.map.getTileWidth();
        this.canvasDrawer.drawImage(ts.getFileName(),
                new Rectangle(
                    new Point2D(tPos.getX() * tileWidth, tPos.getY() * tileHeight),
                    new Point2D((tPos.getX() * tileWidth) + tileWidth, (tPos.getY() * tileHeight) + tileHeight)),
                pos);
    }

    /**
     * A method to calculate the position of a tile in the tileset.
     * @param id the ID of the tile wanted
     * @param ts the tileset containing the tile
     * @return the position of the tile
     */
    private Point2D calcTPos(final int id, final Tileset ts) {
        /*
         * Per calcolare la posizione del tile che mi serve devo fare la get delle colonne e delle righe del tileset giusto.
         * In questo modo posso determinare in base all'id la posizione.
         * Es:
         * ID = 50; ROWS = 7; COLS = 25
         * POS = {1, 24}
         * */
        var cols = ts.getColumns();
        var idOffset = id - ts.getFirstTileId();
        var x = idOffset % cols;
        var y = idOffset / cols;
        return new Point2D(x, y);
    }

    @Override
    public Tileset searchTileset(final int id) {
        /*
        * Voglio prendere da MapProperties la lista di Tileset per poter cercare quello che contiene l'id di cui ho bisogno
        * e poi poter prendere l'immagine PNG
        * */
        return map.getTilesets().stream()
                .filter(t -> t.getFirstTileId() <= id)
                .max(Comparator.comparingInt(Tileset::getFirstTileId))
                .get();
    }
}
