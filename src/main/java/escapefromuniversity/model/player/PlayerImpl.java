package escapefromuniversity.model.player;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.AbstractDynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

public class PlayerImpl extends AbstractDynamicGameObject implements Player{
	
	private static final int MAX_LIFE = 100;
	private final static Point2D HIT_BOX_PLAYER = new Point2D(0,0); // TODO values to be changed
//	TODO eventual MAX_STATS
	
	private int life;
	private int credits;
	private int passed;
	private long shootDelay;
	private long lastShoot;

	public PlayerImpl(GameObjectType type, Point2D position, int speed, Vector2D direction, int shootDelay) {
		super(type, position, HIT_BOX_PLAYER, speed, direction);
		this.life = MAX_LIFE;
		this.credits = 0;
		this.passed = 0;
		this.shootDelay = shootDelay;
		this.lastShoot = 0;
	}

	@Override
	public void collisionWith(GameObject gObj2) {
		if (this.collisionWithCheck(gObj2)) {
			switch(gObj2.getType().getCollisionType()) {
			case OBSTACLE:
//				TODO collision with obstacle
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void update(double deltaTime) {
		if (this.canShoot()) {
			this.shoot();
		}
		this.move(deltaTime);
	} // TODO GameEntity?

	@Override
	public int getMaxLife() {
		return MAX_LIFE;
	}

	@Override
	public int getLife() {
		return life;
	}

	@Override
	public int getCredits() {
		return credits;
	}

	@Override
	public void setLife(final int life) {
		this.life = life;		
	}

	@Override
	public void setCredits(final int credits) {
		this.credits = credits;
	}

	@Override
	public void takeDamage(final int damage) {
		this.life -= damage;
	}
	
	@Override
	public boolean canShoot() {
		if (System.currentTimeMillis() - this.lastShoot >= this.shootDelay) {
			this.lastShoot = System.currentTimeMillis();
			return true;
		}
		return false;
	}
	
	@Override
	public void shoot() {
		
	}
	
//	@Override
//	public void setNewBuff() {
//		// TODO Auto-generated method stub
//		
//	}
	
	@Override
	public void passedExam() {
		this.passed ++;
	}
	
	@Override
	public boolean isDead() {
		return this.life <= 0;
	}

	@Override
	public boolean isGraduated() {
		return this.passed >= 6;
	}	

}
