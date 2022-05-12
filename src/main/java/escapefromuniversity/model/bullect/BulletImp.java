package escapefromuniversity.model.bullect;

import escapefromuniversity.model.AbstractDynamicGameObject;
import escapefromuniversity.model.GameCollisionType;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import escapefromuniversity.model.enemy.Enemy;

public class BulletImp extends AbstractDynamicGameObject implements Bullet{
	
	private final int damage;
	

	public BulletImp(GameObjectType type, Point2D position, int speed, Vector2D direction, int damage) {
		super(type, position, position.sum(BulletCostant.BULLET_BOX_OCCUPATION), speed, direction);
		this.damage = damage;
	}
    
	@Override
	public int getDamage() {
		return this.damage;
	}

	@Override
	public void update(double deltaTime) {
		this.move(deltaTime);
		
	}

	@Override
	public void collisionWith(GameObject gObj2) {
		if(this.collisionWithCont(gObj2)) {
			return;
		}
		switch(gObj2.getType().getCollisionType()) {
		case OBSTACLE:
			//delete this object
			break;
		case BULLET:
			if(this.getType().getCollisionType().equals(GameCollisionType.IMMUNE_BULLET)) {
				//delete gObj2
			}
			break;
		case IMMUNE_BULLET:
			if(this.getType().getCollisionType().equals(GameCollisionType.BULLET)) {
				//delete this object
			}
			break;
		case ENTITY:
			if(gObj2.getType().equals(GameObjectType.PLAYER) && !this.getType().equals(GameObjectType.BULLET_PROTAGINIST)) {
				//fare danno al protagonista
				//delete this object
			}else if(!gObj2.getType().equals(GameObjectType.PLAYER) && 
					 this.getType().equals(GameObjectType.BULLET_PROTAGINIST)) {
				final Enemy enemy = (Enemy) gObj2;
				enemy.takeDamage(this.getDamage());
				//delete this object
			}
			break;
		case IMMUNE_ENTITY:
			if(gObj2.getType().equals(GameObjectType.PLAYER) && !this.getType().equals(GameObjectType.BULLET_PROTAGINIST)) {
				//delete this object
			}else if(!gObj2.getType().equals(GameObjectType.PLAYER) && 
					 this.getType().equals(GameObjectType.BULLET_PROTAGINIST)) {
				//delete this object
			}
		default:
			break;
		}
		
	}

}
