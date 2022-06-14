package escapefromuniversity.model.enemy;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.map.Room;

public interface BossFactory {
	
	Enemy createBoss1(Point2D position, Vector2D direction, Room room);
	Enemy createBoss2(Point2D position, Vector2D direction, Room room);
	Enemy createBoss3(Point2D position, Vector2D direction, Room room);
	Enemy createBoss4(Point2D position, Vector2D direction, Room room);
	Enemy createBoss5(Point2D position, Vector2D direction, Room room);
	Enemy createBoss6(Point2D position, Vector2D direction, Room room);
}
