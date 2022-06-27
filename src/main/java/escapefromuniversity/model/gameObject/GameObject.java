package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.map.Room;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;

/**
 * The GameObject is the base class for all game objects.
 */
public interface GameObject {
	
	/**
	 * Get the Hit Box of the object.
	 * @return the hit box of the game object
	 */
	HitBox getObjectHitBox();
	
	/**
	 * Get the Position of the object.
	 * @return the position of the game object represented with a Point2D
	 */
	Point2D getObjectPosition();
	
	/**
	 * Get the ID of the object.
	 * @return the ID of the game object
	 */
	int getID();
	
	/**
	 * Set the ID of the object.
	 * @param id : the ID of the game object
	 */
	void setID(int id);
	
	/**
	 * Get the type of the object.
	 * @return the type of the game object
	 */
	GameObjectType getType();
	
	/**
	 * Manages the collision between two game objects.
	 * @param gObj2 another game object with which it's happening the collision.
	 */
	void collisionWith(GameObject gObj2);
	
	/**
	 * Checks whether this object is colliding with another object.
	 * @param gObj2 Another game object to check if is colliding
	 * @return true if the game objects are colliding
	 */
	boolean collisionWithCheck(GameObject gObj2);
	
	/**
	 * Get the room of this object.
	 * @return The room of the Game Object
	 */
	Room getRoom();
	
	
}
