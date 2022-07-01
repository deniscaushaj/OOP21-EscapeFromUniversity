package escapefromuniversity.model.gameObject.enemy;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.AbstractDynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.gameObject.player.Player;

/**
 * 
 * abstract class AbstractBoss.
 *
 */
public abstract class AbstractBoss extends AbstractDynamicGameObject implements Boss {

    private int life;
    private final long shootDelay;
    private long shootLastTime;
    private BossState bossState;
    private Point2D previousPosition;
    private final int impactDamage;
    private final String exam;

    /**
     * 
     * @param speed
     * @param position
     * @param upperCorner
     * @param direction
     * @param type
     * @param life
     * @param shootDelay
     * @param impactDamage
     * @param exam
     * @param map
     */
    public AbstractBoss(final double speed, final Point2D position, final Point2D upperCorner, final Vector2D direction, final GameObjectType type, final int life, final long shootDelay, final int impactDamage, final String exam, final GameInit map) {
        super(type, position, upperCorner, speed, direction, map);
        this.life = life;
        this.shootDelay = shootDelay;
        this.bossState = BossState.QUIZ;
        this.impactDamage = impactDamage;
        this.exam = exam;
        this.previousPosition = position;
        //this.setDirection(direction);
        this.setState(State.LEFT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void maybeShoot() {
        if (this.canShoot()) {
            this.shoot();
        }
    }

    private boolean canShoot() {
        if (System.currentTimeMillis() - this.shootLastTime > this.shootDelay) {
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
    public void takeDamage(final int damage) {
        this.life = this.life - damage;
        if (this.life <= 0) {
            this.kill();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double deltaTime) {
        if (this.bossState == BossState.FIGHT) {
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
    public void collisionWith(final GameObject gObj2) {
        if (this.collisionWithCheck(gObj2)) {
            switch (gObj2.getType().getCollisionType()) {
            case OBSTACLE:
                this.setPosition(this.getPreviousPosition());
                this.setDirection(getDirection().multiplication(-1));
                break;
            case ENTITY:
                if (gObj2.getType().equals(GameObjectType.PLAYER)) {
                    if (this.bossState.equals(BossState.QUIZ)) {
                        this.getMap().goQuiz(this);
                    } else {
                        final Player player = (Player) gObj2;
                        player.takeDamage(this.getImpactDamage());
                    }
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
    public int getImpactDamage() {
        return this.impactDamage;
    }

    /**
     * {@inheritDoc}
     */
    protected Vector2D newDirection() {
        Point2D playerPos = this.getMap().getPlayer().getObjectPosition();
        return new Vector2D(this.getObjectPosition().getX() - playerPos.getX(),
                this.getObjectPosition().getY() - playerPos.getY()).normal();
    }

    /**
     * {@inheritDoc}
     */
    protected Point2D getPreviousPosition() {
        return previousPosition;
    }

    private void setPreviousPosition(final Point2D previousPosition) {
        this.previousPosition = previousPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBossState(final BossState state) {
        this.bossState = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override

    public BossState getBossState() {
        return this.bossState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void kill() {
        this.getMap().deleteGameObject(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setQuizResult(final int result) {
        this.getMap().getPlayer().setFinalMark(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setQuizCredit(final int credits) {
        this.getMap().getPlayer().addCredits(credits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBossExam() {
        return this.exam;
    }
}
