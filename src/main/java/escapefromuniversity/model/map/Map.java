package escapefromuniversity.model.map;

import java.util.List;

import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.player.Player;

/**
 * 
 * interface represent map.
 *
 */
public interface Map {

    /**
     * 
     * @param deltaTime
     */
    void update(double deltaTime);

    /**
     * 
     * @param gameObject
     */
    void deleteGameObject(GameObject gameObject);

    /**
     * 
     * @param dGObj : new DynamicGameObject.
     */
    void addDynamicGameObject(DynamicGameObject dGObj);

    /**
     * 
     * @param sGObj :new StaticGameObject.
     */
    void addStaticGameObject(StaticGameObject sGObj);

    /**
     * 
     * @return list of all DynamicGameObject.
     */
    List<DynamicGameObject> getAllDynamicGameObject();

    /**
     * 
     * @return player.
     */
    Player getPlayer();

    /**
     * 
     * @return mapManager.
     */
    MapManager getMapManager();

    /**
     * 
     * @param boss
     */
    void goQuiz(Boss boss);

}
