package escapefromuniversity.menu;

import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import escapefromuniversity.utilities.WindowSet;

import static escapefromuniversity.utilities.LauncherResizer.screenHeight;
import static escapefromuniversity.utilities.LauncherResizer.screenWidth;

public class MenuViewImpl implements MenuView {
	
	private final JFrame window = new JFrame();
	private final MenuController controller;
	private final JLayeredPane menuPanel;
	
	private final double windowRatio = WindowSet.getWindowRatio();
	
	private final Rectangle retBtExit = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (300 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
	private final Rectangle retBtResume = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (400 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
	private final Rectangle retBtCommand = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (500 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
	private final Rectangle retBtBack = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (500 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
	
	private final JButton btExit = new JButton("EXIT");
	private final JButton btResume = new JButton("RESUME");
	private final JButton btCommand = new JButton("COMMAND");
	private final JButton btBack = new JButton("BACK");

	/**
	 * 
	 * @param controller
	 */
	public MenuViewImpl(final MenuController controller) {
		this.controller = controller;
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
	
	@Override
	public void startMenu() {
	    this.menuPanel.removeAll();
	    this.menuPanel.revalidate();
	    this.menuPanel.repaint();
		this.btExit.setBounds(this.retBtExit);
		this.btResume.setBounds(this.retBtResume);
		this.btCommand.setBounds(this.retBtCommand);
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

	public void startCommandMenu() {
		this.menuPanel.removeAll();
		this.menuPanel.revalidate();
		this.menuPanel.repaint();
		this.btBack.setBounds(this.retBtBack);
		this.btBack.addActionListener(e -> this.controller.back());
		this.menuPanel.add(this.btBack);
	}

}
