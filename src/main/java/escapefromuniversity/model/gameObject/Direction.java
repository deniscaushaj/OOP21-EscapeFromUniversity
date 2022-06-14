package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.basics.Vector2D;

public enum Direction {
    
    UP(new Vector2D(0, -1)),
    
    RIGHT(new Vector2D(1, 0)),
    
    DOWN(new Vector2D(0, 1)),
    
    LEFT(new Vector2D(-1, 0));
    
    private final Vector2D direction;
    
    Direction(final Vector2D direction) {
        this.direction = direction;
    }

    public Vector2D getDirection() {
        return this.direction;
    }
}
