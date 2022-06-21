package escapefromuniversity.menu;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import escapefromuniversity.inGame.WindowSet;

import static escapefromuniversity.utilities.LauncherResizer.screenHeight;
import static escapefromuniversity.utilities.LauncherResizer.screenWidth;

public class MenuViewImpl implements MenuView {
	
	private final JFrame window = new JFrame();
	private final MenuController controller;
	private final JLayeredPane menuPanel;
	
	private final WindowSet windowSet = new WindowSet();
	private final double windowRatio = windowSet.getWindowRatio();
	
	private final Rectangle retBtExit = new Rectangle((int) (WindowSet.NATIVE_WIDTH / 4 * windowRatio), (int) (300 * windowRatio), (int) (300 * windowRatio), (int) (90 * windowRatio));
	private final Rectangle retBtResume = new Rectangle((int) (WindowSet.NATIVE_WIDTH / 4 * windowRatio), (int) (400 * windowRatio), (int) (300 * windowRatio), (int) (90 * windowRatio));
	private final Rectangle retBtCommand = new Rectangle((int) (WindowSet.NATIVE_WIDTH / 4 * windowRatio), (int) (500 * windowRatio), (int) (300 * windowRatio), (int) (90 * windowRatio));
	
	private final JButton btExit = new JButton("EXIT");
	private final JButton btResume = new JButton("RESUME");
	private final JButton btCommand = new JButton("COMMAND");
	
	public MenuViewImpl(MenuController controller) {
		this.controller = controller;
		this.window.setTitle("EscapeFromUniversity");
		this.window.setResizable(false);
		this.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.menuPanel = new JLayeredPane();
		this.startMenu();
	}
	
	public void startMenu() {
		this.btExit.setBounds(this.retBtExit);
		this.btResume.setBounds(this.retBtResume);
		this.btCommand.setBounds(this.retBtCommand);
		this.window.getContentPane().add(this.menuPanel);
		this.window.setSize((int) (screenWidth * windowRatio), (int) (screenHeight * windowRatio));
		this.btExit.addActionListener(e -> this.controller.exit());
		this.btResume.addActionListener(e -> this.controller.resume());
		this.btCommand.addActionListener(e -> this.controller.getCommand());
		this.menuPanel.add(this.btExit);
		this.menuPanel.add(this.btResume);
		this.menuPanel.add(this.btCommand);
	}

}
