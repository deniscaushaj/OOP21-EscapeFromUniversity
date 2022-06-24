package escapefromuniversity.inGame;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.map.Rectangle;

import java.awt.*;

public class SpriteAnimation {

    private final Sprite sprite;
    private Rectangle position;
    private final int height;
    private final int width;
    private boolean isVisible;

    public SpriteAnimation(Sprite sprite, int height, int width) {
        this.sprite = sprite;
        this.height = height;
        this.width = width;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public void setPosition(Point2D position) {
        Point2D size = position.sum(new Point2D(this.width, this.height));
        this.position = new Rectangle(position, size);
    }

    public Rectangle getPosition() {
        return this.position;
    }

    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

    public boolean isVisible() {
        return this.isVisible;
    }
}
