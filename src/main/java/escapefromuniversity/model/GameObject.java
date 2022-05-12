package escapefromuniversity.model;

public interface GameObject {
	
	HitBox getObjectHitBox();
	
	Point2D getObjectPosition();
	
	int getID();
	
	void setID(int id);
	
	GameObjectType getType();
	
	void collisionWith(GameObject gObj2);
	
	
}
