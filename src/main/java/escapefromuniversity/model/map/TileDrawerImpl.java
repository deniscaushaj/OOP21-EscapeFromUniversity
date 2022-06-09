package escapefromuniversity.model.map;

import escapefromuniversity.model.Point2D;
import java.util.Comparator;

public class TileDrawerImpl implements TileDrawer {

    private final MapProperties map;
    private final CanvasDrawer canvasDrawer;

    public TileDrawerImpl(final MapProperties map, CanvasDrawer canvasDrawer){
        this.map = map;
        this.canvasDrawer = canvasDrawer;
    }

    @Override
    public void drawTileByID(int id, Rectangle pos) {
        var ts = this.searchTileset(id);
        var tPos = calcTPos(id, ts);
        var tileHeight = map.getHeight();
        var tileWeidth = map.getWidth();
        this.canvasDrawer.drawImage(ts.getFileName(),
                new Rectangle(
                    new Point2D(tPos.getX() * tileWeidth, tPos.getY() * tileHeight),
                    new Point2D((tPos.getX() * tileWeidth) + tileWeidth, (tPos.getY() * tileHeight) + tileHeight)),
                pos);
    }

    /**
     * @param id
     * @return Tile's position in Tileset
     */
    private Point2D calcTPos(int id, Tileset ts) {
        /*
         * Per calcolare la posizione del tile che mi serve devo fare la get delle colonne e delle righe del tileset giusto.
         * In questo modo posso determinare in base all'id la posizione.
         * Es:
         * ID = 50; ROWS = 7; COLS = 25
         * POS = {1, 24}
         * */
        var cols = ts.getColumns();
        var idOffset = id - ts.getFirstTileId();
        var x = idOffset / cols;
        var y = idOffset % cols;
        return new Point2D(x, y);
    }

    @Override
    public Tileset searchTileset(int id) {
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
