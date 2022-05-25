package escapefromuniversity.model.map;

import javafx.util.Pair;

public interface TileDrawer {

    public void drawTileByID(int id, Pair<Integer, Integer> pos);

    public Tileset searchTileset(int id);
}
