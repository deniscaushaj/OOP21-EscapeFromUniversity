package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;

/**
 * A class which models a tile.
 */
public class Tile {
    private final int x;
    private final int y;
    private final int value;

    /**
     * A constructor for Tile.
     * @param x the row in the map
     * @param y the column in the map
     * @param value the ID
     */
    public Tile(final int x, final int y, final int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    /**
     * Returns the position of the row.
     * @return the position of the row
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns the position of the column.
     * @return the position of the column
     */
    public int getY() {
        return this.y;
    }

    /**
     * Returns the ID.
     * @return the ID
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Returns true if the tile is visible, false otherwise.
     * @return true if the tile is visible, false otherwise
     */
    public boolean isVisible() {
        return this.value != 0;
    }

    /**
     * Returns the position of the tile in the map.
     * @return the position of the tile in the map
     */
    public Point2D getPosition() {
        return new Point2D(this.x, this.y);
    }
}
