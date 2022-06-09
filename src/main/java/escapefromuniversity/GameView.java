package escapefromuniversity;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import escapefromuniversity.model.utilities.OSFixes;

import static escapefromuniversity.model.utilities.LauncherResizer.*;

public class GameView {

    BufferedImage tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = (Graphics2D)tempScreen.getGraphics();
    
    private GameState state;
    
    public static void startGame () {
        JFrame window = new JFrame();
        window.setUndecorated(true);
        window.setSize(screenWidth, screenHeight);
        window.setResizable(false);
        window.setTitle("Escape From University");
        String logo = new String(OSFixes.getLocation("images", "logo.png")); // TODO change icon
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(logo));
        window.setVisible(true);
    }
    
    /**
     * @return the current game state.
     */
    public GameState getGameState () {
        return state;
    }
    
    /**
     * Sets the current game state.
     * @param gameState : the game state to set.
     */
    public void setGameState (GameState gameState) {
        this.state = gameState;
    }
    
    public void draw (Graphics2D g2d) {
        this.g2d = g2d;
//      g2d.setFont(null); TODO choose font
        switch (this.getGameState()) {
        case CHARACTER:
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
