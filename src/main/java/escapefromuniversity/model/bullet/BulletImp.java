package escapefromuniversity.model.bullet;

import escapefromuniversity.model.AbstractDynamicGameObject;
import escapefromuniversity.model.GameCollisionType;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import escapefromuniversity.model.enemy.Enemy;
import model.player.Player;

public class BulletImp extends AbstractDynamicGameObject implements Bullet{
	
	private final int damage;
	

	public BulletImp(GameObjectType type, Point2D position, int speed, Vector2D direction, int damage) {
		super(type, position, position.sum(BulletCostant.BULLET_BOX_OCCUPATION), speed, direction);
		this.damage = damage;
	}
    
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDamage() {
		return this.damage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(double deltaTime) {
		this.move(deltaTime);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void collisionWith(GameObject gObj2) {
		if(this.collisionWithCheck(gObj2)) {
			return;
		}
		switch(gObj2.getType().getCollisionType()) {
		case OBSTACLE:
			this.getRoom().deleteGameObject(this);
			break;
		case BULLET:
			if(this.getType().getCollisionType().equals(GameCollisionType.IMMUNE_BULLET)) {
				this.getRoom().deleteGameObject(gObj2);
			}
			break;
		case IMMUNE_BULLET:
			if(this.getType().getCollisionType().equals(GameCollisionType.BULLET)) {
				this.getRoom().deleteGameObject(this);
			}
			break;
		case ENTITY:
			if(gObj2.getType().equals(GameObjectType.PLAYER) && !this.getType().equals(GameObjectType.BULLET_PROTAGINIST)) {
				final Player player = (Player) gObj2;
				player.takeDamage(this.getDamage());
				this.getRoom().deleteGameObject(this);
			}else if(!gObj2.getType().equals(GameObjectType.PLAYER) && 
					 this.getType().equals(GameObjectType.BULLET_PROTAGINIST)) {
				final Enemy enemy = (Enemy) gObj2;
				enemy.takeDamage(this.getDamage());
				this.getRoom().deleteGameObject(this);
			}
			break;
		case IMMUNE_ENTITY:
			if(gObj2.getType().equals(GameObjectType.PLAYER) && !this.getType().equals(GameObjectType.BULLET_PROTAGINIST)) {
				this.getRoom().deleteGameObject(this);
			}else if(!gObj2.getType().equals(GameObjectType.PLAYER) && 
					 this.getType().equals(GameObjectType.BULLET_PROTAGINIST)) {
				this.getRoom().deleteGameObject(this);
			}
		default:
			break;
		}
		
	}

}
