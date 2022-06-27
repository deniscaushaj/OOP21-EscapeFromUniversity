package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.map.Rectangle;
import escapefromuniversity.model.map.Mapp;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.HitBoxImpl;
import escapefromuniversity.model.basics.Point2D;

public abstract class AbstractStaticGameObject implements StaticGameObject{
	
	private int id;
	private final GameObjectType type;
	private final Point2D position;
	private final HitBoxImpl box;
	private Mapp map;
	private Rectangle rectangle;
	
	public AbstractStaticGameObject(GameObjectType type, Point2D position, Point2D upperCorner, Mapp map) {
		this.type = type;
		this.position = position;
		this.box = new HitBoxImpl(position, upperCorner);
		this.map = map;
	}
	
	@Override
	public Point2D getObjectPosition() {
		return new Point2D(position);
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
		return new HitBoxImpl(this.box);
	}
	
	@Override
	public Mapp getMap() {
		return this.map;
	}

	public Rectangle getRectangle() {
		return this.rectangle;
	}

}
