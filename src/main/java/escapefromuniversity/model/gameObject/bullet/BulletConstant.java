package escapefromuniversity.model.gameObject.bullet;

import escapefromuniversity.model.basics.Point2D;

/**
 * 
 * Bullet constant.
 *
 */
final class BulletConstant {

    private BulletConstant() {
    }

    protected static final Point2D BULLET_BOX_SIZE = new Point2D(0.3, 0.3);

    /**
     * Constant of bullets speed.
     */
    protected static final double PLAYER_BULLET_SPEED = 3;
    protected static final double BOSS_1_BULLET_SPEED = 3;
    protected static final double BOSS_2_BULLET_SPEED = 2.5;
    protected static final double BOSS_3_BULLET_SPEED = 2.5;
    protected static final double BOSS_4_BULLET_SPEED = 3;
    protected static final double BOSS_5_BULLET_SPEED = 3.5;
    protected static final double BOSS_6_BULLET_SPEED = 4;


    /**
     * Constants of bullets damage.
     */
    protected static final int BOSS_1_BULLET_DAMAGE = 15;
    protected static final int BOSS_2_BULLET_DAMAGE = 20;
    protected static final int BOSS_3_BULLET_DAMAGE = 30;
    protected static final int BOSS_4_BULLET_DAMAGE = 35;
    protected static final int BOSS_5_BULLET_DAMAGE = 25;
    protected static final int BOSS_6_BULLET_DAMAGE = 10;

}
