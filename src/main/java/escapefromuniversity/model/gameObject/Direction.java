package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.basics.Vector2D;

/**
 * An enum containing the four cardinal directions.
 */
public enum Direction {

    /**
     * Identifies the north direction.
     */
    UP(new Vector2D(0, -1)),

    /**
     * Identifies the east direction.
     */
    RIGHT(new Vector2D(1, 0)),

    /**
     * Identifies the south direction.
     */
    DOWN(new Vector2D(0, 1)),

    /**
     * Identifies the west direction.
     */
    LEFT(new Vector2D(-1, 0));

    private final Vector2D direction;

    /**
     * Instantiates a direction.
     * @param direction
     */
    Direction(final Vector2D direction) {
        this.direction = direction;
    }

    /**
     * Returns the direction.
     * @return the direction.
     */
    public Vector2D getDirection() {
        return this.direction;
    }
}
