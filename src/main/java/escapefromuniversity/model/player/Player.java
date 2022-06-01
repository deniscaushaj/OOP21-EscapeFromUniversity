package escapefromuniversity.model.player;

import escapefromuniversity.model.gameObject.DynamicGameObject;

public interface Player extends DynamicGameObject{
	
	/**
	 * @return the max life of the Player.
	 */
	int getMaxLife();
	
	/**
	 * @return the current life of the Player.
	 */
	int getLife();
	
	/**
	 * @return the current credits of the Player.
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
	 * @param damage to inflict to the Player's life.
	 */
	void takeDamage(int damage);

	/**
	 * @return <code>true</code> if the Player can shoot.
	 */
	boolean canShoot();
	
	/**
	 * Makes the Player shoot.
	 */
	void shoot();
	
//	void setNewBuff();
	
	/**
<<<<<<< Updated upstream
	 * @return <code>true</code> if the Player can shoot.
	 */
	boolean canShoot();
	
	/**
	 * The Player shoots.
	 */
	void shoot();
=======
	 * Increments {@link PlayerImpl#passed}.
	 */
	void passedExam();
>>>>>>> Stashed changes
	
	/**
	 * @return <code>true</code> if the Player is dead.
	 */
	boolean isDead();
	
	/**
	 * @return <code>true</code> if the Player is graduated.
	 */
	boolean isGraduated();

}
