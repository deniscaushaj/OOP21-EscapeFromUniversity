package escapefromuniversity.model.basics;

/**
 * 
 * enum types of collisions.
 *
 */
public enum GameCollisionType {

    /**
     * Identifies an obstacle object.
     */
    OBSTACLE,
    /**
     * Identifies a boss or the player.
     */
    ENTITY,
    /**
     * Identifies an immune boss or player.
     */
    IMMUNE_ENTITY,
    /**
     * Identifies a bullet.
     */
    BULLET,
    /**
     * Identifies an immune bullet.
     */
    IMMUNE_BULLET,
    /**
     * Identifies a walcable object.
     */
    NADA;


}
