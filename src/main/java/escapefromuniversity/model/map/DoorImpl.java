package escapefromuniversity.model.map;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

/**
 * A class which implements the interface Door.
 */
public class DoorImpl extends AbstractStaticGameObject implements Door {
    private final Point2D pos;

    public DoorImpl(GameObjectType type, Point2D position, Point2D upperCorner, GameInit map, Point2D pos) {
        super(type, position, upperCorner, map);
        this.pos = pos;
    }

    @Override
    public Point2D getPos() {
        return this.pos;
    }

    @Override
    public void collisionWith(GameObject gObj2) {
        if (gObj2.getType() == GameObjectType.PLAYER) {
            this.getMap().getMapManager().setCurrentRoom(this);
        }
    }
}
