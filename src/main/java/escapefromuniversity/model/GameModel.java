package escapefromuniversity.model;

import java.util.List;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.player.Player;

public interface GameModel {
	
	
	/**
	 * 
	 * @return a list of all GameObject in game.
	 */
	List<GameObject> getAllGameObj();
	
	/**
	 * 
	 * @param deltaTime : time since the last update.
	 */
	void updateGame(double deltaTime);
	
	
	void isWin();
	
	
	void isLost();
	
	/**
	 * 
	 * @return the Player object.
	 */
	Player getPlayer();
	
	
	Point2D getPositionOfID(int id);
	
	void goQuiz(Boss boss);
	
	void goShop();
	
	int finalMark();
	
	Boss getCurrentBoss();
	

}
