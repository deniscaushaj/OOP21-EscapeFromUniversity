package escapefromuniversity.model.gameObject.player;

import escapefromuniversity.model.gameObject.Direction;

import java.awt.Image;

/**
 * The interface of player's movement.
 */
public interface PlayerMovement {

    /**
     * Sets player's direction to move it up.
     */
    void moveUp();

    /**
     * Sets player's direction to move it down.
     */
    void moveDown();

    /**
     * Sets player's direction to move it right.
     */
    void moveRight();

    /**
     * Sets player's direction to move it left.
     */
    void moveLeft();

    /**
     * Stops the player's movement in vertical direction.
     */
    void stopVertical();

    /**
     * Stops the player movement in horizontal direction.
     */
    void stopHorizontal();

    /**
     * Calls the respective methods to move the player in each direction.
     * @param direction the direction that defines the movement method to call.
     */
//    void move(Direction direction);

}
