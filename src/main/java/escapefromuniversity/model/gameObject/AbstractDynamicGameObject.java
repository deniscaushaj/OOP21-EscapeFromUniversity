package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.HitBoxImpl;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;

import escapefromuniversity.model.map.Mapp;

public abstract class AbstractDynamicGameObject implements DynamicGameObject {
	
	private int id;
	private final GameObjectType type;
	private final int speed;
	private Vector2D direction;
	private Point2D position;
	private final HitBox box;
	protected Mapp map;
    private State state;

	public AbstractDynamicGameObject(final GameObjectType type, final Point2D position, Point2D upperCorner, final int speed, final Vector2D direction, Mapp map) {
		this.type = type;
		this.position = position;
		this.speed = speed;
		this.direction = direction;
		this.box = new HitBoxImpl(position, upperCorner);
		this.map = map;
	}
	
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
    public int getSpeed() {
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

    public abstract void update(double deltaTime);

    public void move(final double deltaTime) {
        this.setPosition(this.getObjectPosition().sum(getDirection().multiplication(this.speed).multiplication(deltaTime)));
    }

    public boolean collisionWithCheck(final GameObject gObj2) {
        return this.getObjectHitBox().isColliding(gObj2.getObjectHitBox());
    }

    @Override
    public abstract void collisionWith(final GameObject gObj2);

    @Override
    public HitBox getObjectHitBox() {
        return new HitBoxImpl(this.box);
    }

    public Mapp getMap() {
        return this.map;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }
    
    @Override
    public State getState() {
        return this.state;
    }
}
