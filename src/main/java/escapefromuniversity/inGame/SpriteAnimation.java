package escapefromuniversity.inGame;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.map.Rectangle;

/**
 *
 */
public class SpriteAnimation {

    private final Sprite sprite;
    private Rectangle position;
    private final int height;
    private final int width;
    private boolean isVisible;

    /**
     *
     * @param sprite
     * @param height
     * @param width
     */
    public SpriteAnimation(Sprite sprite, int height, int width) {
        this.sprite = sprite;
        this.height = height;
        this.width = width;
    }

    /**
     * Returns the current sprite.
     * @return the current sprite.
     */
    public Sprite getSprite() {
        return this.sprite;
    }

    /**
     * 
     * @param position
     */
    public void setPosition(Point2D position) {
        Point2D size = position.sum(new Point2D(this.width, this.height));
        this.position = new Rectangle(position, size);
    }

    /**
     * Returns the current position of the sprite.
     * @return the current position.
     */
    public Rectangle getPosition() {
        return this.position;
    }

    /**
     * Sets the sprite to be visible or not.
     * @param visible the boolean that determines if the sprite is currently visible in the screen or not.
     */
    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

    /**
     * Checks if the sprite is currently visible on the screen.
     * @return {@code true} if the sprite is currently visible on the screen, {@code false} otherwise.
     */
    public boolean isVisible() {
        return this.isVisible;
    }
}
