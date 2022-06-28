package escapefromuniversity.model.gameObject.bullet;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.GameInit;

/**
 * 
 * Bullet factory for creation of Bullet.
 *
 */
public interface BulletFactory {

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param damage : the damage of Player Bullet
     * @param map : belonging map
     * @return player bullet.
     */
    Bullet createPlayerBullet(Point2D startPosition, Vector2D direction, int damage, GameInit map);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param map : belonging map
     * @return boss1 bullet.
     */
    Bullet createBoss1Bullet(Point2D startPosition, Vector2D direction, GameInit map);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param map : belonging map
     * @return boss2 bullet.
     */
    Bullet createBoss2Bullet(Point2D startPosition, Vector2D direction, GameInit map);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param map : belonging map
     * @return boss3 bullet.
     */
    Bullet createBoss3Bullet(Point2D startPosition, Vector2D direction, GameInit map);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param map : belonging map
     * @return boss4 bullet.
     */
    Bullet createBoss4Bullet(Point2D startPosition, Vector2D direction, GameInit map);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param map : belonging map
     * @return boss5 bullet.
     */
    Bullet createBoss5Bullet(Point2D startPosition, Vector2D direction, GameInit map);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param map : belonging map
     * @return boss6 bullet.
     */
    Bullet createBoss6Bullet(Point2D startPosition, Vector2D direction, GameInit map);

}
