package escapefromuniversity.view.map;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.inGame.GameControllerImpl;
import escapefromuniversity.inGame.Sprite;
import escapefromuniversity.inGame.SpriteImpl;
import escapefromuniversity.controller.map.LayersControllerImpl;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.Direction;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.enemy.BossFactoryImpl;
import escapefromuniversity.model.map.*;
import escapefromuniversity.view.map.canvas.CanvasDrawer;
import escapefromuniversity.view.map.canvas.CanvasDrawerImpl;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Stream;

/**
 * .
 */
public class MapLoader {

    private GameController gameController;
    private final MapProperties map;
    private CanvasDrawer canvasDrawer;
    private TileDrawer tileDrawer;
    private final Camera camera;
    private double radius = 10;
    private final LayersControllerImpl layersController;
    private final Map<Integer, Sprite> sprites = new ConcurrentSkipListMap<>();


    @FXML
    private Canvas gameCanvas;

    public MapLoader() {
        this.gameController = new GameControllerImpl();
        this.gameController.setMapLoader(this);
        this.camera = ratio -> {
            var hb = this.gameController.getPlayer().getObjectHitBox();
            var center = hb.getBottomRightCorner().sum(hb.getTopLeftCorner()).multiplication(0.5);
            return new Rectangle(center.sum(new Point2D(-radius, -radius / ratio)), center.sum(new Point2D(radius, radius / ratio)));
        };
        final var parser = new TMXMapParser("final-map.tmx");
        this.map = parser.parse();
        this.layersController =  new LayersControllerImpl(map, this.gameController.getPlayer());
    }

    public void setGameController(GameController gc) {
        this.gameController = gc;
        this.gameController.gameLoop();
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

    public void drawLayers(){
        var proj = this.camera.calcMapProjection(this.canvasDrawer.getScreenRatio());
        this.canvasDrawer.clear();
        try {
            getTilesToDraw(proj).forEach(t -> {
                this.tileDrawer.drawTileByID(t.getValue(), this.calcProjectedRectangle(
                        new Rectangle(t.getPosition(), t.getPosition().sum(new Point2D(1, 1))), proj));
            });
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        final Map<Integer, Sprite> tmpSprites = new ConcurrentSkipListMap<>(sprites);
        tmpSprites.entrySet().forEach(e -> {
            if(this.gameController.getHitBoxID(e.getKey()).getTopLeftCorner().getX() > proj.getTopLeft().getX()
                    && this.gameController.getHitBoxID(e.getKey()).getTopLeftCorner().getY() > proj.getTopLeft().getY()
                    && this.gameController.getHitBoxID(e.getKey()).getBottomRightCorner().getX() < proj.getBottomRight().getX()
                    && this.gameController.getHitBoxID(e.getKey()).getBottomRightCorner().getY() < proj.getBottomRight().getY()) {
                final Sprite sprite = e.getValue();
                this.canvasDrawer.drawImage(sprite.getFilepath(), this.calcProjectedRectangle(new Rectangle(
                        this.gameController.getHitBoxID(e.getKey()).getBottomRightCorner(),
                        this.gameController.getHitBoxID(e.getKey()).getTopLeftCorner()
                        ), proj));

            }
        });

    }

    public boolean containThisID(final int id) {
        return this.sprites.containsKey(id);
    }

    public void addSpriteAnimation(final int id, final State state, final GameObjectType type) {
        final Sprite sprite = new SpriteImpl(state, type);
        sprite.setFilepath();
        this.sprites.put(id, sprite);
    }

    public void updateSpriteAnimation(final int id, final State state) {
        this.sprites.get(id).setState(state);
        this.sprites.get(id).setFilepath();
    }

    public void removeSpriteAnimation(final int id) {
        this.sprites.remove(id);
    }

    @FXML
    public final void onKeyPressed(final KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
        case W:
        case UP:
            if (this.gameController.getGameState().equals(GameState.PLAY) || this.gameController.getGameState().equals(GameState.FIGHT)
                    || this.gameController.getGameState().equals(GameState.GRADUATED) || this.gameController.getGameState().equals(GameState.SHOP_ROOM)) {
                this.gameController.getPlayer().setDirection(new Vector2D(0, -1));
                this.gameController.getPlayer().setLastDirection(Direction.UP);
                this.gameController.gameLoop();
            }
            break;
        case A:
        case LEFT:
            if (this.gameController.getGameState().equals(GameState.PLAY) || this.gameController.getGameState().equals(GameState.FIGHT)
                    || this.gameController.getGameState().equals(GameState.GRADUATED) || this.gameController.getGameState().equals(GameState.SHOP_ROOM)) {
                this.gameController.getPlayer().setDirection(new Vector2D(-1, 0));
                this.gameController.getPlayer().setLastDirection(Direction.LEFT);
                this.gameController.gameLoop();
            }
            break;
        case S:
        case DOWN:
            if (this.gameController.getGameState().equals(GameState.PLAY) || this.gameController.getGameState().equals(GameState.FIGHT)
                    || this.gameController.getGameState().equals(GameState.GRADUATED) || this.gameController.getGameState().equals(GameState.SHOP_ROOM)) {
                this.gameController.getPlayer().setDirection(new Vector2D(0, 1));
                this.gameController.getPlayer().setLastDirection(Direction.DOWN);
                this.gameController.gameLoop();
            }
            break;
        case D:
        case RIGHT:
            if (this.gameController.getGameState().equals(GameState.PLAY) || this.gameController.getGameState().equals(GameState.FIGHT)
                    || this.gameController.getGameState().equals(GameState.GRADUATED) || this.gameController.getGameState().equals(GameState.SHOP_ROOM)) {
                this.gameController.getPlayer().setDirection(new Vector2D(1, 0));
                this.gameController.getPlayer().setLastDirection(Direction.RIGHT);
                this.gameController.gameLoop();
            }
            break;
        case Q:
            if (this.gameController.getGameState().equals(GameState.PLAY) || this.gameController.getGameState().equals(GameState.FIGHT)
                    || this.gameController.getGameState().equals(GameState.GRADUATED) || this.gameController.getGameState().equals(GameState.SHOP_ROOM)) {
                if (this.radius <= 13) {
                    this.radius += 1;
                }
            }
            break;
        case E:
            if (this.gameController.getGameState().equals(GameState.PLAY) || this.gameController.getGameState().equals(GameState.FIGHT)
                    || this.gameController.getGameState().equals(GameState.GRADUATED) || this.gameController.getGameState().equals(GameState.SHOP_ROOM)) {
                if (this.radius >= 7) {
                    this.radius -= 1;
                }
            }
            break;
        case SPACE:
            if (this.gameController.getGameState().equals(GameState.FIGHT)) {
                this.gameController.getPlayer().setShoot(true, this.gameController.getPlayer().getLastDirection());
                this.gameController.getPlayer().shoot();
                //                    this.gameController.gameLoop();
            }
            break;
        case ESCAPE:
            if (this.gameController.getGameState().equals(GameState.PLAY) || this.gameController.getGameState().equals(GameState.FIGHT)
                    || this.gameController.getGameState().equals(GameState.GRADUATED) || this.gameController.getGameState().equals(GameState.SHOP_ROOM)) {
                this.gameController.setGameState(GameState.MENU);
            } else if (this.gameController.getGameState().equals(GameState.MENU)) {
                this.gameController.getMenuController().resume();
            } else if (this.gameController.getGameState().equals(GameState.SHOP_MENU)) {
                this.gameController.getShopController().closeShop();
            }
            this.gameController.gameLoop();
            break;
        default:
            break;
        }
        this.drawLayers();
    }

    public void checkID() {
        var iterator = sprites.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if(!this.gameController.isPresentID(entry.getKey())) {
                this.sprites.remove(entry.getKey());
            }
        }
    }
}
