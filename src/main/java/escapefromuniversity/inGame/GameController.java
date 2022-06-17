package escapefromuniversity.inGame;

import escapefromuniversity.model.GameState;

import java.awt.event.KeyEvent;

public interface GameController {
	
	
	void GameLoop();
	
	int getPlayerLife();
	
	int getPlayerCredits();
	
	void goQuiz();

	GameState getGameState();

	void setGameState(GameState gameState);

	void pressKey(KeyEvent key);

	void releaseKey(KeyEvent key);
}
