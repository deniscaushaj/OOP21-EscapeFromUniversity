package escapefromuniversity.model.gameObject.player;

import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.Direction;

/**
 * The class the implements {@link PlayerMovement} interface and manages the player's movement.
 */
public class PlayerMovementImpl implements PlayerMovement {

    private final Player player;

    /**
     * Instantiates the object.
     * @param player the player.
     */
    public PlayerMovementImpl(final Player player) {
        this.player = player;
    }

    /* Sets player's direction to move it up. */
    private void moveUp() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), -1));
    }

    /* Sets player's direction to move it down. */
    private void moveDown() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), 1));
    }

    /* Sets player's direction to move it right. */
    private void moveRight() {
        this.player.setDirection(new Vector2D(1, this.player.getDirection().getY()));
    }

    /* Sets player's direction to move it left. */
    private void moveLeft() {
        this.player.setDirection(new Vector2D(-1, this.player.getDirection().getY()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopVertical() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), 0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopHorizontal() {
        this.player.setDirection(new Vector2D(0, this.player.getDirection().getY()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(final Direction direction) {
        switch (direction) {
            case UP:
                this.moveUp();
                break;
            case DOWN:
                this.moveDown();
                break;
            case RIGHT:
                this.moveRight();
                break;
            case LEFT:
                this.moveLeft();
                break;
            default: {
            }
        }
    }

}
