package escapefromuniversity.model;

import java.util.List;

import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapProperties;

/**
 * 
 * interface class contain every game object.
 *
 */
public interface GameInit {

    /**
     * 
     * @param deltaTime
     */
    void update(double deltaTime);

    /**
     * 
     * @param gameObject
     */
    void deleteGameObject(DynamicGameObject gameObject);

    /**
     * 
     * @param dGObj
     */
    void addDynamicGameObject(DynamicGameObject dGObj);

    /**
     * 
     * @param sGObj
     */
    void addStaticGameObject(StaticGameObject sGObj);

    /**
     * 
     * @return all game object.
     */
    List<DynamicGameObject> getAllDynamicGameObject();

    /**
     * 
     * @return player.
     */
    Player getPlayer();

    /**
     * 
     * @return map manager.
     */
    MapManager getMapManager();

    /**
     * 
     * @return map properties.
     */
    MapProperties getMap();

    /**
     * 
     * @param boss
     */
    void goQuiz(Boss boss);
}
