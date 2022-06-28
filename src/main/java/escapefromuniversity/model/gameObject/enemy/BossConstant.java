package escapefromuniversity.model.gameObject.enemy;

import escapefromuniversity.model.basics.Point2D;

/**
 * 
 * boss constants.
 *
 */
final class BossConstant {

    private BossConstant() {
    }

    protected static final Point2D BOSS_BOX_SIZE = new Point2D(1, 1.4);
    protected static final Point2D SECONDARY_BOSS_BOX_SIZE = new Point2D(1, 1);

    /**
     * constant boss life.
     */
    protected static final int BOSS_1_LIFE = 200;
    protected static final int BOSS_2_LIFE = 150;
    protected static final int BOSS_3_LIFE = 190;
    protected static final int BOSS_4_LIFE = 100;
    protected static final int BOSS_5_LIFE = 180;
    protected static final int BOSS_6_LIFE = 300;

    /**
     * constant boss impact damage.
     */
    protected static final int BOSS_1_DAMAGE = 15;
    protected static final int BOSS_2_DAMAGE = 10;
    protected static final int BOSS_3_DAMAGE = 0;
    protected static final int BOSS_4_DAMAGE = 0;
    protected static final int BOSS_5_DAMAGE = 5;
    protected static final int BOSS_6_DAMAGE = 5;

    /**
     * constant boss shoot delay in milliseconds.
     */
    protected static final long BOSS_1_SHOOT_DELAY = 500;
    protected static final long BOSS_2_SHOOT_DELAY = 2500;
    protected static final long BOSS_3_SHOOT_DELAY = 3000;
    protected static final long BOSS_4_SHOOT_DELAY = 2000;
    protected static final long BOSS_5_SHOOT_DELAY = 2500;
    protected static final long BOSS_6_SHOOT_DELAY = 1500;

    /**
     * constant boss speed.
     */
    protected static final double BOSS_1_SPEED = 0.20;
    protected static final double BOSS_2_SPEED = 0.50;
    protected static final double BOSS_3_SPEED = 0.125;
    protected static final double BOSS_4_SPEED = 0.25;
    protected static final double BOSS_5_SPEED = 0.25;
    protected static final double BOSS_6_SPEED = 0.125;

    /**
     * constant boss exam.
     */
    protected static final String BOSS_1_EXAM = "1_sistemioperativi.json";
    protected static final String BOSS_2_EXAM = "2_basididati.json";
    protected static final String BOSS_3_EXAM = "boss3.json";
    protected static final String BOSS_4_EXAM = "boss4.json";
    protected static final String BOSS_5_EXAM = "boss5.json";
    protected static final String BOSS_6_EXAM = "boss6.json";

}
