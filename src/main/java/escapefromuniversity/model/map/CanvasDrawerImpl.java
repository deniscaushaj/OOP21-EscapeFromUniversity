package escapefromuniversity.model.map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CanvasDrawerImpl implements CanvasDrawer{

    private final GraphicsContext gc;

    public CanvasDrawerImpl(GraphicsContext gc){
        this.gc = gc;
    }

    @Override
    public void drawImage(String filename, Rectangle imagePos, Rectangle drawPos) {
        Image img = new Image(filename);
        this.gc.drawImage(img,
                imagePos.getMinX(), imagePos.getMinY(), imagePos.getWidth(), imagePos.getHeight(),
                drawPos.getMinX(), drawPos.getMinY(), drawPos.getWidth(), drawPos.getHeight());
    }
}
