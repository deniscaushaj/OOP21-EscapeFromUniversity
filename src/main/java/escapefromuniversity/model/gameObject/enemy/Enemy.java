package escapefromuniversity.model.gameObject.enemy;

import escapefromuniversity.model.gameObject.DynamicGameObject;


/**
 * 
 * interface Enemy as extension of DynamicGameObject.
 *
 */
public interface Enemy extends DynamicGameObject {

    /**
     * if possible, shoot.
     */
    void maybeShoot(double deltaTime);

    /**
     * 
     * @return the life of enemy.
     */
    int getLife();

    /**
     * 
     * @param damage
     */
    void takeDamage(int damage);

}
