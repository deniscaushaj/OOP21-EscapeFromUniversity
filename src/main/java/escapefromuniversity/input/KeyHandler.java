package escapefromuniversity.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import escapefromuniversity.game.GameState;
import escapefromuniversity.game.GameViewImpl;

public class KeyHandler implements KeyListener {

    public boolean upPressed, leftPressed, downPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (GameViewImpl.getGameState() == GameState.PLAY
                || GameViewImpl.getGameState() == GameState.FIGHT
                || GameViewImpl.getGameState() == GameState.WIN) {
            switch (key) {
                case KeyEvent.VK_W -> upPressed = true;
                case KeyEvent.VK_A -> leftPressed = true;
                case KeyEvent.VK_S -> downPressed = true;
                case KeyEvent.VK_D -> rightPressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (GameViewImpl.getGameState() == GameState.PLAY
                || GameViewImpl.getGameState() == GameState.FIGHT
                || GameViewImpl.getGameState() == GameState.WIN) {
            switch (key) {
                case KeyEvent.VK_W -> upPressed = false;
                case KeyEvent.VK_A -> leftPressed = false;
                case KeyEvent.VK_S -> downPressed = false;
                case KeyEvent.VK_D -> rightPressed = false;
            }
        }
    }

}
