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
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.quiz.QuizView;

/**
 * Implements all the methods defined in its interface {@link GameController}.
 */
public class GameControllerImpl implements GameController {
    private final GameModel gameModel;
    private final GameView gameView;
    private final KeyHandler keyHandler;
    private final ShopController shopController;
    private final MenuController menuController = new MenuControllerImpl(this);
    private GameState gameState;
    private GameState prevGameState;
    private List<Integer> gameObjID = new LinkedList<>();

	/**
	 * Instantiates a new GameController and initializes the corresponding GameModel and GameView and KeyHandler making the game start.
	 */
	public GameControllerImpl() {
		this.gameModel = new GameModelImp(this);
		this.gameView = new GameViewImpl(this);
        this.shopController = new ShopControllerImpl(this, this.gameModel);
		this.keyHandler = new KeyHandlerImpl(this.gameModel, this, this.shopController, this.menuController, this.gameView);
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
                executeInput();
                this.updateModel(deltaTime);
                this.updateView();
                break;
            case QUIZ:
                //this.gameView.addPauseBG();
                this.startQuiz();
                break;
            case MENU:
                //this.gameView.addPauseBG();
                executeInput();
                this.menuController.startView();
                break;
            case SHOP_MENU:
                //this.gameView.addPauseBG();
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

    /* Checks if the player has won the game or if he lost and returns true if the game is not finished, false otherwise. */
    private boolean continueGame() {
        return this.getGameState() != GameState.LOST && this.getGameState() != GameState.WIN;
    }

    /* Calls the update method in the model. */
    private void updateModel(final long deltaTime) {
        this.gameModel.updateGame((double) deltaTime);
    }

    /* Returns a list with all the IDs of the game objects. */
    private List<Integer> getGameObjectID() {
        return this.gameModel.getAllDynamicGameObj().stream()
                .map(obj -> obj.getID())
                .collect(Collectors.toList());
    }

    /* Updates the view. */
    private void updateView() {
        this.checkSpriteAnimation();
        this.gameObjID = this.getGameObjectID();
        this.gameView.updateView();
    }

    /*  */
    private void checkSpriteAnimation() {
        final List<Integer> ids = this.getGameObjectID();
        for (final Integer id : ids) {
            if (!this.gameObjID.contains(id)) {
                this.gameView.removeSpriteAnimation(id);
            } else {
                if (!this.gameView.containThisID(id)) {
                    final Point2D position = null;
                    this.gameView.updateSpriteAnimation(id, position, this.gameModel.getStateID(id));
                } else {
                    this.gameView.addSpriteAnimation(id, this.gameModel.getStateID(id), this.gameModel.getTypeID(id), 0, 0);
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
    public void startQuiz() {
        QuizView.startQuizCompetition();
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
            WriteFile w = new WriteFile("score", "score.txt");
            DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            w.writeNewLine(mark + "\t\t" + dtf4.format(LocalDateTime.now()));
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
