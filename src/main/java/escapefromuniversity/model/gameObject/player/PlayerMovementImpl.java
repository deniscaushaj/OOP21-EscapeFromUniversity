package escapefromuniversity.model.gameObject.player;

import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.Direction;

public class PlayerMovementImpl implements PlayerMovement {

    private final Player player;

    public PlayerMovementImpl(final Player player) {
        this.player = player;
    }

    private void moveUp() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), -1));
    }

    private void moveDown() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), 1));
    }

    private void moveRight() {
        this.player.setDirection(new Vector2D(1, this.player.getDirection().getY()));
    }

    private void moveLeft() {
        this.player.setDirection(new Vector2D(-1, this.player.getDirection().getY()));
    }

    @Override
    public void stopVertical() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), 0));
    }

    @Override
    public void stopHorizontal() {
        this.player.setDirection(new Vector2D(0, this.player.getDirection().getY()));
    }

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