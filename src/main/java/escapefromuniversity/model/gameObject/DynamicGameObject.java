package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

import escapefromuniversity.model.map.Room;

public interface DynamicGameObject extends StaticGameObject{
	
	int getSpeed();
	
	Vector2D getDirection();
	
	void setDirection(Vector2D newDirection);
	
	void setPosition(Point2D newPosition);
	
	void update(double deltaTime);
	
	Room getRoom();

}
