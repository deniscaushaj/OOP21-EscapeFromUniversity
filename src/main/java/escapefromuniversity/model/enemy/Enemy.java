package escapefromuniversity.model.enemy;

import escapefromuniversity.model.DynamicGameObject;


/**
 * 
 * interface Enemy as extension of DynamicGameObject.
 *
 */
public interface Enemy extends DynamicGameObject{
	
	/**
	 * if possible, shoot
	 */
	void maybeShoot();
	
	/**
	 * 
	 * @return the life of enemy
	 */
	int getLife();
	
	/**
	 * 
	 * @param damage
	 */
	void takeDamage(int damage);

}
