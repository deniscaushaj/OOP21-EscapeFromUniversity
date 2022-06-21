package escapefromuniversity.menu;

import javax.swing.JFrame;

public class MenuViewImpl implements MenuView {
	
	private final JFrame window = new JFrame();
	private final MenuController controller;
	
	public MenuViewImpl(MenuController controller) {
		this.controller = controller;
	}

}
