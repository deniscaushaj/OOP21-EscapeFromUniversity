package escapefromuniversity.inGame;

public interface GameView {
	
	void update();
	
	void isLost();
	
	void isWin();
	
	void setGameController(GameController controller);

}