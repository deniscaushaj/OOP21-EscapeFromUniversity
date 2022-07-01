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

    /**
     * constant boss life.
     */
    protected static final int BOSS_1_LIFE = 100;
    protected static final int BOSS_2_LIFE = 75;
    protected static final int BOSS_3_LIFE = 95;
    protected static final int BOSS_4_LIFE = 700;
    protected static final int BOSS_5_LIFE = 10;
    protected static final int BOSS_6_LIFE = 150;

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
    protected static final double BOSS_1_SHOOT_DELAY = 5;
    protected static final double BOSS_2_SHOOT_DELAY = 2;
    protected static final double BOSS_3_SHOOT_DELAY = 3;
    protected static final double BOSS_4_SHOOT_DELAY = 2;
    protected static final double BOSS_5_SHOOT_DELAY = 2;
    protected static final double BOSS_6_SHOOT_DELAY = 1;

    /**
     * constant boss speed.
     */
    protected static final double BOSS_1_SPEED = 1.20;
    protected static final double BOSS_2_SPEED = 1.50;
    protected static final double BOSS_3_SPEED = 1.125;
    protected static final double BOSS_4_SPEED = 1.25;
    protected static final double BOSS_5_SPEED = 1.25;
    protected static final double BOSS_6_SPEED = 1.125;

    /**
     * constant boss exam.
     */
    protected static final String BOSS_1_EXAM = "1_sistemioperativi.json";
    protected static final String BOSS_2_EXAM = "2_basididati.json";
    protected static final String BOSS_3_EXAM = "3_architetture.json";
    protected static final String BOSS_4_EXAM = "4_programmazione.json";
    protected static final String BOSS_5_EXAM = "5_reti.json";
    protected static final String BOSS_6_EXAM = "6_oop.json";

}
