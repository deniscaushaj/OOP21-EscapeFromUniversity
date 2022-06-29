package escapefromuniversity.inGame;

import escapefromuniversity.model.GameState;
import escapefromuniversity.model.gameObject.enemy.Boss;

import java.awt.event.KeyEvent;

/**
 * 
 * This is the interface of the game. It contains all the methods to make the model and the view work.
 *
 */
public interface GameController {

    /**
     * The main loop of the game.
     */
    void gameLoop();

    /**
     * Returns the current life of the player.
     * @return the current life of the player.
     */
    int getPlayerLife();

    /**
     * Returns the current credits of the player.
     * @return the current credits of the player.
     */
    int getPlayerCredits();

    /**
     * Launches the view of an exam's quiz.
     * @param boss the boss quiz.
     */
    void startQuiz(Boss boss);

    /**
     * Returns the current game state.
     * @return the current game state.
     */
    GameState getGameState();

    /**
     * Sets a new game state.
     * @param gameState the new game state to set.
     */
    void setGameState(GameState gameState);

    /**
     * Returns the previous game state.
     * @return the previous game state.
     */
    GameState getPrevGameState();

    /**
     * Makes the key handler manage the key pressed.
     * @param key the keyboard button pressed.
     */
    void pressKey(KeyEvent key);

    /**
     * Makes the key handler manage the key released.
     * @param key the keyboard button released.
     */
    void releaseKey(KeyEvent key);


}
