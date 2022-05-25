package escapefromuniversity.model.player;

import escapefromuniversity.model.DynamicGameObject;

public interface Player extends DynamicGameObject{
	
	/**
	 * @return the max Life of the Player.
	 */
	int getMaxLife();
	
	/**
	 * @return the current Life of the Player.
	 */
	int getLife();
	
	/**
	 * @return the current Credits of the Player.
	 */
	int getCredits();
	
	/**
	 * @param life to set for the Player.
	 */
	void setLife(int life);
	
	/**
	 * @param credits to set for the Player.
	 */
	void setCredits(int credits);
	
	/**
	 * @param damage to inflict to the Player's Life.
	 */
	void takeDamage(int damage);
	
//	void setNewBuff();
	
	/**
	 * @return true if the Player is dead.
	 */
	boolean isDead();
	
	/**
	 * @return true if the Player is graduated.
	 */
	boolean isGraduated();

}
