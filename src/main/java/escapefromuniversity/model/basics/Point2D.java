package escapefromuniversity.model.basics;

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
	
	public Point2D sum(final Vector2D vector) {
		return new Point2D(this.x + vector.getX(), this.y + vector.getY());
	}
	
	public Point2D sum(final Point2D point) {
		return new Point2D(this.x + point.getX(), this.y + point.getY());
	}
	
	public double module(final Point2D point) {
		return Math.sqrt(Math.pow(getX() - point.getX(), 2) + Math.pow(getY() - point.getY(), 2));
	}
	
	
	
}
