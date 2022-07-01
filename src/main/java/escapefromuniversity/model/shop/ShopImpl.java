package escapefromuniversity.model.shop;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.GameInit;

/**
 * A class which extenst AbstractStaticGameObject and implements Shop.
 */
public class ShopImpl extends AbstractStaticGameObject implements Shop {

	/**
	 * A constructor for ShopImpl.
	 * @param type The type of the game object.
	 * @param position The position of the game object represented with a Point2Dthe position of the game object represented with a Point2D.
	 * @param upperCorner
	 * @param room
	 */
    public ShopImpl(final GameObjectType type, final Point2D position, final Point2D upperCorner, final GameInit map) {
        super(type, position, upperCorner, map);
    }

    @Override
    public void collisionWith(final GameObject gObj2) {
        if (gObj2.getType() == GameObjectType.PLAYER) {
            this.getMap().getMapManager().setupShop();
        }
    }
}
