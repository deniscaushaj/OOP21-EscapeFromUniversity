package escapefromuniversity.model.map;

/**
 * An interface which draws a tile.
 */
public interface TileDrawer {

    /**
     * Draws a tile selected by ID.
     * @param id the id of the tile
     * @param pos the rectangle where the tile has to be drawn
     */
    void drawTileByID(int id, Rectangle pos);

    /**
     * Search the tileset containing the tile with the specified id.
     * @param id the id of the tile
     * @return the tileset containing the tile with the specified id
     */
    Tileset searchTileset(int id);
}
