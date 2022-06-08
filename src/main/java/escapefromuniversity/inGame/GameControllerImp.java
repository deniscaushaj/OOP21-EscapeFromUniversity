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
		// TODO Auto-generated method stub
		
	}

}
