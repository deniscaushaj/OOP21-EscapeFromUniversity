package escapefromuniversity.view.map;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.inGame.SpriteImpl;
import escapefromuniversity.controller.map.LayersControllerImpl;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.Direction;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.gameObject.player.PlayerImpl;
import escapefromuniversity.model.gameObject.player.PlayerMovement;
import escapefromuniversity.model.gameObject.player.PlayerMovementImpl;
import escapefromuniversity.model.map.*;
import escapefromuniversity.view.map.canvas.CanvasDrawer;
import escapefromuniversity.view.map.canvas.CanvasDrawerImpl;
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
    private final Player fakePlayer = new PlayerImpl(GameObjectType.PLAYER, new Point2D(x, y), 1.66, null, 0, null);
    private final PlayerMovement playerMovement = new PlayerMovementImpl(this.fakePlayer);
    private final LayersControllerImpl layersController;
    private final GameController gameController;

    @FXML
    private Canvas gameCanvas;

    public MapLoader(final GameController gameController, final Player player) {
        this.gameController = gameController;
        this.camera = ratio -> {
            var hb = player.getObjectHitBox();
            var center = hb.getBottomLeftCorner().sum(hb.getUpperRightCorner()).multiplication(0.5);
            return new Rectangle(center.sum(new Point2D(-radius, -radius / ratio)), center.sum(new Point2D(radius, radius / ratio)));
        };
        final var parser = new TMXMapParser("final-map.tmx");
        this.map = parser.parse();
        this.layersController =  new LayersControllerImpl(map, fakePlayer);
    }

    @FXML
    protected void initialize() {
        this.canvasDrawer = new CanvasDrawerImpl(gameCanvas);
        this.tileDrawer = new TileDrawerImpl(map, this.canvasDrawer);
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
                        fakePlayer.getObjectHitBox().getBottomLeftCorner(),
                        fakePlayer.getObjectHitBox().getUpperRightCorner()
                ), proj));
    }

    @FXML
    public final void onKeyPressed(final KeyEvent keyEvent) throws ParserConfigurationException, IOException, SAXException {
        if (keyEvent.getCode().equals(KeyCode.W)) {
            this.playerMovement.move(Direction.UP);

//            this.y -= 1.66;
        }
        if (keyEvent.getCode().equals(KeyCode.A)) {
            this.playerMovement.move(Direction.RIGHT);
//            this.x -= 1.66;
        }
        if (keyEvent.getCode().equals(KeyCode.S)) {
            this.playerMovement.move(Direction.DOWN);
//            this.y += 1.66;
        }
        if (keyEvent.getCode().equals(KeyCode.D)) {
            this.playerMovement.move(Direction.DOWN);
//            this.x += 1.66;
        }
        if (keyEvent.getCode().equals(KeyCode.Q)) {
            if (this.radius <= 15) {
                this.radius += 1;
            }
        }
        if (keyEvent.getCode().equals(KeyCode.E)) {
            if (this.radius >= 5) {
                this.radius -= 1;
            }
        }
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            this.gameController.setGameState(GameState.MENU);
        }
        if (keyEvent.getCode().equals(KeyCode.SPACE)) {
            this.fakePlayer.setShoot(true, this.fakePlayer.getLastDirection());
        }
        this.fakePlayer.setPosition(new Point2D(this.x, this.y));
        this.drawLayers();
    }
}
