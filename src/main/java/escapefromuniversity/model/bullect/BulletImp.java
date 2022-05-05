package escapefromuniversity.model.bullect;

import escapefromuniversity.model.AbstractDynamicGameObject;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public class BulletImp extends AbstractDynamicGameObject implements Bullet{

	public BulletImp(GameObjectType type, Point2D position, int speed, Vector2D direction) {
		super(type, position, speed, direction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void collisionWith(GameObject gObj2) {
		// TODO Auto-generated method stub
		
	}

}
