package escapefromuniversity.inGame;

import escapefromuniversity.model.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The listener class of the game that implements the Java interface {@link KeyListener}.
 * It detects any keyboard button pressed and calls the respective methods.
 */
public class GameKeyListener implements KeyListener {

    private final GameController gameController;

    /**
     * Instantiates the key listener and assigns to it a game controller.
     * @param gameController the game controller to assign to this key listener.
     */
    public GameKeyListener(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTyped(KeyEvent key) {
    }

    /**
     {@inheritDoc}
     */
    @Override
    public void keyPressed(KeyEvent key) {
        if(this.gameController != null) {
            this.gameController.pressKey(key);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyReleased(KeyEvent key) {
        if(this.gameController != null) {
            this.gameController.releaseKey(key);
        }
    }

    /**
     * Sets the game state to the menu state.
     */
    public void openMenu() {
        this.gameController.setGameState(GameState.MENU);
    } // TODO move from here

}
