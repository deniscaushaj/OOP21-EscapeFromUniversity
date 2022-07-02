package escapefromuniversity.view.map.drawer;

import escapefromuniversity.model.basics.Rectangle;

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
}
