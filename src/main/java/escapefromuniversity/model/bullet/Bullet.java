package escapefromuniversity.model.bullet;

import escapefromuniversity.model.gameObject.DynamicGameObject;


/**
 * 
 * Interface Bullet as extension of DynamicGameObject.
 *
 */
public interface Bullet extends DynamicGameObject{
	
	/**
	 * 
	 * @return the bullet damage.
	 */
	int getDamage();

}
