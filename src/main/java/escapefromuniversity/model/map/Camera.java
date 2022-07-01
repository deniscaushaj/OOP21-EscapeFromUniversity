package escapefromuniversity.model.map;

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
