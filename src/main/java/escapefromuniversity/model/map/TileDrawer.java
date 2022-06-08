package escapefromuniversity.model.map;

import javafx.util.Pair;

public interface TileDrawer {

    public void drawTileByID(int id, Rectangle pos);

    public Tileset searchTileset(int id);
}
