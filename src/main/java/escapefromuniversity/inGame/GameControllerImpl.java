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
import escapefromuniversity.model.shop.ShopController;
import escapefromuniversity.model.shop.ShopControllerImpl;
import escapefromuniversity.quiz.QuizView;

/**
 * 
 * class control game.
 *
 */
public class GameControllerImpl implements GameController {
	private final GameModel gameModel;
	//private final GameView gameView;
	private final ControllerView controllerView;
	private final KeyHandler keyHandler;
	private GameState gameState;
    private GameState prevGameState;
	private List<Integer> gameObjID = new LinkedList();
	private final MenuController menuController = new MenuControllerImpl(this);
	private final ShopController shopController = new ShopControllerImpl(this);

	/**
	 * 
	 */
	public GameControllerImpl() {
		this.gameModel = new GameModelImp(this);
		this.controllerView = new ControllerViewImpl(this);
		//this.gameView = new GameViewImpl(this);
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
                //this.gameView.update();
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
            case SHOP:
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
        //this.gameView.end(this.getGameState());
    }

    private boolean continueGame() {
        return this.getGameState() != GameState.LOST && this.getGameState() != GameState.WIN;
    }

    private void updateModel(final long deltaTime) {
        this.gameModel.updateGame((double) deltaTime);
        this.gameObjID = this.getGameObjectID();
    }

    private List<Integer> getGameObjectID() {
        return this.gameModel.getAllGameObj().stream()
                .map(obj -> obj.getID())
                .collect(Collectors.toList());
    }

    private void chekSpriteAnimation() {
        final List<Integer> ids = this.getGameObjectID();
        for (final Integer id : ids) {
            if (!this.gameObjID.contains(id)) {
                this.controllerView.remuveSpriteAnimation(id);
            } else {
                if (this.controllerView.containThisID(id)) {
                    //final Point2D position = new 
                    this.controllerView.updateSpriteAnimation(id, null);
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

    @Override
    public void startQuiz() {
        QuizView.startQuizCompetition();
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
        this.prevGameState = this.gameState;
        this.gameState = gameState;
    }

    @Override
    public GameState getPrevGameState() {
        return prevGameState;
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
