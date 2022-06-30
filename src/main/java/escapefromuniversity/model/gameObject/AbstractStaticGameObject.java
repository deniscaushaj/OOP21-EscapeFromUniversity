package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.map.Rectangle;
import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.HitBoxImpl;
import escapefromuniversity.model.basics.Point2D;

import java.awt.*;

public abstract class AbstractStaticGameObject implements StaticGameObject{
	
	private int id;
	private final GameObjectType type;
	private final Point2D bottomRightCorner;
	private final Point2D topLeftCorner;
	//private final HitBoxImpl box;
	private GameInit map;
	private Rectangle rectangle;
	
	public AbstractStaticGameObject(GameObjectType type, Point2D topLeftCorner, Point2D bottomRightCorner, GameInit map) {
		this.type = type;
		this.topLeftCorner = topLeftCorner;
		this.bottomRightCorner = bottomRightCorner;
		this.rectangle = new HitBoxImpl(topLeftCorner, bottomRightCorner);
		this.map = map;
	}
	
	@Override
	public Point2D getObjectPosition() {
		return new Point2D(topLeftCorner);
	}

	@Override
	public int getID() {
		return this.id;
	}

	@Override
	public void setID(final int id) {
		this.id = id;
		
	}

	@Override
	public GameObjectType getType() {
		return this.type;
	}
    
	@Override
	public boolean collisionWithCheck(final GameObject gObj2) {
		return this.getObjectHitBox().isColliding(gObj2.getObjectHitBox());
	}
	
	@Override
	public abstract void collisionWith(final GameObject gObj2);
	
	@Override
	public HitBox getObjectHitBox() {
		return new HitBoxImpl(this.topLeftCorner, this.bottomRightCorner);
	}

	@Override
	public GameInit getMap() {
		return this.map;
	}

	public Rectangle getRectangle() {
		return this.rectangle;
	}

}
