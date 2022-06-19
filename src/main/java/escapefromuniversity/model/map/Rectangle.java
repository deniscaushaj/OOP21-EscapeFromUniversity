package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;

/**
 * A class which models a rectangle.
 */
public class Rectangle {

    private final Point2D topLeft;
    private final Point2D bottomRight;

    /**
     * Constructor of rectangle.
     * @param topLeft the top-left point of the rectangle
     * @param bottomRight the bottom-right point of the rectangle
     */
    public Rectangle(final Point2D topLeft, final Point2D bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    /**
     * Returns the value of the lowest X-axis value in the rectangle.
     * @return the value of the lowest X-axis value in the rectangle
     */
    public double getMinX() {
        return this.topLeft.getX();
    }

    /**
     * Returns the value of the highest X-axis value in the rectangle.
     * @return the value of the highest X-axis value in the rectangle
     */
    public double getMaxX() {
        return this.bottomRight.getX();
    }

    /**
     * Returns the value of the lowest Y-axis value in the rectangle.
     * @return the value of the lowest Y-axis value in the rectangle
     */
    public double getMinY() {
        return this.topLeft.getY();
    }

    /**
     * Returns the value of the highest Y-axis value in the rectangle.
     * @return the value of the highest Y-axis value in the rectangle
     */
    public double getMaxY() {
        return this.bottomRight.getY();
    }

    /**
     * Returns the width of the rectangle.
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.getMaxX() - this.getMinX();
    }

    /**
     * Returns the height of the rectangle.
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.getMaxY() - this.getMinY();
    }

    /**
     * Returns the position of top-left point.
     * @return the position of top-left point
     */
    public Point2D getTopLeft() {
        return this.topLeft;
    }

    /**
     * Returns the position of top-right point.
     * @return the position of top-right point
     */
    public Point2D getTopRight() {
        return new Point2D(getBottomRight().getX(), getTopLeft().getY());
    }

    /**
     * Returns the position of bottom-left point.
     * @return the position of  bottom-left point
     */
    public Point2D getBottomLeft() {
        return new Point2D(getTopLeft().getX(), getBottomLeft().getY());
    }

    /**
     * Returns the position of bottom-right point.
     * @return the position of bottom-right point
     */
    public Point2D getBottomRight() {
        return this.bottomRight;
    }
}
