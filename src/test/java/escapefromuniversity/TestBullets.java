package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.bullet.Bullet;
import escapefromuniversity.model.gameObject.bullet.BulletFactory;
import escapefromuniversity.model.gameObject.bullet.BulletFactoryImpl;
import escapefromuniversity.model.map.Mapp;
import escapefromuniversity.model.map.MapImpl;

/**
 * 
 * test for bullet.
 *
 */
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
        Mapp map = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        int damage = 10;
        Bullet bul = bullets.createPlayerBullet(pos, vec, damage, map);
        map.addDynamicGameObject(bul);
        System.out.println(bul.getObjectPosition().getX());
        assertEquals(vec, bul.getDirection());
        assertEquals(pos, bul.getObjectPosition());
        assertEquals(bul.getDamage(), damage);
        assertEquals(bul.getSpeed(), PLAYER_BULLET_SPEED);
        assertEquals(bul.getMap(), map);
    }

    @Test
    public void testCreateBulletBoss1() {
        Mapp map = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Bullet bul = bullets.createBoss1Bullet(pos, vec, map);
        map.addDynamicGameObject(bul);
        System.out.println(bul.getObjectPosition().getX());
        assertEquals(vec, bul.getDirection());
        assertEquals(pos, bul.getObjectPosition());
        assertEquals(bul.getDamage(), BOSS_1_BULLET_DAMAGE);
        assertEquals(bul.getSpeed(), BOSS_1_BULLET_SPEED);
        assertEquals(bul.getMap(), map);
    }

    @Test
    public void testCreateBulletBoss2() {
        Mapp map = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Bullet bul = bullets.createBoss2Bullet(pos, vec, map);
        map.addDynamicGameObject(bul);
        System.out.println(bul.getObjectPosition().getX());
        assertEquals(vec, bul.getDirection());
        assertEquals(pos, bul.getObjectPosition());
        assertEquals(bul.getDamage(), BOSS_2_BULLET_DAMAGE);
        assertEquals(bul.getSpeed(), BOSS_2_BULLET_SPEED);
        assertEquals(bul.getMap(), map);
    }

    @Test
    public void testCreateBulletBoss3() {
        Mapp map = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Bullet bul = bullets.createBoss3Bullet(pos, vec, map);
        map.addDynamicGameObject(bul);
        System.out.println(bul.getObjectPosition().getX());
        assertEquals(vec, bul.getDirection());
        assertEquals(pos, bul.getObjectPosition());
        assertEquals(bul.getDamage(), BOSS_3_BULLET_DAMAGE);
        assertEquals(bul.getSpeed(), BOSS_3_BULLET_SPEED);
        assertEquals(bul.getMap(), map);
    }

    @Test
    public void testCreateBulletBoss4() {
        Mapp map = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Bullet bul = bullets.createBoss4Bullet(pos, vec, map);
        map.addDynamicGameObject(bul);
        System.out.println(bul.getObjectPosition().getX());
        assertEquals(vec, bul.getDirection());
        assertEquals(pos, bul.getObjectPosition());
        assertEquals(bul.getDamage(), BOSS_4_BULLET_DAMAGE);
        assertEquals(bul.getSpeed(), BOSS_4_BULLET_SPEED);
        assertEquals(bul.getMap(), map);
    }

    @Test
    public void testCreateBulletBoss5() {
        Mapp map = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Bullet bul = bullets.createBoss5Bullet(pos, vec, map);
        map.addDynamicGameObject(bul);
        System.out.println(bul.getObjectPosition().getX());
        assertEquals(vec, bul.getDirection());
        assertEquals(pos, bul.getObjectPosition());
        assertEquals(bul.getDamage(), BOSS_5_BULLET_DAMAGE);
        assertEquals(bul.getSpeed(), BOSS_5_BULLET_SPEED);
        assertEquals(bul.getMap(), map);
    }

    @Test
    public void testCreateBulletBoss6() {
        Mapp map = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Bullet bul = bullets.createBoss6Bullet(pos, vec, map);
        map.addDynamicGameObject(bul);
        System.out.println(bul.getObjectPosition().getX());
        assertEquals(vec, bul.getDirection());
        assertEquals(pos, bul.getObjectPosition());
        assertEquals(bul.getDamage(), BOSS_6_BULLET_DAMAGE);
        assertEquals(bul.getSpeed(), BOSS_6_BULLET_SPEED);
        assertEquals(bul.getMap(), map);
    }

}
