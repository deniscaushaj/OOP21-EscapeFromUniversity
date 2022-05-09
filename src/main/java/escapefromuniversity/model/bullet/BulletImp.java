package escapefromuniversity.model.bullet;

import escapefromuniversity.model.AbstractDynamicGameObject;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public class BulletImp extends AbstractDynamicGameObject implements Bullet{
	
	private final int damage;

	public BulletImp(GameObjectType type, Point2D position, int speed, Vector2D direction, int damage) {
		super(type, position, speed, direction);
		this.damage = damage;
	}
    
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDamage() {
		return this.damage;
	}

	@Override
	public void collisionWith(GameObject gObj2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double deltaTime) {
		this.move(deltaTime);
		
	}

}
