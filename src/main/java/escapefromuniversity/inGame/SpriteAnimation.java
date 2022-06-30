package escapefromuniversity.inGame;

import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.map.Rectangle;

/**
 *
 */
public class SpriteAnimation {

    private final Sprite sprite;
    private Rectangle position;
    private boolean isVisible;
    private HitBox box;

    /**
     *
     * @param sprite
     * @param box
     * 
     */
    public SpriteAnimation(final Sprite sprite, final HitBox box) {
        this.sprite = sprite;
        this.box = box;
//        this.height = height;
//        this.width = width;
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
    public void setPosition(final Point2D position) {
        Point2D size = position.sum(new Point2D(50, 57));
        this.position = new Rectangle(position, size);
    }

    /**
     * Returns the current position of the sprite.
     * @return the current position.
     */
    public Rectangle getPosition() {
        return this.position;
    }
    
    public HitBox getBox() {
        return this.box;
    }

    /**
     * Sets the sprite to be visible or not.
     * @param visible the boolean that determines if the sprite is currently visible in the screen or not.
     */
    public void setVisible(final boolean visible) {
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
