package escapefromuniversity.model.gameObject.bullet;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.map.Room;

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
     * @param room : belonging room
     * @return player bullet.
     */
    Bullet createPlayerBullet(Point2D startPosition, Vector2D direction, int damage, Room room);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param room : belonging room
     * @return boss1 bullet.
     */
    Bullet createBoss1Bullet(Point2D startPosition, Vector2D direction, Room room);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param room : belonging room
     * @return boss2 bullet.
     */
    Bullet createBoss2Bullet(Point2D startPosition, Vector2D direction, Room room);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param room : belonging room
     * @return boss3 bullet.
     */
    Bullet createBoss3Bullet(Point2D startPosition, Vector2D direction, Room room);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param room : belonging room
     * @return boss4 bullet.
     */
    Bullet createBoss4Bullet(Point2D startPosition, Vector2D direction, Room room);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param room : belonging room
     * @return boss5 bullet.
     */
    Bullet createBoss5Bullet(Point2D startPosition, Vector2D direction, Room room);

    /**
     * @param startPosition : initial position of the bullet
     * @param direction : the direction the bullet will go
     * @param room : belonging room
     * @return boss6 bullet.
     */
    Bullet createBoss6Bullet(Point2D startPosition, Vector2D direction, Room room);

}
