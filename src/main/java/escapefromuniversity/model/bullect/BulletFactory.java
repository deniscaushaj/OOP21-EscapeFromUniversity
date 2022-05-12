package escapefromuniversity.model.bullect;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public interface BulletFactory {
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param Diration : the direction the bullet will go
	 * @return protagonist bullet
	 */
	Bullet createProtagonistBullet(Point2D startPosition, Vector2D Diration);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param Diration : the direction the bullet will go
	 * @return boss1 bullet
	 */
	Bullet createBoss1Bullet(Point2D startPosition, Vector2D Diration);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param Diration : the direction the bullet will go
	 * @return boss2 bullet
	 */
	Bullet createBoss2Bullet(Point2D startPosition, Vector2D Diration);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param Diration : the direction the bullet will go
	 * @return boss3 bullet
	 */
	Bullet createBoss3Bullet(Point2D startPosition, Vector2D Diration);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param Diration : the direction the bullet will go
	 * @return boss4 bullet
	 */
	Bullet createBoss4Bullet(Point2D startPosition, Vector2D Diration);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param Diration : the direction the bullet will go
	 * @return boss5 bullet
	 */
	Bullet createBoss5Bullet(Point2D startPosition, Vector2D Diration);
	
	/**
	 * @param startPosition : initial position of the bullet
	 * @param Diration : the direction the bullet will go
	 * @return boss6 bullet
	 */
	Bullet createBoss6Bullet(Point2D startPosition, Vector2D Diration);

}
