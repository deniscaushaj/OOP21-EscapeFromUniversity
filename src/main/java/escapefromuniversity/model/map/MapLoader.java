package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

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
        this.camera = () -> {
            var center = new Point2D(x, y);
            return new Rectangle(center.sum(new Point2D(-radius, -radius)), center.sum(new Point2D(radius, radius)));
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
    }

    public void drawLayers(final MapProperties map, final Camera cam, final TileDrawer drawer) {
        var canvasSize = gameCanvas.getWidth();
        var proj = cam.calcMapProjection();
        var ratio = canvasSize / proj.getWidth();

        map.getLayers().stream().flatMap(l -> l.getTiles().stream())
                .filter(t -> t.getX() - proj.getMinX() > -1 && t.getX() - proj.getMaxX() < 1 &&
                        t.getY() - proj.getMinY() > -1 && t.getY() - proj.getMaxY() < 1).forEach(t -> {

                    var point = t.getPoint().sum(proj.getTopLeft().multiplication(-1));
                    drawer.drawTileByID(t.getValue(), new Rectangle(
                            point.multiplication(ratio),
                            point.sum(new Point2D(1, 1)).multiplication(ratio)));
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
        this.canvasDrawer.clear();
        this.drawLayers(this.map, this.camera, this.tileDrawer);
    }
}
