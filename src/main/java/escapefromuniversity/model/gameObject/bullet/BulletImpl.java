package escapefromuniversity.model.gameObject.bullet;

import escapefromuniversity.model.basics.GameCollisionType;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.enemy.Enemy;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.gameObject.AbstractDynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.map.Room;

/**
 * 
 * class BulletImpl.
 *
 */
public class BulletImpl extends AbstractDynamicGameObject implements Bullet {

    private final int damage;

    /**
     * 
     * @param type
     * @param position
     * @param speed
     * @param direction
     * @param damage
     * @param room
     */
    public BulletImpl(final GameObjectType type, final Point2D position, final int speed, final Vector2D direction, final int damage, final Room room) {
        super(type, position, position.sum(BulletConstant.BULLET_BOX_SIZE), speed, direction, room);
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
    public void update(final double deltaTime) {
        this.move(deltaTime);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void collisionWith(final GameObject gObj2) {
        if (this.collisionWithCheck(gObj2)) {
            return;
        }
        switch (gObj2.getType().getCollisionType()) {
        case OBSTACLE:
            this.getRoom().deleteGameObject(this);
            break;
        case BULLET:
            if (this.getType().getCollisionType().equals(GameCollisionType.IMMUNE_BULLET)) {
                this.getRoom().deleteGameObject(gObj2);
            }
            break;
        case IMMUNE_BULLET:
            if (this.getType().getCollisionType().equals(GameCollisionType.BULLET)) {
                this.getRoom().deleteGameObject(this);
            }
            break;
        case ENTITY:
            if (gObj2.getType().equals(GameObjectType.PLAYER) && !this.getType().equals(GameObjectType.BULLET_PLAYER)) {
                final Player player = (Player) gObj2;
                player.takeDamage(this.getDamage());
                this.getRoom().deleteGameObject(this);
            } else if (!gObj2.getType().equals(GameObjectType.PLAYER)
                      && this.getType().equals(GameObjectType.BULLET_PLAYER)) {
                final Enemy enemy = (Enemy) gObj2;
                enemy.takeDamage(this.getDamage());
                this.getRoom().deleteGameObject(this);
            }
            break;
        case IMMUNE_ENTITY:
            if (gObj2.getType().equals(GameObjectType.PLAYER) && !this.getType().equals(GameObjectType.BULLET_PLAYER)) {
                this.getRoom().deleteGameObject(this);
            } else if (!gObj2.getType().equals(GameObjectType.PLAYER)
                    && this.getType().equals(GameObjectType.BULLET_PLAYER)) {
                this.getRoom().deleteGameObject(this);
            }
            break;
        default:
            break;
        }
    }
}
