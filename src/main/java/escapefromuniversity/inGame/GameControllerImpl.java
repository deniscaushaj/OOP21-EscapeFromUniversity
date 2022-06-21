package escapefromuniversity.inGame;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import escapefromuniversity.WriteFile;
import escapefromuniversity.input.KeyHandler;
import escapefromuniversity.input.KeyHandlerImpl;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.GameModelImp;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.enemy.Boss;
import escapefromuniversity.quiz.QuizController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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
				this.goQuiz(this.model.getCurrentBoss());
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
		if(this.getGameState() == GameState.WIN) {
			this.saveScore(this.model.finalMark());
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
	private void goQuiz(Boss boss) {
		try {
		    final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Quiz.fxml"));
			final Parent startRoot = loader.load();
			final QuizController quizControl = loader.getController();
			quizControl.getParameters(boss, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	
	private void saveScore(int mark) {
		try {
			WriteFile w = new WriteFile("score", "score.txt");
			DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			w.writeNewLine("" + dtf4.format(LocalDateTime.now()) + "      SCORE:  " + mark);
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
