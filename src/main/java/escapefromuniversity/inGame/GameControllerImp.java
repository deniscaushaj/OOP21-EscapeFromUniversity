package escapefromuniversity.inGame;

import escapefromuniversity.model.GameModel;

public class GameControllerImp implements GameController{
	private final GameModel model;
	private final GameView view;
	
	public GameControllerImp(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
	}
	

	@Override
	public void GameLoop() {
		long lastTime = System.currentTimeMillis();
		while(continueGame()) {
			long currentTime = System.currentTimeMillis();
			long deltaTime = currentTime - lastTime;
			
			
			
			
			lastTime = currentTime;
		}
		
	}
	
	private boolean continueGame() {
		return !this.model.isLost() && !this.model.isWin();
	}

}
