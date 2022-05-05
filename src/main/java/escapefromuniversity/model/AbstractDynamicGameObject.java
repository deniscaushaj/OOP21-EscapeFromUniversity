package escapefromuniversity.model;

public abstract class AbstractDynamicGameObject extends AbstractStaticGameObject implements DynamicGameObject {

	private final int speed;
	private Vector2D direction;

	public AbstractDynamicGameObject(final GameObjectType type, final Point2D position, final int speed, final Vector2D direction) {
		super(type, position);
		this.speed = speed;
		this.direction = direction;
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
		this.direction = newDirection;	
	}
	
	public abstract void update(double deltaTime);

}
