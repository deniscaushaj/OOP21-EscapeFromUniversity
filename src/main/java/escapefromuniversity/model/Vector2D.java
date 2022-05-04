package escapefromuniversity.model;

public class Vector2D {
	
	private final double x;
	private final double y;
	
	 public Vector2D(final double x, final double y) {
		 this.x = x;
		 this.y = y;
	 }
	 
	 public Vector2D(Vector2D vector) {
		 this.x = vector.x;
		 this.y = vector.y;
	 }
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

}
