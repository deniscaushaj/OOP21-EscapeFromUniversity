package escapefromuniversity.model;

import java.util.List;

import escapefromuniversity.model.gameObject.GameObject;

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
	
	/**
	 * 
	 * @return true if you won.
	 */
	boolean isWin();
	
	/**
	 * 
	 * @return true if you lost.
	 */
	boolean isLost();
	

}
