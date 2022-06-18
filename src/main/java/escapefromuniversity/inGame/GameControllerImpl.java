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
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void gameLoop() {
		long lastTime = System.currentTimeMillis();
		while(continueGame()) {
			long currentTime = System.currentTimeMillis();
			switch(this.getGameState()) {
			case PLAY:
				long deltaTime = currentTime - lastTime;
				executeInput();
				this.updateModel(deltaTime);
				this.view.update();
				break;
			case QUIZ:
				this.goQuiz();
				break;
			case MENU:
				//menu
				break;
			case SHOP:
				//shop
				break;
			default:
				break;
			}
			lastTime = currentTime;
		}
		this.view.update();
		
	}
	
	
	private boolean continueGame() {
		return this.getGameState() != GameState.LOST && this.getGameState() != GameState.WIN;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPlayerLife() {
		return this.model.getPlayer().getLife();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPlayerCredits() {
		return this.model.getPlayer().getCredits();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void goQuiz() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameState getGameState () {
		return gameState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	private void executeInput() {
		this.keyHandler.executeCommand();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void pressKey(final KeyEvent key) {
		this.keyHandler.setKey(key.getKeyCode(), true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void releaseKey(final KeyEvent key) {
		this.keyHandler.setKey(key.getKeyCode(), false);
	}

}
