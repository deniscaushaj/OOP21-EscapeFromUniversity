package escapefromuniversity.inGame;

import java.awt.event.KeyEvent;

public interface GameController {
	
	
	void GameLoop();
	
	int getPlayerLife();
	
	int getPlayerCredits();
	
	void goQuiz();

	void pressKey(KeyEvent key);

	void releaseKey(KeyEvent key);
}
