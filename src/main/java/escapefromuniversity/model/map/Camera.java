package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Rectangle;

/**
 * An interface for the camera of the game.
 */
public interface Camera {

    /**
     * Returns the projected rectangle.
     * @param ratio the ratio of the screen
     * @return the projected rectangle
     */
    Rectangle calcMapProjection(double ratio);


}
