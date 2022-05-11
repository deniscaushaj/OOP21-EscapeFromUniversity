package escapefromuniversity.model.enemy;

import escapefromuniversity.model.AbstractDynamicGameObject;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public class BossImp extends AbstractDynamicGameObject implements Boss{
	
	private int life;
	private final double shootDelay;
	
	public BossImp(final int speed, final Point2D position, final Point2D upperCorner, final Vector2D direction, final GameObjectType type, final int life, final double shootDelay) {
		super(type, position, upperCorner, speed, direction);
		this.life = life;
		this.shootDelay = shootDelay;
	}

	@Override
	public void maybeShoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLife() {
		return this.life;
	}

	@Override
	public void takeDamage(int damage) {
		this.life = this.life - damage;
		
	}

	@Override
	public void update(double deltaTime) {
		// TODO Auto-generated method stub
		
	}

}
