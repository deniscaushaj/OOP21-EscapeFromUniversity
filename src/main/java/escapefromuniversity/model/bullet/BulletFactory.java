package escapefromuniversity.model.bullet;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;

public interface BulletFactory {
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param direction : the direction the bullet will go
	 * @return player bullet.
	 */
	Bullet createPlayerBullet(Point2D startPosition, Vector2D direction);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param direction : the direction the bullet will go
	 * @return boss1 bullet.
	 */
	Bullet createBoss1Bullet(Point2D startPosition, Vector2D direction);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param direction : the direction the bullet will go
	 * @return boss2 bullet.
	 */
	Bullet createBoss2Bullet(Point2D startPosition, Vector2D direction);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param direction : the direction the bullet will go
	 * @return boss3 bullet.
	 */
	Bullet createBoss3Bullet(Point2D startPosition, Vector2D direction);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param direction : the direction the bullet will go
	 * @return boss4 bullet.
	 */
	Bullet createBoss4Bullet(Point2D startPosition, Vector2D direction);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param direction : the direction the bullet will go
	 * @return boss5 bullet.
	 */
	Bullet createBoss5Bullet(Point2D startPosition, Vector2D direction);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param direction : the direction the bullet will go
	 * @return boss6 bullet.
	 */
	Bullet createBoss6Bullet(Point2D startPosition, Vector2D direction);

}
