package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.HitBoxImpl;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;

import escapefromuniversity.model.GameInit;

/**
 * 
 * abstract class implement dynamic object.
 *
 */
public abstract class AbstractDynamicGameObject implements DynamicGameObject {

    private int id;
    private final GameObjectType type;
    private final double speed;
    private Vector2D direction;
    private Point2D position;
    private final Point2D hitBoxSize;
    protected GameInit map;
    private State state;

    /**
     * 
     * @param type
     * @param position
     * @param hitBoxSize
     * @param speed
     * @param direction
     * @param map
     */
    public AbstractDynamicGameObject(final GameObjectType type, final Point2D position, final Point2D hitBoxSize, final double speed, final Vector2D direction, final GameInit map) {
        this.type = type;
        this.position = position;
        this.speed = speed;
        this.direction = direction;
        this.map = map;
        this.hitBoxSize = hitBoxSize;
    }

    @Override
    public Point2D getObjectPosition() {
        return new Point2D(this.position);
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
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public Vector2D getDirection() {
        return new Vector2D(this.direction);
    }

    @Override
    public void setDirection(final Vector2D newDirection) {
        if (Direction.UP.getDirection().equals(newDirection)) {
            this.setState(State.UP);
        } else if (Direction.LEFT.getDirection().equals(newDirection)) {
            this.setState(State.LEFT);
        } else if (Direction.DOWN.getDirection().equals(newDirection)) {
            this.setState(State.DOWN);
        } else if (Direction.RIGHT.getDirection().equals(newDirection)) {
            this.setState(State.RIGHT);
        } else {
            this.setState(State.IDLE);
        }
        this.direction = newDirection;
    }

    @Override
    public void setPosition(final Point2D newPosition) {
        this.position = newPosition;
    }

    @Override
    public abstract void update(double deltaTime);

    /**
     * 
     * @param deltaTime
     */
    public void move(final double deltaTime) {
        this.setPosition(this.getObjectPosition().sum(getDirection().multiplication(this.speed).multiplication(deltaTime)));
    }

    @Override
    public boolean collisionWithCheck(final GameObject gObj2) {
        return this.getObjectHitBox().isColliding(gObj2.getObjectHitBox());
    }

    @Override
    public abstract void collisionWith(GameObject gObj2);

    @Override
    public HitBox getObjectHitBox() {
        return new HitBoxImpl(this.position, this.position.sum(this.hitBoxSize));
    }

    @Override
    public GameInit getMap() {
        return this.map;
    }

    @Override
    public void setState(final State state) {
        this.state = state;
    }

    @Override
    public State getState() {
        return this.state;
    }
}
