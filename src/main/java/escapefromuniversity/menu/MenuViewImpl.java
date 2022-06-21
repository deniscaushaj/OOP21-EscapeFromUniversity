package escapefromuniversity.menu;

import java.awt.Rectangle;
import java.awt.Color;

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
	private final JLayeredPane commandPanel;
	
	private final WindowSet windowSet = new WindowSet();
	private final double windowRatio = windowSet.getWindowRatio();
	
	private final Rectangle retBtExit = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (300 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
	private final Rectangle retBtResume = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (400 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
	private final Rectangle retBtCommand = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (500 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
	private final Rectangle retBtBack = new Rectangle((int) (screenWidth / 3 * windowRatio), (int) (500 * windowRatio), (int) (screenWidth / 3 * windowRatio), (int) (90 * windowRatio));
	
	private final JButton btExit = new JButton("EXIT");
	private final JButton btResume = new JButton("RESUME");
	private final JButton btCommand = new JButton("COMMAND");
	private final JButton btBack = new JButton("COMMAND");
	
	public MenuViewImpl(MenuController controller) {
		this.controller = controller;
		this.window.setTitle("EscapeFromUniversity");
		this.window.setResizable(false);
		this.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.menuPanel = new JLayeredPane();
		this.menuPanel.setOpaque(false);
		this.commandPanel = new JLayeredPane();
		this.commandPanel.setOpaque(false);
		this.startMenu();
	}
	
	@Override
	public void startMenu() {
	    this.window.remove(commandPanel);
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
		this.window.setVisible(true);
	}
	
	@Override
	public void close() {
		this.window.setVisible(false);
	}

	@Override
	public void startCommandMenu() {
		this.window.remove(menuPanel);
		this.btBack.setBounds(this.retBtBack);
		this.window.getContentPane().add(this.commandPanel);
		this.window.setSize((int) (screenWidth * windowRatio), (int) (screenHeight * windowRatio));
		this.btBack.addActionListener(e -> this.controller.back());
		this.commandPanel.add(this.btBack);
		this.window.setVisible(true);
	}

}
