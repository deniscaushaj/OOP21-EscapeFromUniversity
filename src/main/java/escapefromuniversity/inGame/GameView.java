package escapefromuniversity.inGame;

import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;

/**
 * 
 * interface of game view.
 *
 */
public interface GameView {

    /**
     * 
     */
    void update();

    /**
     * 
     */
    void addPauseBG();

    /**
     * 
     */
    void removePauseBG();

    /**
     * 
     */
    void openMenu();

    /**
     * 
     * @param gameState
     */
    void end(GameState gameState);

    /**
     * 
     * @param id
     */
    void remuveSpriteAnimation(int id);

    /**
     * 
     * @param id
     * @param position
     * @param deltaTime
     */
    void updateSpriteAnimation(int id, Point2D position);

    /**
     * 
     * @param id
     * @param state
     * @param type
     * @param height
     * @param width
     */
    void addSpriteAnimation(int id, State state, GameObjectType type, int height, int width);
    
    boolean containThisID(int id);
}
