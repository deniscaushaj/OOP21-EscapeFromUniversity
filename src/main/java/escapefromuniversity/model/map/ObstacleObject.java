package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

/**
 * A class which models an ObstacleStaticObject.
 */
public class ObstacleObject extends AbstractStaticGameObject {

    public ObstacleObject(GameObjectType type, Point2D position, Point2D upperCorner, Room room) {
        super(type, position, upperCorner, room);
    }

    /**
     * A constructor for an ObstacleObject.
     * @param type the type of GameObject
     * @param position the upper-left corner
     * @param byteValue the byte value of the object
     */
    public ObstacleObject(final GameObjectType type, final Rectangle position, final Byte byteValue) {
        super(type, position, byteValue);
    }

    @Override
    public void collisionWith(final GameObject gObj2) {

    }
}
