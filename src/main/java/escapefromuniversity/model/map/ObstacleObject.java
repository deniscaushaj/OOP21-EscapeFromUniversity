package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

public class ObstacleObject extends AbstractStaticGameObject {

    public ObstacleObject(GameObjectType type, Point2D position, Point2D upperCorner, Room room) {
        super(type, position, upperCorner, room);
    }

    /**
     * A constructor for an ObstacleObject.
     * @param type the type of GameObject
     * @param position the upper-left corner
     * @param upperCorner the lower-right corner
     * @param byteValue the byte value of the object
     */
    public ObstacleObject(final GameObjectType type, final Point2D position, final Point2D upperCorner, final Byte byteValue) {
        super(type, position, upperCorner, byteValue);
    }

    @Override
    public void collisionWith(final GameObject gObj2) {

    }
}
