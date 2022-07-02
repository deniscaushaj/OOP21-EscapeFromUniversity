package escapefromuniversity.sprites;

import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.map.Rectangle;

/**
 * The interface of the dynamic game objects sprites.
 */
public interface Sprite {

    /**
     * Checks if the sprite image has to be updated.
     * @return {@code true} if the update time has elapsed and the sprite image needs to be changed, {@code false} otherwise.
     */
    boolean checkUpdate();

    /**
     * Sets the filepath of the sprite image.
     */
    void setFilepath();

    /**
     * Returns the filepath of the sprite image.
     * @return the filepath of the sprite image.
     */
    String getFilepath();

    /**
     * Sets the sprite state.
     * @param state the state to set to the sprite.
     */
    void setState(State state);

    /** Returns a rectangle of the sprite image.
     * @return a rectangle of the sprite image.
     */
    Rectangle getRectangle();
}
