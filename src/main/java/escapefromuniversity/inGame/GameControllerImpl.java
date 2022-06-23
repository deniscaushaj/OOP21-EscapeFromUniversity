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
import escapefromuniversity.menu.MenuController;
import escapefromuniversity.menu.MenuControllerImpl;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.GameModelImp;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.shop.ShopController;
import escapefromuniversity.model.shop.ShopControllerImpl;
import escapefromuniversity.quiz.QuizView;

public class GameControllerImpl implements GameController{
	private final GameModel gameModel;
	private final GameView gameView;
	private final KeyHandler keyHandler;
	private GameState gameState;
	private List<Integer> gameObjID = new LinkedList();
	private final MenuController menuController = new MenuControllerImpl(this);
	private final ShopController shopController = new ShopControllerImpl();

	public GameControllerImpl() {
		this.gameModel = new GameModelImp(this);
		this.gameView = new GameViewImpl(this);
		this.keyHandler = new KeyHandlerImpl(this.gameModel, this);
		this.setGameState(GameState.PLAY);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void gameLoop() {
		long lastTime = System.currentTimeMillis();
		while (continueGame()) {
			long currentTime = System.currentTimeMillis();
			switch (this.getGameState()) {
			case PLAY:
			case FIGHT:
			case GRADUATED:
				long deltaTime = currentTime - lastTime;
				executeInput();
				this.updateModel(deltaTime);
				this.gameView.update();
				break;
			case QUIZ:
				this.gameView.addPauseBG();
				this.startQuiz();
				break;
			case MENU:
				this.gameView.addPauseBG();
				this.menuController.startView();
				break;
			case SHOP:
				this.gameView.addPauseBG();
				this.startShop();
				break;
			default:
				break;
			}
			lastTime = currentTime;
		}
<<<<<<< HEAD
		if (this.getGameState() == GameState.WIN) {
			this.saveScore(this.model.finalMark());
		}
		this.view.update();
=======
		if(this.getGameState() == GameState.WIN) {
			this.saveScore(this.gameModel.getPlayerFinalMark());
		}
		this.gameView.update();
		
>>>>>>> 28b48d560cae2d45051231d63b55518ba541de03
	}
	
	
	private boolean continueGame() {
		return this.getGameState() != GameState.LOST && this.getGameState() != GameState.WIN;
	}
	
<<<<<<< HEAD
	private void updateModel(final long deltaTime) {
		this.model.updateGame((double) deltaTime);
		this.gameObjID = this.getGameObjectID();
	}
	
	private List<Integer> getGameObjectID() {
		return this.model.getAllGameObj().stream()
=======
	private void updateModel(long deltaTime) {
		this.gameModel.updateGame((double) deltaTime);
		this.gameObjID = this.getGameObjectID();
	}
	
	private List<Integer> getGameObjectID(){
		return this.gameModel.getAllGameObj().stream()
>>>>>>> 28b48d560cae2d45051231d63b55518ba541de03
				.map(obj -> obj.getID())
				.collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPlayerLife() {
		return this.gameModel.getPlayer().getLife();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPlayerCredits() {
		return this.gameModel.getPlayer().getCredits();
	}

<<<<<<< HEAD
	private void goQuiz(final Boss boss) {
		try {
		    final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Quiz.fxml"));
			final Parent startRoot = loader.load();
			final QuizController quizControl = loader.getController();
			quizControl.setParameters(boss, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
=======
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startQuiz() {
		QuizView.startQuizCompetition();
	}

	@Override
	public void startShop() {
//		TODO start shop
>>>>>>> 28b48d560cae2d45051231d63b55518ba541de03
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameState getGameState() {
		return gameState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGameState(final GameState gameState) {
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
	
	private void saveScore(final int mark) {
		try {
			WriteFile w = new WriteFile("score", "score.txt");
			DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			w.writeNewLine(mark + "\t\t" + dtf4.format(LocalDateTime.now()));
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
