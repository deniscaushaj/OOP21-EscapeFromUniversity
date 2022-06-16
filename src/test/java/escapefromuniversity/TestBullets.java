package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.bullet.Bullet;
import escapefromuniversity.model.bullet.BulletFactory;
import escapefromuniversity.model.bullet.BulletFactoryImpl;
import escapefromuniversity.model.map.Room;
import escapefromuniversity.model.map.RoomImpl;


public class TestBullets {
	
	protected static final int PLAYER_BULLET_SPEED = 30;
	protected static final int BOSS_1_BULLET_SPEED = 30;
	protected static final int BOSS_2_BULLET_SPEED = 25;
	protected static final int BOSS_3_BULLET_SPEED = 25;
	protected static final int BOSS_4_BULLET_SPEED = 30;
	protected static final int BOSS_5_BULLET_SPEED = 35;
	protected static final int BOSS_6_BULLET_SPEED = 40;
	
	protected static final int BOSS_1_BULLET_DAMAGE = 15;
	protected static final int BOSS_2_BULLET_DAMAGE = 20;
	protected static final int BOSS_3_BULLET_DAMAGE = 30;
	protected static final int BOSS_4_BULLET_DAMAGE = 35;
	protected static final int BOSS_5_BULLET_DAMAGE = 25;
	protected static final int BOSS_6_BULLET_DAMAGE = 10;
	
	private BulletFactory bullets = new BulletFactoryImpl();
	
	@Test
	public void testCreateBulletPlayer() {
		Room room = new RoomImpl(null);
		final Vector2D vec = new Vector2D(0, 1);
		final Point2D pos = new Point2D(0,0);
		int damage = 10;
		Bullet bul = bullets.createPlayerBullet(pos, vec, damage, room);
		room.addDynamicGameObject(bul);
		System.out.println(bul.getObjectPosition().getX());
		assertEquals(vec, bul.getDirection());
		assertEquals(pos, bul.getObjectPosition());
		assertEquals(bul.getDamage(), damage);
		assertEquals(bul.getSpeed(), PLAYER_BULLET_SPEED);
		assertEquals(bul.getRoom(), room);
	}
	
	@Test
	public void testCreateBulletBoss1() {
		Room room = new RoomImpl(null);
		final Vector2D vec = new Vector2D(0, 1);
		final Point2D pos = new Point2D(0,0);
		Bullet bul = bullets.createBoss1Bullet(pos, vec, room);
		room.addDynamicGameObject(bul);
		System.out.println(bul.getObjectPosition().getX());
		assertEquals(vec, bul.getDirection());
		assertEquals(pos, bul.getObjectPosition());
		assertEquals(bul.getDamage(), BOSS_1_BULLET_DAMAGE);
		assertEquals(bul.getSpeed(), BOSS_1_BULLET_SPEED);
		assertEquals(bul.getRoom(), room);
	}

}
