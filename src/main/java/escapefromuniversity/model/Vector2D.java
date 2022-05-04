package escapefromuniversity.model;

public class Vector2D extends Point2D{

	public Vector2D(double x, double y) {
		super(x, y);
	}
	
	public Vector2D(final Vector2D vector) {
		super(vector.getX(), vector.getY());
	}

}
