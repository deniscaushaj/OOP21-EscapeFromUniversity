package escapefromuniversity.model;

public interface DynamicGameObject extends GameObject{
	
	int getSpeed();
	
	Vector2D getDyrection();
	
	void setDyrectino(Vector2D newDyrection);

}
