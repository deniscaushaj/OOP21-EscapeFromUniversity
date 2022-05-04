package escapefromuniversity.model;

public abstract class AbstractDynamicGameObject implements DynamicGameObject {
	
	private int id;
	private int speed;
	private GameObjectType type;
	private Point2D position;
	private Vector2D direction;

	@Override
	public Point2D getObjectPosition() {
		return new Point2D(position);
	}

	@Override
	public int getID() {
		return this.id;
	}

	@Override
	public void setID(final int ID) {
		this.id = ID;		
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public Vector2D getDyrection() {
		return new Vector2D(this.direction);
	}

	@Override
	public void setDyrectino(final Vector2D newDyrection) {
		this.direction = newDyrection;	
	}

}
