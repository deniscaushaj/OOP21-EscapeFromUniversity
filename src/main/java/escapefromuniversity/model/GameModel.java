package escapefromuniversity.model;

import java.util.List;

import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.player.Player;

/**
 * 
 * model of game.
 *
 */
public interface GameModel {

    /**
     * 
     * @return a list of all GameObject in game.
     */
    List<DynamicGameObject> getAllDynamicGameObj();

    /**
     * 
     * @param deltaTime : time since the last update.
     */
    void updateGame(double deltaTime);

    /**
     * 
     */
    void setWin();

    /**
     * 
     */
    void setLost();

    /**
     * 
     */
    void setShop();

    /**
     * 
     * @param boss
     */
    void setQuiz(Boss boss);

    /**
     * 
     * @return the Player object.
     */
    Player getPlayer();

    /**
     * 
     * @return the GameInit.
     */
    GameInit getGameInit();

    /**
     * 
     * @param id of object.
     * @return Point2D of position.
     */
    Point2D getPositionOfID(int id);

    /**
     * 
     * @return final mark.
     */
    int getPlayerFinalMark();

    /**
     * 
     * @return actual boss.
     */
    Boss getCurrentBoss();

    /**
     * 
     * @param id of object.
     * @return state.
     */
    State getStateID(int id);

    /**
     * 
     * @param id of object.
     * @return type.
     */
    GameObjectType getTypeID(int id);

    /**
     * 
     * @param id of object.
     * @return HitBox 
     */
    HitBox getHitBoxID(int id);

    void removeID(int id);

}
