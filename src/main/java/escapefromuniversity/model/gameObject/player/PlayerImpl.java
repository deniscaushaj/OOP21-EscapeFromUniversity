package escapefromuniversity.model.gameObject.player;

import escapefromuniversity.model.basics.GameCollisionType;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.bullet.Bullet;
import escapefromuniversity.model.gameObject.bullet.BulletFactory;
import escapefromuniversity.model.gameObject.bullet.BulletFactoryImpl;
import escapefromuniversity.model.gameObject.AbstractDynamicGameObject;
import escapefromuniversity.model.gameObject.Direction;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.map.Room;

public class PlayerImpl extends AbstractDynamicGameObject implements Player{

    // TODO values to be changed:
    private static final int MAX_LIFE = 100;
    private static final int MAX_DAMAGE = 30;
    private static final int MAX_ARMOR = 20;
    private static final int START_CREDITS = 0;
    private static final int START_DAMAGE = 10;
    private static final int START_ARMOR = 0;
    private static final Direction START_DIRECTION = Direction.DOWN;
    private static final Point2D HIT_BOX_PLAYER = new Point2D(50,70);
    //	TODO eventual MAX_STATS or START_STATS
    private int life;
    private int credits;
    private int damage;
    private int armor;
    private int passed;
    private int finalMark;
    private final long shootDelay;
    private long lastShot;
    private boolean shooting;
    private Point2D prevPosition;
    private Vector2D shotDirection;
    private Direction direction;
    private final BulletFactory bulletFactory;

    /**
     * @param type
     * @param position
     * @param speed
     * @param direction
     * @param shootDelay
     */
    public PlayerImpl(GameObjectType type, Point2D position, int speed, Vector2D direction, int shootDelay, Room room) {
        super(type, position, HIT_BOX_PLAYER, speed, direction, room);
        this.life = MAX_LIFE;
        this.credits = START_CREDITS;
        this.damage = START_DAMAGE;
        this.armor = START_ARMOR;
        this.direction = START_DIRECTION;
        this.passed = 0;
        this.shootDelay = shootDelay;
        this.shooting = false;
        this.lastShot = System.currentTimeMillis();
        this.bulletFactory = new BulletFactoryImpl();
    }

    @Override
    public void collisionWith(GameObject gObj2) {
        if (this.collisionWithCheck(gObj2)) {
            if (gObj2.getType().getCollisionType() == GameCollisionType.ENTITY
                    || gObj2.getType().getCollisionType() == GameCollisionType.OBSTACLE) {
                this.setPosition(this.getPreviousPosition());
            }
        }
    }

    @Override
    public void update(double deltaTime) {
        if (this.shooting) {
            this.shoot();
        }
        this.setPreviousPosition(this.getObjectPosition());
        this.move(deltaTime);
    }

    @Override
    public int getMaxLife() {
        return MAX_LIFE;
    }

    @Override
    public int getMaxDamage() {return MAX_DAMAGE;}

    @Override
    public int getMaxArmor() {
        return MAX_ARMOR;
    }

    @Override
    public int getLife() {
        return this.life;
    }

    @Override
    public int getCredits() {
        return this.credits;
    }

    @Override
    public int getDamage() {return this.damage;}

    @Override
    public int getArmor() {return this.armor;}

    @Override
    public int getFinalMark() {
        return this.finalMark;
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
    public void setDamage(final int damage) {
        this.damage = damage;
    }

    @Override
    public void setArmor(final int armor) {
        this.armor = armor;
    }

    @Override
    public void setFinalMark(final int newMark) {
        this.finalMark = this.finalMark + newMark;
    }

    @Override
    public void resetLife() {
        this.setLife(this.getMaxLife());
    }

    @Override
    public void setDamageBuff(final int damage) {
        this.setDamage(this.getDamage() + damage);
    }

    @Override
    public void setArmorBuff(final int armor) {
        this.setArmor(this.getArmor() + armor);
    }

    @Override
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void takeDamage(final int damage) {
        this.setLife(this.getLife() + this.getArmor() - damage);
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
        final Bullet bullet = bulletFactory.createPlayerBullet(this.getObjectPosition(), this.shotDirection, this.damage, this.room);
        this.getRoom().addDynamicGameObject(bullet);
        this.shooting = false;
    }

    private void setPreviousPosition (final Point2D prevPos) {
        this.prevPosition = prevPos;
    }

    private Point2D getPreviousPosition () {
        return this.prevPosition;
    }

    @Override
    public void setLastDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction getLastDirection() {
        return this.direction;
    }

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
