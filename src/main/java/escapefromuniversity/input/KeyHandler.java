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
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
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
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
            }
        }
    }

}
