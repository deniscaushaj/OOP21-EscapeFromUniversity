package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.map.Room;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.HitBoxImpl;
import escapefromuniversity.model.basics.Point2D;

public abstract class AbstractStaticGameObject implements StaticGameObject{
	
	private int id;
	private final GameObjectType type;
	private final Point2D position;
	private final HitBoxImpl box;
	private Room room;
	private Byte byteValue;
	
	public AbstractStaticGameObject(GameObjectType type, Point2D position, Point2D upperCorner, Room room) {
		this.type = type;
		this.position = position;
		this.box = new HitBoxImpl(position, upperCorner);
		this.room = room;
	}

	/**
	 * A constructor for an AbstractStaticGameObject for modelling an obstacle.
	 * @param type the type of GameObject
	 * @param position the upper-left corner
	 * @param upperCorner the lower-right corner
	 * @param byteValue the byte value of the object
	 */
	public AbstractStaticGameObject(final GameObjectType type, final Point2D position, final Point2D upperCorner, final Byte byteValue) {
		this.type = type;
		this.position = position;
		this.box = new HitBoxImpl(position, upperCorner);
		this.byteValue = byteValue;
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

	/**
	 * Returns the byte value of an object.
	 * @return the byte value of an object
	 */
	public Byte getByteValue() {
		return this.byteValue;
	}

}
