package escapefromuniversity.inGame;

import escapefromuniversity.model.GameState;

/**
 * 
 * interface of game view.
 *
 */
public interface GameView {

    /**
     * 
     */
    void update();

    /**
     * 
     */
    void addPauseBG();

    /**
     * 
     */
    void removePauseBG();

    /**
     * 
     */
    void openMenu();

    void end(GameState gameState);
}
