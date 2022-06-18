package escapefromuniversity.inGame;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import escapefromuniversity.input.KeyHandler;
import escapefromuniversity.input.KeyHandlerImpl;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.GameModelImp;
import escapefromuniversity.model.GameState;

public class GameControllerImpl implements GameController{
	private final GameModel model;
	private final GameView view;
	private final KeyHandler keyHandler;
	private GameState gameState;
	private List<Integer> gameObjID = new LinkedList();

	public GameControllerImpl() {
		this.model = new GameModelImp(this);
		this.view = new GameViewImpl(this);
		this.keyHandler = new KeyHandlerImpl(this.model, this);
		this.setGameState(GameState.PLAY);
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
		this.view.update();
		
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

	/**
	 * @return the current game state.
	 */
	@Override
	public GameState getGameState () {
		return gameState;
	}

	/**
	 * Sets the current game state.
	 * @param gameState the game state to set.
	 */
	@Override
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
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
