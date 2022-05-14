package escapefromuniversity.model.enemy;

import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public interface BossFactory {
	
	Enemy createBoss1(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impatDamage);
	
	
	Enemy createBoss2(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impatDamage);
	
	Enemy createBoss3(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impatDamage);
	
	Enemy createBoss4(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impatDamage);
	
	Enemy createBoss5(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impatDamage);
	
	Enemy createBoss6(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impatDamage);

}
