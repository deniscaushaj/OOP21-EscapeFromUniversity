package escapefromuniversity.inGame;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import escapefromuniversity.model.GameModel;

public class GameControllerImp implements GameController{
	private final GameModel model;
	private final GameView view;
	private List<Integer> gameObjID = new LinkedList();
	
	public GameControllerImp(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
		this.view.setGameController(this);
	}
	

	@Override
	public void GameLoop() {
		long lastTime = System.currentTimeMillis();
		while(continueGame()) {
			long currentTime = System.currentTimeMillis();
			long deltaTime = currentTime - lastTime;
			this.updateModel(deltaTime);
			this.view.update();
			lastTime = currentTime;
		}
		if(this.model.isWin()) {
			this.view.isWin();
		}else {
			this.view.isLost();
		}
		
	}
	
	private boolean continueGame() {
		return !this.model.isLost() && !this.model.isWin();
	}
	
	private void updateModel(long deltaTime) {
		this.model.updateGame((double) deltaTime);
		this.gameObjID = this.getGameObjectID();
	}
	
	private List<Integer> getGameObjectID(){
		return this.model.getAllGameObj().stream()
				.map(obj -> obj.getID())
				.collect(Collectors.toList());
	}


	@Override
	public int getPlayerLife() {
		return this.model.getPlayer().getLife();
	}


	@Override
	public int getPlayerCredits() {
		return this.model.getPlayer().getCredits();
	}

}
