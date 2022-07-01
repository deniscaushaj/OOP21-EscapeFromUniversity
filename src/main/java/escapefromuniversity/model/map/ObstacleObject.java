package escapefromuniversity.model.map;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

/**
 * A class which models an ObstacleStaticObject.
 */
public class ObstacleObject extends AbstractStaticGameObject {
    /**
     * A constructor for an ObstacleObject.
     * @param type the type of GameObject
     * @param position the upper-left corner
     */
    public ObstacleObject(final GameObjectType type, final Rectangle position, final GameInit map) {
        super(type, position.getTopLeft(), position.getBottomRight(), map);
    }

    @Override
    public void collisionWith(final GameObject gObj2) {

    }
}
