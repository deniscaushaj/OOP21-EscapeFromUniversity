package escapefromuniversity.model.enemy;

import escapefromuniversity.model.AbstractDynamicGameObject;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public class BossImp extends AbstractDynamicGameObject implements Boss{
	
	private int life;
	private final long shootDelay;
	private long shootLastTime;
	private BossState state;
	private int impatDamage;
	
	public BossImp(final int speed, final Point2D position, final Point2D upperCorner, final Vector2D direction, final GameObjectType type, final int life, final long shootDelay, final int impatDamage) {
		super(type, position, upperCorner, speed, direction);
		this.life = life;
		this.shootDelay = shootDelay;
		this.state = BossState.QUIZ;
		this.impatDamage = impatDamage;
	}

	@Override
	public void maybeShoot() {
		if(this.canShoot()) {
			this.shoot();
		}
		
	}
	
	private boolean canShoot() {
		if(System.currentTimeMillis() - this.shootLastTime > this.shootDelay) {
			this.shootLastTime = System.currentTimeMillis();
			return true;
		}
		return false;
		
	}
	
	private void shoot() {
		
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
		if(this.state.equals(BossState.FIGHT)) {
			this.maybeShoot();
			this.move(deltaTime);
			//modificare direzione in base al protagonista
		}
	}

	@Override
	public void collisionWith(GameObject gObj2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDamage() {
		return this.impatDamage;
	}

}
