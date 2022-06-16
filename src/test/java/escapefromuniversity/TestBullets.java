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

@Test
public class TestBullets {
	
	private BulletFactory bullets = new BulletFactoryImpl();
	
	public void testCreateBulletPlayer() {
		Room room = new RoomImpl(null);
		final Vector2D vec = new Vector2D(0, 1);
		final Point2D pos = new Point2D(0,0);
		int bonusDamage = 0;
		Bullet bul = bullets.createPlayerBullet(pos, vec, bonusDamage, room);
		room.addDynamicGameObject(bul);
		assertEquals(vec, bul.getDirection());
		assertEquals(pos, bul.getObjectPosition());
	}

}
