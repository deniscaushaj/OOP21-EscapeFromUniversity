package escapefromuniversity.view.map.canvas;

import escapefromuniversity.model.map.Rectangle;
import escapefromuniversity.view.map.canvas.CanvasDrawer;
import javafx.scene.canvas.Canvas;
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
    private final Canvas canvas;

    /**
     * A constructor for CanvasDrawerImpl.
     * @param canvas the canvas used to draw
     */
    public CanvasDrawerImpl(final Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.imagesCache = new HashMap<>();
        gc.setImageSmoothing(false);
    }

    private Image getImageFromCacheOrLoad(final String filename) {
        if (!imagesCache.containsKey(filename)) {
            imagesCache.put(filename, new Image(ClassLoader.getSystemResourceAsStream(filename)));
        }
        return imagesCache.get(filename);
    }

    public void clear() {
        this.gc.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    public double getWidth() {
        return this.canvas.getWidth();
    }

    public double getHeight() {
        return this.canvas.getHeight();
    }

    public double getScreenRatio() {
        return this.getWidth() / this.getHeight();
    }

    @Override
    public void drawImage(final String filename, final Rectangle imagePos, final Rectangle drawPos) {
        this.gc.drawImage(this.getImageFromCacheOrLoad(filename),
                Math.round(imagePos.getMinX()), Math.round(imagePos.getMinY()),
                Math.round(imagePos.getWidth()), Math.round(imagePos.getHeight()),
                Math.round(drawPos.getMinX()-1), Math.round(drawPos.getMinY()-1),
                Math.round(drawPos.getWidth()+2), Math.round(drawPos.getHeight()+2));
    }
}