package escapefromuniversity.model.enemy;

import escapefromuniversity.model.basics.Point2D;

public class BossConstant {
	
	protected final static Point2D BOSS_BOX_SIZE = new Point2D(3,1);
	
	/**
	 * constant boss life.
	 */
	protected static final int boss1_life = 200;
	protected static final int boss2_life = 150;
	protected static final int boss3_life = 190;
	protected static final int boss4_life = 100;
	protected static final int boss5_life = 180;
	protected static final int boss6_life = 300;
	
	/**
	 * constant boss impact damage.
	 */
	protected static final int boss1_damage = 15;
	protected static final int boss2_damage = 10;
	protected static final int boss3_damage = 0;
	protected static final int boss4_damage = 0;
	protected static final int boss5_damage = 5;
	protected static final int boss6_damage = 5;
	
	/**
	 * constant boss shoot delay in milliseconds.
	 */
	protected static final long boss1_shootDelay = 50;
	protected static final long boss2_shootDelay = 250;
	protected static final long boss3_shootDelay = 300;
	protected static final long boss4_shootDelay = 200;
	protected static final long boss5_shootDelay = 250;
	protected static final long boss6_shootDelay = 150;
	
	/**
	 * constant boss speed.
	 */
	protected static final int boss1_speed = 20;
	protected static final int boss2_speed = 25;
	protected static final int boss3_speed = 10;
	protected static final int boss4_speed = 15;
	protected static final int boss5_speed = 15;
	protected static final int boss6_speed = 10;

}
