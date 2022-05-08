package escapefromuniversity.model;

public class AbstractStaticGameObject implements StaticGameObject{
	
	private int id;
	private final GameObjectType type;
	private final Point2D position;
	
	public AbstractStaticGameObject(GameObjectType type, Point2D position) {
		this.type = type;
		this.position = position;
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

}
