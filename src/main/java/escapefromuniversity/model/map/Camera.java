package escapefromuniversity.model.map;

/**
 * An interface for the camera of the game.
 */
public interface Camera {

    /**
     * .
     * @return the projected rectangle
     */
    Rectangle calcMapProjection(double ratio);


}
