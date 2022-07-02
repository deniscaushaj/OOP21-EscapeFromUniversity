package escapefromuniversity.inGame;

import java.io.IOException;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import escapefromuniversity.controller.map.LayersControllerImpl;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.gameObject.player.PlayerImpl;
import escapefromuniversity.model.map.Camera;
import escapefromuniversity.model.map.MapProperties;
import escapefromuniversity.model.basics.Rectangle;
import escapefromuniversity.model.map.TMXMapParser;
import escapefromuniversity.model.map.Tile;
import escapefromuniversity.view.map.drawer.TileDrawer;
import escapefromuniversity.view.map.drawer.TileDrawerImpl;
import escapefromuniversity.view.map.drawer.CanvasDrawer;
import escapefromuniversity.view.map.drawer.CanvasDrawerImpl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Game view of test.
 *
 */
public class GameViewProva extends Application{
    private final MapProperties map;
    private CanvasDrawer canvasDrawer;
    private TileDrawer tileDrawer;
    private final Camera camera;
    private double x = 30;
    private double y = 30;
    private double radius = 10;
    private final Player fakePlayer = new PlayerImpl(GameObjectType.PLAYER, new Point2D(x, y), 0, null, 0, null);
    private final LayersControllerImpl layersController;
    
    private Canvas gameCanvas = new Canvas(600, 600);

    public GameViewProva() {
        this.camera = ratio -> {
            var hb = fakePlayer.getObjectHitBox();
            var center = hb.getBottomRightCorner().sum(hb.getTopLeftCorner()).multiplication(0.5);
            return new Rectangle(center.sum(new Point2D(-radius, -radius / ratio)), center.sum(new Point2D(radius, radius / ratio)));
        };
        final var parser = new TMXMapParser("final-map.tmx");
        this.map = parser.parse();
        this.layersController =  new LayersControllerImpl(map, fakePlayer);
        this.canvasDrawer = new CanvasDrawerImpl(gameCanvas);
        this.tileDrawer = new TileDrawerImpl(map, this.canvasDrawer);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("escapeFromUniversity");
        this.fakePlayer.setPosition(new Point2D(x, y));
        this.drawLayers();
        Group group = new Group(gameCanvas);
        Scene scene = new Scene(group, 850, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Stream<Tile> getTilesToDraw(final Rectangle proj) throws ParserConfigurationException, IOException, SAXException {
        return this.layersController.getVisibleLayers().flatMap(l -> l.getVisibleTiles().stream())
                .filter(t -> t.getX() - proj.getMinX() > -1 && t.getX() - proj.getMaxX() < 1 &&
                        t.getY() - proj.getMinY() > -1 && t.getY() - proj.getMaxY() < 1);
    }

    private Point2D calcProjectedPosition(final Point2D pos, final Rectangle proj) {
        // Translate top-left point to center the projection on the canvas.
        var point = pos.subtract(proj.getTopLeft());
        // The size of projection rectangle can be different from the canvas size, so calculate the zoom factor.
        var projZoom = this.canvasDrawer.getWidth() / proj.getWidth();
        return point.multiplication(projZoom);
    }

    private Rectangle calcProjectedRectangle(final Rectangle rect, final Rectangle proj) {
        return new Rectangle(
                this.calcProjectedPosition(rect.getTopLeft(), proj),
                this.calcProjectedPosition(rect.getBottomRight(), proj));
    }

    /**
     * 
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public void drawLayers() throws ParserConfigurationException, IOException, SAXException {
        var proj = this.camera.calcMapProjection(this.canvasDrawer.getScreenRatio());
        this.canvasDrawer.clear();
        getTilesToDraw(proj).forEach(t -> {
            this.tileDrawer.drawTileByID(t.getValue(), this.calcProjectedRectangle(
                    new Rectangle(t.getPosition(), t.getPosition().sum(new Point2D(1, 1))), proj));
        });

        var playerSprite = new SpriteImpl(State.LEFT, fakePlayer.getType());
        playerSprite.setFilepath();
        this.canvasDrawer.drawImage(playerSprite.getFilepath(),
                this.calcProjectedRectangle(new Rectangle(
                        fakePlayer.getObjectHitBox().getBottomRightCorner(),
                        fakePlayer.getObjectHitBox().getTopLeftCorner()
                ), proj));
    }
    
    public final void onKeyPressed(final KeyEvent evt) throws ParserConfigurationException, IOException, SAXException {
        if (evt.getCode().equals(KeyCode.A)) {
            x -= 1.66;
        }
        if (evt.getCode().equals(KeyCode.D)) {
            x += 1.66;
        }
        if (evt.getCode().equals(KeyCode.W)) {
            y -= 1.66;
        }
        if (evt.getCode().equals(KeyCode.S)) {
            y += 1.66;
        }
        if (evt.getCode().equals(KeyCode.Q)) {
            radius += 1;
        }
        if (evt.getCode().equals(KeyCode.E)) {
            radius -= 1;
        }
        this.fakePlayer.setPosition(new Point2D(x, y));
        this.drawLayers();
    }

}
