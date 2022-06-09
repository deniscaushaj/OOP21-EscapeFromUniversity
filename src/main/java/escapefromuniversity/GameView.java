package escapefromuniversity;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import escapefromuniversity.model.utilities.OSFixes;

import static escapefromuniversity.model.utilities.LauncherResizer.*;

public class GameView {

    BufferedImage tempScreen;
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
    
}
