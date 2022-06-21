package escapefromuniversity.model.map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * A class which implements the interface CanvasDrawer.
 */
public class CanvasDrawerImpl implements CanvasDrawer {

    private final GraphicsContext gc;
    private final Map<String, Image> imagesCache;

    /**
     * Constructor.
     * @param gc the graphics of the canvas
     */
    public CanvasDrawerImpl(final GraphicsContext gc) {
        this.gc = gc;
        this.imagesCache = new HashMap<String, Image>();
    }

    private Image getImageFromCacheOrLoad(final String filename) {
        if (!imagesCache.containsKey(filename))
            imagesCache.put(filename, new Image(ClassLoader.getSystemResourceAsStream(filename)));
        return imagesCache.get(filename);
    }

    @Override
    public void drawImage(final String filename, final Rectangle imagePos, final Rectangle drawPos) {
        this.gc.drawImage(this.getImageFromCacheOrLoad(filename),
                imagePos.getMinX(), imagePos.getMinY(), imagePos.getWidth(), imagePos.getHeight(),
                drawPos.getMinX(), drawPos.getMinY(), drawPos.getWidth(), drawPos.getHeight());
    }
}
