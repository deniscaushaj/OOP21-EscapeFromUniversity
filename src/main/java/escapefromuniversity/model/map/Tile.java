package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;

public class Tile {
    private final int x;
    private final int y;
    private final int value;


    public Tile(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isVisible() {
        return this.value != 0;
    }

    public Point2D getPoint() {
        return new Point2D(this.x, this.y);
    }
}
