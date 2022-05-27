package escapefromuniversity.model.enemy;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import escapefromuniversity.model.gameObject.AbstractDynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.player.Player;

public abstract class BossImp extends AbstractDynamicGameObject implements Boss{
	
	private int life;
	private final long shootDelay;
	private long shootLastTime;
	private BossState state;
	private int impatDamage;
	private Point2D previousPosition;
	private int impactDamage;
	
	public BossImp(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impactDamage) {
		super(type, position, upperCorner, speed, direction);
		this.life = life;
		this.shootDelay = shootDelay;
		this.state = BossState.QUIZ;
		this.impactDamage = impactDamage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void maybeShoot() {
		if(this.canShoot()) {
			this.shoot();
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	private boolean canShoot() {
		if(System.currentTimeMillis() - this.shootLastTime > this.shootDelay) {
			this.shootLastTime = System.currentTimeMillis();
			return true;
		}
		return false;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	abstract void shoot();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLife() {
		return this.life;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void takeDamage(int damage) {
		this.life = this.life - damage;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(double deltaTime) {
		if(this.state.equals(BossState.FIGHT)) {
			this.maybeShoot();
			this.setPreviousPosition(this.getObjectPosition());
			this.move(deltaTime);
			this.setDirection(this.newDirection());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void collisionWith(GameObject gObj2) {
		if(this.collisionWithCheck(gObj2)) {
			switch(gObj2.getType().getCollisionType()) {
			case OBSTACLE:
				this.setPosition(this.getPreviousPosition());
				break;
			case ENTITY:
				if(gObj2.getType().equals(GameObjectType.PLAYER)) {
					final Player player = (Player) gObj2;
					player.takeDamage(this.getImpatDamage());
				}
				this.setPosition(this.getPreviousPosition());
				break;
			default:
				break;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getImpatDamage() {
		return this.impactDamage;
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected Vector2D newDirection() {
		Point2D playerPos = this.getRoom().getPlayerPosition();
		return new Vector2D((this.getObjectPosition().getX() - playerPos.getX())/this.getObjectPosition().module(playerPos),
				            (this.getObjectPosition().getY() - playerPos.getY())/this.getObjectPosition().module(playerPos));
	}

	/**
	 * {@inheritDoc}
	 */
	protected Point2D getPreviousPosition() {
		return previousPosition;
	}

	/**
	 * {@inheritDoc}
	 */
	private void setPreviousPosition(Point2D previousPosition) {
		this.previousPosition = previousPosition;
	}

}
