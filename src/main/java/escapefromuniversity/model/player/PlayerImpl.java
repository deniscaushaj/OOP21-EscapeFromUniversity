package escapefromuniversity.model.player;

import escapefromuniversity.model.AbstractDynamicGameObject;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public class PlayerImpl extends AbstractDynamicGameObject implements Player{
	
	private static final int MAX_LIFE = 100;
//	eventuali MAX_STATS
	
	private int life;
	private int credits;
	private boolean dead;
	private boolean graduated;
	private final static Point2D HIT_BOX_PLAYER = new Point2D(0,0);

	public PlayerImpl(GameObjectType type, Point2D position, int speed, Vector2D direction) {
		super(type, position, HIT_BOX_PLAYER, speed, direction);
		this.life = MAX_LIFE;
		this.credits = 0;
		this.dead = false;
		this.graduated = false;
	}

	@Override
	public void collisionWith(GameObject gObj2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double deltaTime) {
		// TODO Auto-generated method stub
		
	}

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
	
//	@Override
//	public void setNewBuff() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public boolean isDead() {
		return this.life <= 0;
	}

	@Override
	public boolean isGraduated() {
		return this.graduated;
	}
	

}
