package escapefromuniversity.model;

public class Point2D {
	
	private final double x;
	private final double y;
	
	 public Point2D(final double x, final double y) {
		 this.x = x;
		 this.y = y;
	 }
	 
	 public Point2D(Point2D point) {
		 this.x = point.x;
		 this.y = point.y;
	 }
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
}
