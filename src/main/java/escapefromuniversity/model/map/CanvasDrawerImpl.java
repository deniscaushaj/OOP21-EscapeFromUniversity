package escapefromuniversity.model.map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * A class which implements the interface CanvasDrawer.
 */
public class CanvasDrawerImpl implements CanvasDrawer {

    private final GraphicsContext gc;

    /**
     * Constructor.
     * @param gc the graphics of the canvas
     */
    public CanvasDrawerImpl(final GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void drawImage(final String filename, final Rectangle imagePos, final Rectangle drawPos) {
        Image img = new Image(filename);
        this.gc.drawImage(img,
                imagePos.getMinX(), imagePos.getMinY(), imagePos.getWidth(), imagePos.getHeight(),
                drawPos.getMinX(), drawPos.getMinY(), drawPos.getWidth(), drawPos.getHeight());
    }
}
