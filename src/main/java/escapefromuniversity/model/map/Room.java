package escapefromuniversity.model.map;

import java.util.List;

import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.player.Player;

public interface Room {

    void update(double deltaTime);

    void deleteGameObject(GameObject gameObject);

    void addDynamicGameObject(DynamicGameObject dGObj);

    void addStaticGameObject(StaticGameObject sGObj);

    List<GameObject> getAllGameObject();
    
    Player getPlayer();
    
    void goQuiz(GameObjectType type);
}
