package escapefromuniversity.model.map;

public interface TileDrawer {

    public void drawTileByID(int id, Rectangle pos);

    public Tileset searchTileset(int id);
}
