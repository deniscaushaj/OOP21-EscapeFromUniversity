package escapefromuniversity.view.map;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.inGame.GameControllerImpl;
import escapefromuniversity.inGame.Sprite;
import escapefromuniversity.inGame.SpriteAnimation;
import escapefromuniversity.inGame.SpriteImpl;
import escapefromuniversity.controller.map.LayersControllerImpl;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
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
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Stream;

public class MapLoader {

    private final MapProperties map;
    private CanvasDrawer canvasDrawer;
    private TileDrawer tileDrawer;
    private final Camera camera;
    private double radius = 10;
    private final Player fakePlayer = new PlayerImpl(GameObjectType.PLAYER, new Point2D(30, 30), 1.66, new Vector2D(0,0), 0, null);
    private final LayersControllerImpl layersController;
    private final GameController gameController;
    private final Map<Integer, SpriteAnimation> spriteAnimations = new ConcurrentSkipListMap<>();


    @FXML
    private Canvas gameCanvas;

    public MapLoader() {
        this.gameController = new GameControllerImpl(this);
        this.camera = ratio -> {
            var hb = this.gameController.getPlayer().getObjectHitBox();
            var center = hb.getBottomLeftCorner().sum(hb.getUpperRightCorner()).multiplication(0.5);
            return new Rectangle(center.sum(new Point2D(-radius, -radius / ratio)), center.sum(new Point2D(radius, radius / ratio)));
        };
        final var parser = new TMXMapParser("final-map.tmx");
        this.map = parser.parse();
        this.layersController =  new LayersControllerImpl(map, this.gameController.getPlayer());
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
        final Map<Integer, SpriteAnimation> tmpAnimations = new ConcurrentSkipListMap<>(spriteAnimations);
        tmpAnimations.entrySet().forEach(e -> {
            final SpriteAnimation animation = e.getValue();
            if (animation.getPosition().getTopLeft().getX() > proj.getTopLeft().getX() && animation.getPosition().getTopLeft().getY() > proj.getTopLeft().getY()
                    && animation.getPosition().getTopLeft().getX() < proj.getBottomRight().getX() && animation.getPosition().getTopLeft().getX() < proj.getBottomRight().getX()) {
                this.canvasDrawer.drawImage(animation.getSprite().getFilepath(), this.calcProjectedRectangle(new Rectangle(
                        animation.getBox().getBottomLeftCorner(),
                        animation.getBox().getUpperRightCorner()
                ), proj));
            }
        });
    }
    
    public boolean containThisID(final int id) {
        return this.spriteAnimations.containsKey(id);
    }
    
    public void addSpriteAnimation(final int id, final State state, final GameObjectType type, final HitBox box, final Point2D position) {
        final Sprite sprite = new SpriteImpl(state, type);
        sprite.setFilepath();
        final SpriteAnimation animation = new SpriteAnimation(sprite, box);
        animation.setPosition(position);
        this.spriteAnimations.put(id, animation);
    }
    
    public void updateSpriteAnimation(final int id, final Point2D position, final State state) {
        this.spriteAnimations.get(id).setPosition(position);
        this.spriteAnimations.get(id).getSprite().setState(state);
        this.spriteAnimations.get(id).getSprite().setFilepath();
    }
    
    public void removeSpriteAnimation(final int id) {
        this.spriteAnimations.remove(id);
    }
    
    

    @FXML
    public final void onKeyPressed(final KeyEvent keyEvent) throws ParserConfigurationException, IOException, SAXException {
        if (keyEvent.getCode().equals(KeyCode.W)) {
//            this.fakePlayer.setDirection(new Vector2D(0, -1));
//            this.fakePlayer.setLastDirection(Direction.UP);
//            this.fakePlayer.update(0.25);
            this.gameController.getPlayer().setDirection(new Vector2D(0, -1));
            this.gameController.gameLoop();
        }
        if (keyEvent.getCode().equals(KeyCode.A)) {
//            this.fakePlayer.setDirection(new Vector2D(-1, 0));
//            this.fakePlayer.setLastDirection(Direction.LEFT);
//            this.fakePlayer.update(0.25);
            this.gameController.getPlayer().setDirection(new Vector2D(-1, 0));
            this.gameController.gameLoop();
        }
        if (keyEvent.getCode().equals(KeyCode.S)) {
//            this.fakePlayer.setDirection(new Vector2D(0, 1));
//            this.fakePlayer.setLastDirection(Direction.DOWN);
//            this.fakePlayer.update(0.25);
            this.gameController.getPlayer().setDirection(new Vector2D(0, 1));
            this.gameController.gameLoop();
        }
        if (keyEvent.getCode().equals(KeyCode.D)) {
//            this.fakePlayer.setDirection(new Vector2D(1, 0));
//            this.fakePlayer.setLastDirection(Direction.RIGHT);
//            this.fakePlayer.update(0.25);
            this.gameController.getPlayer().setDirection(new Vector2D(1, 0));
            this.gameController.gameLoop();
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
            this.gameController.gameLoop();
        }
        if (keyEvent.getCode().equals(KeyCode.SPACE)) {
            //this.fakePlayer.setShoot(true, this.fakePlayer.getLastDirection());
        }
        this.drawLayers();
    }
}
