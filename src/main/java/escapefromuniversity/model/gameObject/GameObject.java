package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.HitBox;
import escapefromuniversity.model.Point2D;

public interface GameObject {
	
	HitBox getObjectHitBox();
	
	Point2D getObjectPosition();
	
	int getID();
	
	void setID(int id);
	
	GameObjectType getType();
	
	void collisionWith(GameObject gObj2);
	
	public boolean collisionWithCheck(final GameObject gObj2);
	
	
}
