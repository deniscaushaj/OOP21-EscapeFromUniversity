package escapefromuniversity.model;

import java.util.List;

import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.map.MapManager;

public interface GameInit {

    void update(double deltaTime);

    void deleteGameObject(GameObject gameObject);

    void addDynamicGameObject(DynamicGameObject dGObj);

    void addStaticGameObject(StaticGameObject sGObj);

    List<DynamicGameObject> getAllDynamicGameObject();
    
    Player getPlayer();
    
    MapManager getMapManager();
    
    void goQuiz(Boss boss);
}
