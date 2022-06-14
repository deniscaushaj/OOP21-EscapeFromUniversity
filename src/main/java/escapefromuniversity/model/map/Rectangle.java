package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;

public class Rectangle {

    private final Point2D topLeft;
    private final Point2D bottomRight;

    public Rectangle(Point2D topLeft, Point2D bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double getMinX() {
        return this.topLeft.getX();
    }

    public double getMaxX() {
        return this.bottomRight.getX();
    }

    public double getMinY() {
        return this.topLeft.getY();
    }

    public double getMaxY() {
        return this.bottomRight.getY();
    }

    public double getWidth(){
        return this.getMaxX() - this.getMinX();
    }

    public double getHeight(){
        return this.getMaxY() - this.getMinY();
    }

    public Point2D getTopLeft() {
        return this.topLeft;
    }

    public Point2D getTopRight(){
        return new Point2D(getBottomRight().getX(), getTopLeft().getY());
    }

    public Point2D getBottomLeft(){
        return new Point2D(getTopLeft().getX(), getBottomLeft().getY());
    }

    public Point2D getBottomRight() {
        return this.bottomRight;
    }
}
