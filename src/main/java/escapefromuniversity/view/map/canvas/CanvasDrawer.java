package escapefromuniversity.view.map.canvas;

import escapefromuniversity.model.map.Rectangle;

/**
 * An interface which draws a canvas.
 */
public interface CanvasDrawer {

    /**
     * Clears the canvas.
     */
    void clear();

    /**
     * Returns the width of the canvas.
     * @return the width of the canvas
     */
    double getWidth();

    /**
     * Returns the height of the canvas.
     * @return the height of the canvas
     */
    double getHeight();

    /**
     * Returns the screen ratio.
     * @return the screen ratio
     */
    double getScreenRatio();

    /**
     * Draws a tile.
     * @param filename the filename
     * @param imagePos the position in the file of the rectangle to draw
     * @param drawPos  the position in the map of the rectangle to draw
     */
    void drawImage(String filename, Rectangle imagePos, Rectangle drawPos);

    /**
     * Draws a tile.
     * @param filename the filename
     * @param drawPos the position in the map of the rectangle to draw
     */
    void drawImage(String filename, Rectangle drawPos);
}
