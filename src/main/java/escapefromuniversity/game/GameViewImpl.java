package escapefromuniversity.game;

import static escapefromuniversity.utilities.LauncherResizer.*;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import escapefromuniversity.input.KeyHandler;
import escapefromuniversity.utilities.OSFixes;

public class GameViewImpl extends JPanel implements GameView {

    BufferedImage tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = (Graphics2D)tempScreen.getGraphics();

    KeyHandler keyHandler = new KeyHandler();

    private static GameState gameState;

    public GameViewImpl () {
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }


    public static void startGame () {
        JFrame window = new JFrame();
        window.setUndecorated(true);
        window.setSize(screenWidth, screenHeight);
        window.setResizable(false);
        window.setTitle("Escape From University");
        String logo = OSFixes.getLocation("images", "logo.png"); // TODO change icon
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(logo));
        window.setVisible(true);
    }

    /**
     * @return the current game state.
     */
    public static GameState getGameState () {
        return gameState;
    }

    /**
     * Sets the current game state.
     * @param gameState the game state to set.
     */
    public void setGameState (GameState gameState) {
        GameViewImpl.gameState = gameState;
    }

    public void draw (Graphics2D g2d) {
        this.g2d = g2d;
//      g2d.setFont(null); TODO choose font
        switch (getGameState()) {
            case INVENTORY:
                this.addPauseBG();
                break;
            case DIALOGUE:
                this.addPauseBG();
                break;
            case FIGHT:
                break;
            case MENU:
                this.addPauseBG();
                break;
            case PLAY:
                this.removePauseBG();
                break;
            case QUIZ:
                this.addPauseBG();
                break;
            case SHOP:
                this.addPauseBG();
                break;
            case WIN:
                break;
            default:
                break;
        }
    }

    public void addPauseBG () {

    }

    public void removePauseBG () {

    }

}
