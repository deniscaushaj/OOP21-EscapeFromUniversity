package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

import escapefromuniversity.model.map.Room;

public interface DynamicGameObject extends StaticGameObject{
	
	/**
	 * 
	 * @return the speed of the dynamic game object
	 */
	int getSpeed();
	
	
	/**
	 * 
	 * @return the direction of the dynamic game object represented with a Vectro2D
	 */
	Vector2D getDirection();
	
	/**
	 * 
	 * @param newDirection : the new direction of the dynamic game object represented with a Vectro2D
	 */
	void setDirection(Vector2D newDirection);
	
	/**
	 * 
	 * @param newPosition : the new position of the new direction of the dynamic game object represented with a Vectro2D represented with a Point2D
	 */
	void setPosition(Point2D newPosition);
	
	void update(double deltaTime);
	
	/**
	 * 
	 * @return the room of the dynamic game 
	 */
	Room getRoom();

}
