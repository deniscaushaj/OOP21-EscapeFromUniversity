package escapefromuniversity;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import escapefromuniversity.model.utilities.OSFixes;

import static escapefromuniversity.model.utilities.LauncherResizer.*;

public class GameView {

    BufferedImage tempScreen;
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
}
