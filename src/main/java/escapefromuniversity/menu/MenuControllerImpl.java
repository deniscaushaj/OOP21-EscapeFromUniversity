package escapefromuniversity.menu;

import escapefromuniversity.inGame.GameController;

public class MenuControllerImpl implements MenuController{
	private final GameController gameController;
	private final MenuView view;
	
	public MenuControllerImpl(final GameController gameController) {
		this.gameController = gameController;
		this.view = new MenuViewImpl();
	}

	@Override
	public void getCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		System.exit(0);
		
	}

	@Override
	public void resume() {
		
	}

}
