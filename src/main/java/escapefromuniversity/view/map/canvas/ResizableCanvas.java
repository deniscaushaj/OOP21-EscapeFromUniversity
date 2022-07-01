package escapefromuniversity.view.map.canvas;

import javafx.scene.canvas.Canvas;

/**
 * A class which implements Canvas to resize the canvas
 */
public class ResizableCanvas extends Canvas {

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double maxHeight(final double width) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double maxWidth(final double height) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double minWidth(final double height) {
        return 1.0;
    }

    @Override
    public double minHeight(final double width) {
        return 1.0;
    }

    @Override
    public void resize(final double width, final double height) {
        this.setWidth(width);
        this.setHeight(height);
    }
}