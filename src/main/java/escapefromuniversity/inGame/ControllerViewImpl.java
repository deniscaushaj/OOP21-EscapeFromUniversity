package escapefromuniversity.inGame;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import escapefromuniversity.launcher.LauncherView;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.map.CanvasDrawerImpl;
import escapefromuniversity.utilities.OSFixes;
import escapefromuniversity.utilities.WindowSet;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

import javax.swing.*;

import static escapefromuniversity.utilities.LauncherResizer.screenHeight;
import static escapefromuniversity.utilities.LauncherResizer.screenWidth;

public class ControllerViewImpl implements ControllerView{
    private final GameController gameController;
    private final Map<Integer,SpriteAnimation> spriteAnimations = new HashMap<>();

    @FXML
    private Canvas gameCanvas;


    public ControllerViewImpl(GameController gameController) {
        this.gameController = gameController;
    }

    private void drawerMap(CanvasDrawerImpl canvas) {

    }

    private void drawerObject(CanvasDrawerImpl canvas) {
        this.spriteAnimations.entrySet().stream().forEach(e -> {
            final SpriteAnimation animation = e.getValue();
            if (animation.isVisible()) {
                canvas.drawImage(animation.getSprite().getFilepath(), animation.getSprite().getRectangle(), animation.getPosition());
            }
        });
    }

    public void updateView() {
        final var gc = gameCanvas.getGraphicsContext2D();
        final CanvasDrawerImpl canvas = new CanvasDrawerImpl(gc);
        this.drawerMap(canvas);
        this.drawerObject(canvas);
    }

    public void remuveSpriteAnimation(int id) {
        this.spriteAnimations.remove(id);
    }

    public void updateSpriteAnimation(int id, Point2D position, State state) {
        this.spriteAnimations.get(id).setPosition(position);
        this.spriteAnimations.get(id).getSprite();
    }

    public void addSpriteAnimation(int id, State state, GameObjectType type, int height, int width) {
        final Sprite sprite = new SpriteImpl(state, type);
        final SpriteAnimation animation = new SpriteAnimation(sprite, height, width);
        this.spriteAnimations.put(id, animation);
    }

    public boolean containThisID(int id) {
        return this.spriteAnimations.containsKey(id);
    }
    
    public void end(final GameState gameState) {
        if (gameState == GameState.WIN){
            //aggiorna con immagine vittoria
        } else if (gameState == GameState.LOST){
            //aggiorna con immagine sconfitta
        }
        try {
            Thread.sleep(5000);
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
