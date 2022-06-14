package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.HitBox;
import escapefromuniversity.model.HitBoxImpl;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.map.Room;

public abstract class AbstractStaticGameObject implements StaticGameObject{
	
	private int id;
	private final GameObjectType type;
	private final Point2D position;
	private final HitBoxImpl box;
	private Room room;
	
	public AbstractStaticGameObject(GameObjectType type, Point2D position, Point2D upperCorner, Room room) {
		this.type = type;
		this.position = position;
		this.box = new HitBoxImpl(position, upperCorner);
		this.room = room;
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
	public Room getRoom() {
		return this.room;
	}

	

}
