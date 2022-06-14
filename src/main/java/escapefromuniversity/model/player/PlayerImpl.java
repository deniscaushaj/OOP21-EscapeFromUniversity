package escapefromuniversity.model.player;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.bullet.Bullet;
import escapefromuniversity.model.bullet.BulletFactory;
import escapefromuniversity.model.bullet.BulletFactoryImpl;
import escapefromuniversity.model.gameObject.AbstractDynamicGameObject;
import escapefromuniversity.model.gameObject.Direction;
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
    private long lastShot;
    private boolean shooting;
    private Vector2D shotDirection;
    private final BulletFactory bulletFactory;
    
    /**
     * @param type
     * @param position
     * @param speed
     * @param direction
     * @param shootDelay
     */
    public PlayerImpl(GameObjectType type, Point2D position, int speed, Vector2D direction, int shootDelay, BulletFactory bulletFactory) {
        super(type, position, HIT_BOX_PLAYER, speed, direction);
        this.life = MAX_LIFE;
        this.credits = 0;
        this.passed = 0;
        this.shootDelay = shootDelay;
        this.shooting = false;
        this.lastShot = System.currentTimeMillis();
        this.bulletFactory = new BulletFactoryImpl();
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
        if (this.shooting) {
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
        final long currentTime = System.currentTimeMillis();
        if (currentTime - this.lastShot >= this.shootDelay) {
            this.lastShot = currentTime;
            return true;
        }
        return false;
    }
    
    @Override
    public void setShoot(final boolean shooting, final Direction direction) {
        if (this.canShoot()) {
            this.shooting = shooting;
            this.shotDirection = direction.getDirection();
        }
    }

    @Override
    public void shoot() {
        final Bullet bullet = bulletFactory.createPlayerBullet(this.getObjectPosition(), this.shotDirection);
        this.getRoom().addDynamicGameObject(bullet);
        this.shooting = false;
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
