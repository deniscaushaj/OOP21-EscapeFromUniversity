package escapefromuniversity.inGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

    private GameController gameController;

    public GameKeyListener(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void keyTyped(KeyEvent key) {
    }

    @Override
    public void keyPressed(KeyEvent key) {
        if(this.gameController != null) {
            this.gameController.pressKey(key);
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {
        if(this.gameController != null) {
            this.gameController.releaseKey(key);
        }
    }

}
