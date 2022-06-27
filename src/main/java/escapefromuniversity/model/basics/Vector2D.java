package escapefromuniversity.model.basics;

/**
 * 
 * class vector2D extend point2D.
 *
 */
public class Vector2D extends Point2D {

    /**
     * 
     * @param x
     * @param y
     */
    public Vector2D(final double x, final double y) {
        super(x, y);
    }

    /**
     * 
     * @param vector
     */
    public Vector2D(final Vector2D vector) {
        super(vector.getX(), vector.getY());
    }

    /**
     * 
     * @param mul : multiplicative factor.
     * @return new Vector2D.
     */
    public Vector2D multiplication(final double mul) {
        return new Vector2D(this.getX() * mul, this.getY() * mul);
    }

    /**
     * 
     * @return new Vector2D with module 1.
     */
    public Vector2D normal() {
        final double module = Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
        return new Vector2D(this.getX() / module, this.getY() / module);
    }

}
