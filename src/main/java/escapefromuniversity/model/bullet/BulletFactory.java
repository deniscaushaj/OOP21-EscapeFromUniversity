package escapefromuniversity.model.bullet;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public interface BulletFactory {
	
	
	Bullet createProtagonistBullet(Point2D startPosition, Vector2D Diration);
	
	Bullet createBoss1Bullet(Point2D startPosition, Vector2D Diration);
	
	Bullet createBoss2Bullet(Point2D startPosition, Vector2D Diration);
	
	Bullet createBoss3Bullet(Point2D startPosition, Vector2D Diration);
	
	Bullet createBoss4Bullet(Point2D startPosition, Vector2D Diration);
	
	Bullet createBoss5Bullet(Point2D startPosition, Vector2D Diration);
	
	Bullet createBoss6Bullet(Point2D startPosition, Vector2D Diration);

}
