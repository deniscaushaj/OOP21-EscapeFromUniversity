package escapefromuniversity.model;

public interface StaticGameObject extends GameObject{

	Point2D getObjectPosition();

	int getID();

	void setID(int id);

	GameObjectType getType();

}