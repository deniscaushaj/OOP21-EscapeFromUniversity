package escapefromuniversity.inGame;

import escapefromuniversity.model.GameState;

import java.awt.event.KeyEvent;

/**
 * 
 * interface game control.
 *
 */
public interface GameController {

    /**
     * main game loop.
     */
    void gameLoop();

    /**
     * 
     * @return life of player
     */
    int getPlayerLife();

    /**
     * 
     * @return credits of player
     */
    int getPlayerCredits();

    void startQuiz();

    /**
     * 
     * @return current gameState.
     */
    GameState getGameState();

    /**
     * 
     * @param gameState : new gameState.
     */
    void setGameState(GameState gameState);

    /**
     * 
     * @param key
     */
    void pressKey(KeyEvent key);

    /**
     * 
     * @param key
     */
    void releaseKey(KeyEvent key);

    GameState getPrevGameState();
}
