package escapefromuniversity.model.player;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import escapefromuniversity.model.gameObject.AbstractDynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;

public class PlayerImpl extends AbstractDynamicGameObject implements Player{
	
	private static final int MAX_LIFE = 100;
	private final static Point2D HIT_BOX_PLAYER = new Point2D(0,0); // TODO values to be changed
//	TODO eventual MAX_STATS
	
	private int life;
	private int credits;
<<<<<<< Updated upstream
	private int shootDelay;
	private long lastShoot;
	private boolean dead;
	private boolean graduated;
=======
	private int passed;
	private long shootDelay;
	private long lastShoot;
>>>>>>> Stashed changes

	public PlayerImpl(GameObjectType type, Point2D position, int speed, Vector2D direction, int shootDelay) {
		super(type, position, HIT_BOX_PLAYER, speed, direction);
		this.life = MAX_LIFE;
		this.credits = 0;
<<<<<<< Updated upstream
		this.shootDelay = shootDelay;
		this.dead = false;
		this.graduated = false;
=======
		this.passed = 0;
>>>>>>> Stashed changes
	}

	@Override
	public void collisionWith(GameObject gObj2) {
<<<<<<< Updated upstream
		if (this.collisionWithCheck(gObj2)) {
			switch(gObj2.getType().getCollisionType()) {
			case OBSTACLE:
//				TODO collision with obstacle
=======
		if (this.collisionWithCheck(gObj2))	{
			switch (gObj2.getType().getCollisionType()) {
			case OBSTACLE:
				// TODO collision with obstacle
>>>>>>> Stashed changes
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
	public boolean canShoot() {
		if (System.currentTimeMillis() - this.lastShoot > this.shootDelay) {
			return true;
		}
		return false;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isDead() {
		return this.life <= 0;
	}

	@Override
	public boolean isGraduated() {
<<<<<<< Updated upstream
		return this.graduated;
	}
=======
		return this.passed >= 6;
	}	
>>>>>>> Stashed changes

}
