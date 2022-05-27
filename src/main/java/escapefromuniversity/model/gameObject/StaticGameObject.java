package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.Point2D;

public interface StaticGameObject extends GameObject{

	Point2D getObjectPosition();

	int getID();

	void setID(int id);

	GameObjectType getType();

}