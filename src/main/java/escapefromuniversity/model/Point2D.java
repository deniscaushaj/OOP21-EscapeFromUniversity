package escapefromuniversity.model;

public class Point2D {
	
	private final double x;
	private final double y;
	
	 public Point2D(final double x, final double y) {
		 this.x = x;
		 this.y = y;
	 }
	 
	 public Point2D(Point2D point) {
		 this.x = point.getX();
		 this.y = point.getY();
	 }
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Point2D multiplication(final double mul) {
		return new Point2D(this.x*mul, this.y*mul);
	}
	
	public Point2D sum(final Vector2D vet) {
		return new Point2D(this.x + vet.getX(), this.y + vet.getY());
	}
	
	
	
}
