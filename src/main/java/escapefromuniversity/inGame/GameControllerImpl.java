package escapefromuniversity.inGame;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import escapefromuniversity.WriteFile;
import escapefromuniversity.controller.map.LayersControllerImpl;
import escapefromuniversity.input.KeyHandler;
import escapefromuniversity.input.KeyHandlerImpl;
import escapefromuniversity.launcher.LauncherView;
import escapefromuniversity.menu.MenuController;
import escapefromuniversity.menu.MenuControllerImpl;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.GameModelImpl;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.enemy.BossFactoryImpl;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.quiz.QuizController;
import escapefromuniversity.utilities.LauncherResizer;
import escapefromuniversity.utilities.OSFixes;
import escapefromuniversity.view.map.MapLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Implements all the methods defined in its interface {@link GameController}.
 */
public class GameControllerImpl implements GameController {
    private static final long DELTA = 1000;
    private static final double MILLI_TO_SECOND = 0.001;
    private final GameModel gameModel;
    private GameView gameView;
    private final KeyHandler keyHandler;
    private final ShopController shopController;
    private final MenuController menuController = new MenuControllerImpl(this);
    private final LayersControllerImpl layersController;
    private GameState gameState;
    private GameState prevGameState;
    private List<Integer> gameObjID = new LinkedList<>();

	/**
	 * Instantiates a new GameController and initializes the corresponding GameModel and GameView and KeyHandler making the game start.
	 */
	public GameControllerImpl() {
		this.gameModel = new GameModelImpl(this);
		this.gameView = new GameViewImpl(this, this.gameModel.getPlayer());
		this.gameObjID = this.getGameObjectID();
		this.checkSpriteAnimation();
		this.gameView.updateView();
        this.shopController = new ShopControllerImpl(this, this.gameModel);
        this.layersController = new LayersControllerImpl(this.gameModel.getMap().getMap(), this.gameModel.getPlayer());
		this.keyHandler = new KeyHandlerImpl(this.gameModel, this, this.shopController, this.menuController);
		this.setGameState(GameState.PLAY);
        this.keyHandler.setAllInactive();
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
            case SHOP_ROOM:
                long deltaTime = currentTime - lastTime;
                //executeInput();
                this.updateModel(deltaTime);
                this.updateView();
                this.waitTime();
                break;
            case QUIZ:
            	BossFactoryImpl fabbrica = new BossFactoryImpl();
            	Boss bossUno = fabbrica.createBoss1(new Point2D(0, 0), new Vector2D(0, 0), null);
                this.startQuiz(bossUno);
                break;
            case MENU:
                executeInput();
                this.menuController.startView();
                break;
            case SHOP_MENU:
                executeInput();
                this.shopController.startView();
                break;
            default:
                break;
            }
            lastTime = currentTime;
        }
        if (this.getGameState() == GameState.WIN) {
            this.saveScore(this.gameModel.getPlayerFinalMark());
        }
        this.gameView.end(this.getGameState());
    }

    private void waitTime() {
        try {
            Thread.sleep(DELTA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* Checks if the player has won the game or if he lost and returns true if the game is not finished, false otherwise. */
    private boolean continueGame() {
        return this.getGameState() != GameState.LOST && this.getGameState() != GameState.WIN;
    }

    /* Calls the update method in the model. */
    private void updateModel(final long deltaTime) {
        this.gameModel.updateGame((double) deltaTime * MILLI_TO_SECOND);
    }

    /* Returns a list with all the IDs of the game objects. */
    private List<Integer> getGameObjectID() {
        return this.gameModel.getAllDynamicGameObj().stream()
                .map(GameObject::getID)
                .collect(Collectors.toList());
    }

    /* Updates the view. */
    private void updateView() {
        this.checkSpriteAnimation();
        this.gameObjID = this.getGameObjectID();
        //this.gameView.updateView();
        if (layersController.isShop()) {
            this.setGameState(GameState.SHOP_ROOM);
        }
    }

    /*  */
    private void checkSpriteAnimation() {
        final List<Integer> ids = this.getGameObjectID();
        for (final Integer id : ids) {
            if (!this.gameObjID.contains(id)) {
                this.gameView.removeSpriteAnimation(id);
            } else {
                if (this.gameView.containThisID(id)) {
                    this.gameView.updateSpriteAnimation(id, this.gameModel.getPositionOfID(id), this.gameModel.getStateID(id));
                } else {
                    this.gameView.addSpriteAnimation(id, this.gameModel.getStateID(id), this.gameModel.getTypeID(id), this.gameModel.getHitBoxID(id), this.gameModel.getPositionOfID(id));
                }
            }
        }
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void startQuiz(final Boss boss) {
        //QuizView.startQuizCompetition();
    	try {
			FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/Quiz.fxml"));
			Parent gameRoot;
			gameRoot = loader.load();
			Scene quiz = new Scene(gameRoot, LauncherResizer.sceneWidth, LauncherResizer.sceneHeight);
			LauncherView.launcherWindow.setScene(quiz);
			final QuizController quizController = new QuizController(boss, this.gameModel.getPlayer());
            loader.setController(quizController);
           
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGameState(final GameState gameState) {
        this.prevGameState = this.gameState;
        this.gameState = gameState;
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
    public GameState getPrevGameState() {
        return prevGameState;
    }

    /* Calls the key handler to execute a command. */
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

    /* Saves the final mark and its date and time in the leaderboard text file. */
    private void saveScore(final int mark) {
        try {
            WriteFile w = new WriteFile("EscapeFromUniversity", "score.txt");
            DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            w.writeNewLine(mark + "\t\t" + dtf4.format(LocalDateTime.now()));
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player getPlayer() {
        return this.gameModel.getPlayer();
    }

}
