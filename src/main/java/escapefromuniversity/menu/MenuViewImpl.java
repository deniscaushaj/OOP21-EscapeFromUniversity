package escapefromuniversity.menu;

import static escapefromuniversity.utilities.LauncherResizer.screenHeight;
import static escapefromuniversity.utilities.LauncherResizer.screenWidth;

import java.awt.Rectangle;

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

    private final Rectangle retBtExit = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (300 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtResume = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (400 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtCommand = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (500 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtBack = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (500 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtTextCommand1 = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (10 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtTextCommand2 = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (110 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
    private final Rectangle retBtTextCommand3 = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (210 * windowRatio), (int) (screenWidth / 2 * windowRatio), (int) (90 * windowRatio));

    private final JButton btExit = new JButton("EXIT");
    private final JButton btResume = new JButton("RESUME");
    private final JButton btCommand = new JButton("COMMAND");
    private final JButton btBack = new JButton("BACK");

    private final JLabel command1 = new JLabel("A/W/S/D : per muoverso");
    private final JLabel command2 = new JLabel("le freccette per sparare");
    private final JLabel command3 = new JLabel("avvicinarsi agli oggetti per interagire");

    /**
     * 
     * @param controller
     */
    public MenuViewImpl(final MenuController controller) {
        this.controller = controller;
    }

    @Override
    public void startMenu() {
        this.menuPanel.removeAll();
        this.menuPanel.revalidate();
        this.menuPanel.repaint();
        this.btExit.setBounds(this.retBtExit);
        this.btResume.setBounds(this.retBtResume);
        this.btCommand.setBounds(this.retBtCommand);
        this.btExit.setFont(WindowSet.FONT);
        this.btResume.setFont(WindowSet.FONT);
        this.btCommand.setFont(WindowSet.FONT);
        this.btExit.addActionListener(e -> this.controller.exit());
        this.btResume.addActionListener(e -> this.controller.resume());
        this.btCommand.addActionListener(e -> this.controller.getCommand());
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
        this.command1.setBounds(this.retBtTextCommand1);
        this.command1.setFont(WindowSet.FONT);
        this.menuPanel.add(this.command1);
        this.command2.setBounds(this.retBtTextCommand2);
        this.command2.setFont(WindowSet.FONT);
        this.menuPanel.add(this.command2);
        this.command3.setBounds(this.retBtTextCommand3);
        this.command3.setFont(WindowSet.FONT);
        this.menuPanel.add(this.command3);
        this.btBack.setBounds(this.retBtBack);
        this.btBack.setFont(WindowSet.FONT);
        this.btBack.addActionListener(e -> this.controller.back());
        this.menuPanel.add(this.btBack);
    }

    @Override
    public void startView() {
        this.window.setTitle("EscapeFromUniversity");
        this.window.setResizable(false);
        this.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.window.setSize((int) (screenWidth * windowRatio), (int) (screenHeight * windowRatio));
        this.menuPanel = new JLayeredPane();
        this.menuPanel.setOpaque(false);
        this.window.getContentPane().add(menuPanel);
        this.window.setVisible(true);
        this.startMenu();
    }

}
