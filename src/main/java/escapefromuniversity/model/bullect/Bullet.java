package escapefromuniversity.model.bullect;

import escapefromuniversity.model.DynamicGameObject;


/**
 * 
 * interface bullet as extension of DynamicGameObject.
 *
 */
public interface Bullet extends DynamicGameObject{
	
	/**
	 * 
	 * @return the bullet damage.
	 */
	int getDamage();

}
