package escapefromuniversity.model;

public interface DynamicGameObject extends StaticGameObject{
	
	int getSpeed();
	
	Vector2D getDirection();
	
	void setDirection(Vector2D newDirection);
	
	void setPosition(Point2D newPosition);
	
	void update(double deltaTime);

}
