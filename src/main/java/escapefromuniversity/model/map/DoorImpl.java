package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

/**
 * Implementation of Door interface
 */
public class DoorImpl extends AbstractStaticGameObject implements Door {
    private final Point2D pos;

    public DoorImpl(GameObjectType type, Point2D position, Point2D upperCorner, Room room, Point2D pos) {
        super(type, position, upperCorner, room);
        this.pos = pos;
    }

    @Override
    public Point2D getPos() {
        return this.pos;
    }

    @Override
    public void collisionWith(GameObject gObj2) {
        if (gObj2.getType() == GameObjectType.PLAYER) {
            this.getRoom().getMapManager().setCurrentRoom(this);
        }
    }
}
