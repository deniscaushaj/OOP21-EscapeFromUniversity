package escapefromuniversity.model.shop;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.map.Room;

public class ShopImpl extends AbstractStaticGameObject implements Shop {

    public ShopImpl(GameObjectType type, Point2D position, Point2D upperCorner, Room room) {
        super(type, position, upperCorner, room);
    }

    @Override
    public void collisionWith(GameObject gObj2) {
        if (gObj2.getType() == GameObjectType.PLAYER) {
            this.getRoom().getMapManager().moveToShop();
        }
    }
}
