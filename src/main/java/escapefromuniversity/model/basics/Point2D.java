package escapefromuniversity.model.basics;

import java.util.Objects;

/**
 * 
 * class Point2D.
 *
 */
public class Point2D {

    private final double x;
    private final double y;

    /**
     * 
     * @param x
     * @param y
     */
    public Point2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point2D other = (Point2D) obj;
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
                && Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
    }

    /**
     * 
     * @param point
     */
    public Point2D(final Point2D point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    /**
     * 
     * @return x of point.
     */
    public double getX() {
        return x;
    }

    /**
     * 
     * @return y of point.
     */
    public double getY() {
        return y;
    }

    /**
     * 
     * @param mul : multiplicative factor.
     * @return new Pioint2D.
     */
    public Point2D multiplication(final double mul) {
        return new Point2D(this.x * mul, this.y * mul);
    }

    /**
     * 
     * @param point
     * @return new Pioint2D.
     */
    public Point2D sum(final Point2D point) {
        return new Point2D(this.x + point.getX(), this.y + point.getY());
    }

    /**
     * @param point the point to subtract from.
     * @return the result of the subtraction.
     */
    public Point2D subtract(final Point2D point) {
        return new Point2D(this.x - point.getX(), this.y - point.getY());
    }

    /**
     * 
     * @param point
     * @return distance between two points.
     */
    public double module(final Point2D point) {
        return Math.sqrt(Math.pow(getX() - point.getX(), 2) + Math.pow(getY() - point.getY(), 2));
    }


    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
