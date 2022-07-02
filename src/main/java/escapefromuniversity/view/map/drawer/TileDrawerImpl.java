package escapefromuniversity.view.map.drawer;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Rectangle;
import escapefromuniversity.model.map.MapProperties;
import escapefromuniversity.model.map.TileSearcher;
import escapefromuniversity.model.map.TileSearcherImpl;

/**
 * A class which implements TileDrawer.
 */
public class TileDrawerImpl implements TileDrawer {

    private final MapProperties map;
    private final CanvasDrawer canvasDrawer;
    private final TileSearcher tileSearcher;

    /**
     * Constructor of TileDrawerImpl.
     * @param map the properties of the map
     * @param canvasDrawer the canvas drawer
     */
    public TileDrawerImpl(final MapProperties map, final CanvasDrawer canvasDrawer) {
        this.map = map;
        this.canvasDrawer = canvasDrawer;
        this.tileSearcher  = new TileSearcherImpl(this.map);
    }

    @Override
    public void drawTileByID(final int id, final Rectangle pos) {
        if (id == 0) {
            return;
        }
        var ts = tileSearcher.searchTileset(id);
        var tPos = tileSearcher.calcTPos(id, ts);
        var tileHeight = this.map.getTileHeight();
        var tileWidth = this.map.getTileWidth();
        this.canvasDrawer.drawImage(ts.getFileName(),
                new Rectangle(
                    new Point2D(tPos.getX() * tileWidth, tPos.getY() * tileHeight),
                    new Point2D((tPos.getX() + 1) * tileWidth, (tPos.getY() + 1) * tileHeight)),
                pos);
    }
}
