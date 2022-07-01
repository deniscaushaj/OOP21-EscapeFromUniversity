package escapefromuniversity.inGame;

import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;

/**
 * 
 * interface of controller of game view.
 *
 */
public interface GameView {

    /**
     * 
     * @param id : id of object.
     */
    void removeSpriteAnimation(int id);

    /**
     * 
     * @param id : id of object.
     * @param state
     */
    void updateSpriteAnimation(int id, State state);

    /**
     * 
     * @param id : id of object.
     * @param state : state of object.
     * @param type : type of object.
     */
    void addSpriteAnimation(int id, State state, GameObjectType type);

    /**
     * 
     * @param id : id of object.
     * @return if the id is present.
     */
    boolean containThisID(int id);

    /**
     * 
     * @param gameState : win or lost.
     */
    void end(GameState gameState);

    void setGameController(GameController gc);
    
    void checkID();
}
