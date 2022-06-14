package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.HitBox;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.map.Room;

public interface GameObject {
	
	/**
	 * 
	 * @return the hit box of the game object
	 */
	HitBox getObjectHitBox();
	
	/**
	 * 
	 * @return the position of the game object represented with a Point2D
	 */
	Point2D getObjectPosition();
	
	/**
	 * 
	 * @return the ID of the game object
	 */
	int getID();
	
	/**
	 * 
	 * @param id : the ID of the game object
	 */
	void setID(int id);
	
	/**
	 * 
	 * @return the type of the game object
	 */
	GameObjectType getType();
	
	void collisionWith(GameObject gObj2);
	
	/**
	 * 
	 * @param another game object to check if is colliding
	 * @return true if the game objects are colliding
	 */
	public boolean collisionWithCheck(final GameObject gObj2);
	
	Room getRoom();
	
	
}
