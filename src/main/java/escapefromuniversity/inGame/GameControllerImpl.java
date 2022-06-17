package escapefromuniversity.inGame;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import escapefromuniversity.input.KeyHandler;
import escapefromuniversity.input.KeyHandlerImpl;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.GameModelImp;

public class GameControllerImpl implements GameController{
	private final GameModel model;
	private final GameView view;
	private final KeyHandler keyHandler;
	private List<Integer> gameObjID = new LinkedList();
	
	public GameControllerImpl() {
		this.model = new GameModelImp(this);
		this.view = new GameViewImpl();
		this.view.setGameController(this);
		this.keyHandler = new KeyHandlerImpl(this.model, this);
	}
	

	@Override
	public void GameLoop() {
		long lastTime = System.currentTimeMillis();
		while(continueGame()) {
			long currentTime = System.currentTimeMillis();
			long deltaTime = currentTime - lastTime;
			executeInput();
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


	@Override
	public void goQuiz() {
		// TODO Auto-generated method stub
		
	}

	private void executeInput() {
		this.keyHandler.executeCommand();
	}

	@Override
	public void pressKey(final KeyEvent key) {
		this.keyHandler.setKey(key.getKeyCode(), true);
	}

	@Override
	public void releaseKey(final KeyEvent key) {
		this.keyHandler.setKey(key.getKeyCode(), false);
	}

}
