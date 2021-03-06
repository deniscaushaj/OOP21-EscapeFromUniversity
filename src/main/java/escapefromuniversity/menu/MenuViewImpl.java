package escapefromuniversity.menu;

import static escapefromuniversity.utilities.LauncherResizer.SCREENHEIGHT;
import static escapefromuniversity.utilities.LauncherResizer.SCREENWIDTH;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import escapefromuniversity.utilities.WindowSet;

/**
 * 
 * menu in game view.
 *
 */
public class MenuViewImpl implements MenuView {

    private final JFrame window = new JFrame();
    private final MenuController controller;
    private JLayeredPane menuPanel;

    private final double windowRatio = WindowSet.getWindowRatio();

    private final Rectangle retBtExit = new Rectangle((int) (SCREENWIDTH / 3 * windowRatio), (int) (300 * windowRatio), (int) (SCREENWIDTH / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtResume = new Rectangle((int) (SCREENWIDTH / 3 * windowRatio), (int) (400 * windowRatio), (int) (SCREENWIDTH / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtCommand = new Rectangle((int) (SCREENWIDTH / 3 * windowRatio), (int) (500 * windowRatio), (int) (SCREENWIDTH / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtBack = new Rectangle((int) (SCREENWIDTH / 3 * windowRatio), (int) (500 * windowRatio), (int) (SCREENWIDTH / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtTextCommand1 = new Rectangle((int) (SCREENWIDTH / 3 * windowRatio), (int) (10 * windowRatio), (int) (SCREENWIDTH / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtTextCommand2 = new Rectangle((int) (SCREENWIDTH / 3 * windowRatio), (int) (110 * windowRatio), (int) (SCREENWIDTH / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtTextCommand3 = new Rectangle((int) (SCREENWIDTH / 3 * windowRatio), (int) (210 * windowRatio), (int) (SCREENWIDTH / 2 * windowRatio), (int) (90 * windowRatio));

    private final JButton btExit = new JButton("EXIT");
    private final JButton btResume = new JButton("RESUME");
    private final JButton btCommand = new JButton("COMMAND");
    private final JButton btBack = new JButton("BACK");

    private final JLabel command1 = new JLabel("A/W/S/D : move");
    private final JLabel command2 = new JLabel("Spacebar : shoot");
    private final JLabel command3 = new JLabel("Esc : open menu");

    private final Color colorButton = new Color(232, 198, 42);
    private final Color colorBackground = new Color(255, 241, 179);
    private final Font font = new Font("Everson Mono", Font.PLAIN, 20);

    /**
     * 
     * @param controller
     */
    public MenuViewImpl(final MenuController controller) {
        this.controller = controller;
        this.btExit.setBounds(this.retBtExit);
        this.btResume.setBounds(this.retBtResume);
        this.btCommand.setBounds(this.retBtCommand);
        this.btExit.setFont(WindowSet.FONT);
        this.btResume.setFont(WindowSet.FONT);
        this.btCommand.setFont(WindowSet.FONT);
        this.btBack.setBackground(this.colorButton);
        this.btCommand.setBackground(this.colorButton);
        this.btExit.setBackground(this.colorButton);
        this.btResume.setBackground(this.colorButton);
        this.btExit.addActionListener(e -> this.controller.exit());
        this.btResume.addActionListener(e -> this.controller.resume());
        this.btCommand.addActionListener(e -> this.controller.getCommand());
        this.command1.setBounds(this.retBtTextCommand1);
        this.command1.setFont(this.font);
        this.command2.setBounds(this.retBtTextCommand2);
        this.command2.setFont(this.font);
        this.command3.setBounds(this.retBtTextCommand3);
        this.command3.setFont(this.font);
        this.btBack.setBounds(this.retBtBack);
        this.btBack.setFont(WindowSet.FONT);
        this.btBack.addActionListener(e -> this.controller.back());
        this.window.setTitle("Escape From University");
        this.window.setResizable(false);
        this.window.setUndecorated(true);
        this.window.setSize((int) (SCREENWIDTH * windowRatio), (int) (SCREENHEIGHT * windowRatio));
        this.menuPanel = new JLayeredPane();
        this.menuPanel.setOpaque(false);
        this.window.getContentPane().add(menuPanel);
        this.window.setLocationRelativeTo(null);
    }

    @Override
    public void startMenu() {
        this.menuPanel.removeAll();
        this.menuPanel.revalidate();
        this.menuPanel.repaint();
        this.menuPanel.setBackground(this.colorBackground);
        this.menuPanel.add(this.btExit);
        this.menuPanel.add(this.btResume);
        this.menuPanel.add(this.btCommand);
    }

    @Override
    public void close() {
        this.window.setVisible(false);
    }

    @Override
    public void startCommandMenu() {
        this.menuPanel.removeAll();
        this.menuPanel.revalidate();
        this.menuPanel.repaint();
        this.menuPanel.add(this.command1);
        this.menuPanel.add(this.command2);
        this.menuPanel.add(this.command3);
        this.menuPanel.add(this.btBack);
    }

    @Override
    public void startView() {
        this.window.setVisible(true);
        this.startMenu();
    }

}
