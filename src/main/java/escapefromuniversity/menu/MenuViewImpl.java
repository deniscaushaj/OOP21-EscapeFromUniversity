package escapefromuniversity.menu;

import javax.swing.JFrame;

public class MenuViewImpl implements MenuView {
	
	private final JFrame window = new JFrame();
	private final MenuController controller;
	
	public MenuViewImpl(MenuController controller) {
		this.controller = controller;
		this.window.setTitle("EscapeFromUniversity");
		this.window.setResizable(false);
		this.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

}
