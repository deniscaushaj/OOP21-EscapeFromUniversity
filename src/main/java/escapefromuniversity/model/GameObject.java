package escapefromuniversity.model;

public interface GameObject {
	
	Point2D getObjectPosition();
	
	int getID();
	
	void setID(int id);
	
	GameObjectType getType();
	
}
