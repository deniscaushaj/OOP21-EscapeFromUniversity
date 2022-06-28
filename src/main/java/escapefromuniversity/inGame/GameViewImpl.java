package escapefromuniversity.inGame;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import escapefromuniversity.launcher.LauncherView;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.map.Camera;
import escapefromuniversity.model.map.MapProperties;
import escapefromuniversity.model.map.Rectangle;
import escapefromuniversity.model.map.TMXMapParser;
import escapefromuniversity.model.map.TileDrawer;
import escapefromuniversity.view.map.canvas.CanvasDrawer;
import escapefromuniversity.view.map.canvas.CanvasDrawerImpl;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

/**
 * 
 * class  of controller of game view.
 *
 */
public class GameViewImpl implements GameView {

    private static final long TIME_TO_END = 5000;
    private final GameController gameController;
    private final MapProperties map;
    private CanvasDrawer canvasDrawer;
    private TileDrawer tileDrawer;
    private final Camera camera;
    private static final double X = 30;
    private static final double Y = 30;
    private static final double RADIUS = 10;
    private final Map<Integer, SpriteAnimation> spriteAnimations = new HashMap<>();

    @FXML
    private Canvas gameCanvas;

    /**
     * 
     * @param gameController
     * @param playerHitBox
     */
    public GameViewImpl(final GameController gameController, final HitBox playerHitBox) {
        this.gameController = gameController;
        this.camera = ratio -> {
            var center = playerHitBox.getBottomLeftCorner().sum(playerHitBox.getUpperRightCorner()).multiplication(0.5);
            return new Rectangle(center.sum(new Point2D(-RADIUS, -RADIUS / ratio)), center.sum(new Point2D(RADIUS, RADIUS / ratio)));
        };
        final var parser = new TMXMapParser("final-map.tmx");
        try {
            this.map = parser.parse();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void drawerMap(final CanvasDrawerImpl canvas) {

    }

    private void drawerObject(final CanvasDrawerImpl canvas) {
        this.spriteAnimations.entrySet().stream().forEach(e -> {
            final SpriteAnimation animation = e.getValue();
            if (animation.isVisible()) {
                canvas.drawImage(animation.getSprite().getFilepath(), animation.getSprite().getRectangle(), animation.getPosition());
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    public void updateView() {
        /*
        final var gc = gameCanvas.getGraphicsContext2D();
        final CanvasDrawerImpl canvas = new CanvasDrawerImpl(gc);
        this.drawerMap(canvas);
        this.drawerObject(canvas);
        */
    }

    /**
     * {@inheritDoc}
     */
    public void removeSpriteAnimation(final int id) {
        this.spriteAnimations.remove(id);
    }

    /**
     * {@inheritDoc}
     */
    public void updateSpriteAnimation(final int id, final Point2D position, final State state) {
        this.spriteAnimations.get(id).setPosition(position);
        this.spriteAnimations.get(id).getSprite();
    }

    /**
     * {@inheritDoc}
     */
    public void addSpriteAnimation(final int id, final State state, final GameObjectType type, final int height, final int width) {
        final Sprite sprite = new SpriteImpl(state, type);
        final SpriteAnimation animation = new SpriteAnimation(sprite, height, width);
        this.spriteAnimations.put(id, animation);
    }

    /**
     * {@inheritDoc}
     */
    public boolean containThisID(final int id) {
        return this.spriteAnimations.containsKey(id);
    }

    /**
     * {@inheritDoc}
     */
    public void end(final GameState gameState) {
        if (gameState == GameState.WIN){
            //aggiorna con immagine vittoria
        } else if (gameState == GameState.LOST){
            //aggiorna con immagine sconfitta
        }
        try {
            Thread.sleep(TIME_TO_END);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LauncherView.createLauncher();
        //      System.exit(0);
    }

//    TODO: !!
//    private GameController gameController;
//    private GameKeyListener gameKeyListener;
//    private final JFrame window;
//    private JPanel pause;
//    private final GameHUDPanel gameHUD = new GameHUDPanel(WindowSet.getWindowRatio());
//    private static final long DELAY_CLOSE = 5000;
//
//    public GameViewImpl(GameController gameController) {
//        this.gameController = gameController;
//        this.gameKeyListener = new GameKeyListener(this.gameController);
//        this.window = new JFrame();
//        this.window.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.window.setUndecorated(true);
//        this.window.setSize(screenWidth, screenHeight);
//        this.window.setResizable(false);
//        this.window.setTitle("Escape From University");
//        String logo = OSFixes.getLocation("images", "logo.png"); // TODO change icon
//        this.window.setIconImage(Toolkit.getDefaultToolkit().getImage(logo));
//        this.window.setVisible(true);
//        //	private final JPanel gamePanel;
//
//        this.window.addKeyListener(this.gameKeyListener);
//
//        this.pause = new JPanel();
//
//    }
//
//
//    @Override
//    public void addPauseBG() {
//        Color color = new Color(0,0,0,205);
//        this.pause.setBackground(color);
//        this.window.add(this.pause);
//    }
//
//    @Override
//    public void removePauseBG() {
//        this.window.remove(this.pause);
//    }
}
