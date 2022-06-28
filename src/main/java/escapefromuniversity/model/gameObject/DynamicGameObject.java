package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;

public interface DynamicGameObject extends StaticGameObject{
	
	/**
	 * 
	 * @return the speed of the dynamic game object
	 */
	double getSpeed();
	
	
	/**
	 * 
	 * @return the direction of the dynamic game object represented with a Vector2D
	 */
	Vector2D getDirection();
	
	/**
	 * 
	 * @param newDirection : the new direction of the dynamic game object represented with a Vector2D
	 */
	void setDirection(Vector2D newDirection);
	
	/**
	 * 
	 * @param newPosition : the new position of the new direction of the dynamic game object represented with a Vector2D represented with a Point2D
	 */
	void setPosition(Point2D newPosition);
	
	void update(double deltaTime);
	
	void setState(State state);
	
	State getState();


}
