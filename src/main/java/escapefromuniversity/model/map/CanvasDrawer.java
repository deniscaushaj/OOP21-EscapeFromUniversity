package escapefromuniversity.model.map;

/**
 * Interface which draws a canvas.
 */
public interface CanvasDrawer {

    /**
     * Draws a tile.
     * @param filename the filename
     * @param imagePos the position in the file of the rectangle to draw
     * @param drawPos the position in the map of the rectangle to draw
     */
    void drawImage(String filename, Rectangle imagePos, Rectangle drawPos);
}
