package escapefromuniversity.inGame;

public class GameViewImpl implements GameView{
		this.window.addKeyListener(this);

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isLost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isWin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGameController(GameController controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent key) {
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if(this.controller != null) {
			this.controller.pressKey(key);
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if(this.controller != null) {
			this.controller.releaseKey(key);
		}
	}
}
