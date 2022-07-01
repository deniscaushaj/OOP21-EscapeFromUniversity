package escapefromuniversity.model;

import java.util.List;

import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapProperties;

public interface GameInit {

    void update(double deltaTime);

    void deleteGameObject(DynamicGameObject gameObject);

    void addDynamicGameObject(DynamicGameObject dGObj);

    void addStaticGameObject(StaticGameObject sGObj);

    List<DynamicGameObject> getAllDynamicGameObject();
    
    Player getPlayer();
    
    MapManager getMapManager();

    MapProperties getMap();
    
    void goQuiz(Boss boss);
}
