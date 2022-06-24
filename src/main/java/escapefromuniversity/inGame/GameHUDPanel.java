package escapefromuniversity.inGame;

import escapefromuniversity.utilities.OSFixes;
import escapefromuniversity.utilities.WindowSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;

import java.awt.Rectangle;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

/**
 * 
 * HUDPanel in game.
 *
 */
public class GameHUDPanel extends JLayeredPane {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JLabel creditsCounter = new JLabel();
    private JProgressBar playerLifeBar;
    private final Image creditsImage;
    private final Rectangle playerLifeBarPosition;
    private final Rectangle creditsPosition;
    private final Rectangle creditsCounterPosition;
    GameHUDPanel(final double windowRatio) {
        this.creditsCounter.setText("0");
        this.creditsCounter.setFont(WindowSet.FONT);
        this.creditsCounter.setForeground(Color.white);
        this.creditsPosition = new Rectangle((int) (10 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
        this.creditsCounterPosition = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
        this.creditsCounter.setBounds(creditsCounterPosition);
        this.creditsImage = new ImageIcon(OSFixes.getLocation("hud", "credits.png")).getImage().getScaledInstance((int) creditsPosition.getWidth(),
                (int) creditsPosition.getHeight(), 
                Image.SCALE_SMOOTH);
        this.playerLifeBarPosition = new Rectangle((int) (10 * windowRatio), (int) (10 * windowRatio), (int) (300 * windowRatio), (int) (30 * windowRatio));
        this.add(this.creditsCounter);
        this.setOpaque(false);
    }

    /**
     * 
     * @param maxLife
     */
    public void setLifeBar(final int maxLife) {
        this.remove(this.playerLifeBar);
        this.playerLifeBar = new JProgressBar(0, maxLife);
        this.playerLifeBar.setBounds(this.playerLifeBarPosition);
        this.playerLifeBar.setForeground(new Color(150, 0, 0));
        this.add(this.playerLifeBar);
    }

    /**
     * 
     * @param credits
     */
    public void updateCreditsCounter(final int credits) {
        this.creditsCounter.setText("" + credits);
    }

    /**
     * 
     * @param life
     */
    public void updateLife(final int life) {
        this.playerLifeBar.setValue(life);
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.creditsImage, (int) this.creditsPosition.getX(), (int) this.creditsPosition.getY(), null);
        Toolkit.getDefaultToolkit().sync();
    }

}
