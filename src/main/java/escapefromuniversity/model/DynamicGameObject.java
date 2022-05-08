package escapefromuniversity.model;

public interface DynamicGameObject extends StaticGameObject{
	
	int getSpeed();
	
	Vector2D getDirection();
	
	void setDirection(Vector2D newDirection);

}
