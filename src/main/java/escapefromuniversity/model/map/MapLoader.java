package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.stream.Stream;

public class MapLoader {

    private final MapProperties map;
    private CanvasDrawer canvasDrawer;
    private TileDrawer tileDrawer;
    private final Camera camera;
    private double x = 30;
    private double y = 30;
    private double radius = 10;


    @FXML
    private Canvas gameCanvas;

    public MapLoader() {
        this.camera = ratio -> {
            var center = new Point2D(x, y);
            return new Rectangle(center.sum(new Point2D(-radius, -radius / ratio)), center.sum(new Point2D(radius, radius / ratio)));
        };
        final var parser = new TMXMapParser("final-map.tmx");
        try {
            this.map = parser.parse();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void initialize() {
        this.canvasDrawer = new CanvasDrawerImpl(gameCanvas);
        this.tileDrawer = new TileDrawerImpl(map, this.canvasDrawer);
        this.drawLayers();
    }

    private Stream<Tile> getTilesToDraw(final Rectangle proj) {
        return this.map.getLayers().stream().flatMap(l -> l.getTiles().stream())
                .filter(t -> t.getX() - proj.getMinX() > -1 && t.getX() - proj.getMaxX() < 1 &&
                        t.getY() - proj.getMinY() > -1 && t.getY() - proj.getMaxY() < 1);
    }

    private Rectangle calcProjectedTilePosition(final Tile tile, final Rectangle proj) {
        // Translate top-left point to center the projection on the canvas.
        var point = tile.getPosition().subtract(proj.getTopLeft());
        // The size of projection rectangle can be different from the canvas size, so calculate the zoom factor.
        var projZoom = this.canvasDrawer.getWidth() / proj.getWidth();
        return new Rectangle(
                point.multiplication(projZoom),
                point.sum(new Point2D(1, 1)).multiplication(projZoom));
    }

    public void drawLayers() {
        var proj = this.camera.calcMapProjection(this.canvasDrawer.getScreenRatio());
        this.canvasDrawer.clear();
        getTilesToDraw(proj).forEach(t -> {
            this.tileDrawer.drawTileByID(t.getValue(), this.calcProjectedTilePosition(t, proj));
        });
    }

    @FXML
    public final void onKeyPressed(final KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.A)) {
            x -= 0.5;
        }
        if (evt.getCode().equals(KeyCode.D)) {
            x += 0.5;
        }
        if (evt.getCode().equals(KeyCode.W)) {
            y -= 0.5;
        }
        if (evt.getCode().equals(KeyCode.S)) {
            y += 0.5;
        }
        if (evt.getCode().equals(KeyCode.Q)) {
            radius += 1;
        }
        if (evt.getCode().equals(KeyCode.E)) {
            radius -= 1;
        }
        this.drawLayers();
    }
}
