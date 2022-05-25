package escapefromuniversity.model.map;

import escapefromuniversity.model.DynamicGameObject;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.StaticGameObject;

import java.util.List;

public interface Room {

    void update(double deltaTime);

    void deleteGameObject(GameObject gameObject);

    void addDynamicGameObject(DynamicGameObject dGObj);

    void addStaticGameObject(StaticGameObject sGObj);

    List<GameObject> getAllGameObject();
    
    Point2D getPlayerPosition();
}
