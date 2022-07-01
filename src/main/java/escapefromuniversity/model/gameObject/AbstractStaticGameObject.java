package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.map.Rectangle;
import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.HitBoxImpl;
import escapefromuniversity.model.basics.Point2D;


/**
 * 
 * abstract class implement static object.
 *
 */
public abstract class AbstractStaticGameObject implements StaticGameObject {

    private int id;
    private final GameObjectType type;
    private final Point2D bottomRightCorner;
    private final Point2D topLeftCorner;
    private GameInit map;
    private Rectangle rectangle;

    /**
     * 
     * @param type
     * @param topLeftCorner
     * @param bottomRightCorner
     * @param map
     */
    public AbstractStaticGameObject(final GameObjectType type, final Point2D topLeftCorner, final Point2D bottomRightCorner, final GameInit map) {
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
    public abstract void collisionWith(GameObject gObj2);

    @Override
    public HitBox getObjectHitBox() {
        return new HitBoxImpl(this.topLeftCorner, this.bottomRightCorner);
    }

    @Override
    public GameInit getMap() {
        return this.map;
    }

    /**
     * Returns the rectangle of the static game object.
     * @return the rectangle of the static game object
     */
    public Rectangle getRectangle() {
        return this.rectangle;
    }

	@Override
	public String toString() {
		return "AbstractStaticGameObject{" +
				"id=" + id +
				", type=" + type +
				", topLeftCorner=" + topLeftCorner +
				'}';
	}
}
