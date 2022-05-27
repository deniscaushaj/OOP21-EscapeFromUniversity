package escapefromuniversity.model.enemy;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import escapefromuniversity.model.bullet.BulletFactory;
import escapefromuniversity.model.bullet.BulletFactoryImp;
import escapefromuniversity.model.gameObject.AbstractDynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

public abstract class BossImp extends AbstractDynamicGameObject implements Boss{
	
	private int life;
	private final long shootDelay;
	private long shootLastTime;
	private BossState state;
	private int impactDamage;
	
	public BossImp(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impactDamage) {
		super(type, position, upperCorner, speed, direction);
		this.life = life;
		this.shootDelay = shootDelay;
		this.state = BossState.QUIZ;
		this.impactDamage = impactDamage;
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
	
	abstract void shoot();

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
		if(this.collisionWithCheck(gObj2)) {
			switch(gObj2.getType().getCollisionType()) {
			case OBSTACLE:
				//torno alla posizione precedente
				break;
			case ENTITY:
				if(gObj2.getType().equals(GameObjectType.PLAYER)) {
					//fare danno al protagonista
				}
				//torno alla posizione precedente
				break;
			default:
				break;
			}
		}
	}

	@Override
	public int getDamage() {
		return this.impactDamage;
	}

}
