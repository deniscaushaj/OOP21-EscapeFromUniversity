package escapefromuniversity.model;

public class AbstractStaticGameObject implements StaticGameObject{
	
	private int id;
	private GameObjectType type;
	private Point2D position;
	
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
	public GameObjectType getType() {
		return this.type;
	}

}
