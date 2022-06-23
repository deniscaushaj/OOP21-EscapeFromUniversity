package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

public class ObstacleObject extends AbstractStaticGameObject {

    private Byte byteValue;

    public ObstacleObject(GameObjectType type, Point2D position, Point2D upperCorner, Room room) {
        super(type, position, upperCorner, room);
    }

    public ObstacleObject(GameObjectType type, Point2D position, Point2D upperCorner, Byte byteValue){
        super(type, position, upperCorner, byteValue);
    }

    @Override
    public void collisionWith(GameObject gObj2) {

    }
}
