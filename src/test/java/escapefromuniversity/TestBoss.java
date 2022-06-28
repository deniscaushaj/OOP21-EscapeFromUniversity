package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.enemy.BossFactory;
import escapefromuniversity.model.gameObject.enemy.BossFactoryImpl;
import escapefromuniversity.model.map.MapImpl;
import escapefromuniversity.model.map.Mapp;

/**
 * 
 * test for bullet.
 *
 */
public class TestBoss {

    private static final int BOSS_1_LIFE = 200;
    private static final int BOSS_2_LIFE = 150;
    private static final int BOSS_3_LIFE = 190;
    private static final int BOSS_4_LIFE = 100;
    private static final int BOSS_5_LIFE = 180;
    private static final int BOSS_6_LIFE = 300;

    private static final int BOSS_1_DAMAGE = 15;
    private static final int BOSS_2_DAMAGE = 10;
    private static final int BOSS_3_DAMAGE = 0;
    private static final int BOSS_4_DAMAGE = 0;
    private static final int BOSS_5_DAMAGE = 5;
    private static final int BOSS_6_DAMAGE = 5;

    private final BossFactory bosses = new BossFactoryImpl();

    @Test
    public void testCreateBoss1() {
        Mapp map = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Boss boss = bosses.createBoss1(pos, vec, map);
        map.addDynamicGameObject(boss);
        assertEquals(boss.getMap(), map);
        assertEquals(boss.getObjectPosition(), pos);
        assertEquals(boss.getLife(), BOSS_1_LIFE);
        assertEquals(boss.getImpactDamage(), BOSS_1_DAMAGE);
    }

    @Test
    public void testCreateBoss2() {
        Mapp room = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Boss boss = bosses.createBoss2(pos, vec, room);
        room.addDynamicGameObject(boss);
        assertEquals(boss.getMap(), room);
        assertEquals(boss.getObjectPosition(), pos);
        assertEquals(boss.getLife(), BOSS_2_LIFE);
        assertEquals(boss.getImpactDamage(), BOSS_2_DAMAGE);
    }

    @Test
    public void testCreateBoss3() {
        Mapp room = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Boss boss = bosses.createBoss3(pos, vec, room);
        room.addDynamicGameObject(boss);
        assertEquals(boss.getMap(), room);
        assertEquals(boss.getObjectPosition(), pos);
        assertEquals(boss.getLife(), BOSS_3_LIFE);
        assertEquals(boss.getImpactDamage(), BOSS_3_DAMAGE);
    }

    @Test
    public void testCreateBoss4() {
        Mapp room = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Boss boss = bosses.createBoss4(pos, vec, room);
        room.addDynamicGameObject(boss);
        assertEquals(boss.getMap(), room);
        assertEquals(boss.getObjectPosition(), pos);
        assertEquals(boss.getLife(), BOSS_4_LIFE);
        assertEquals(boss.getImpactDamage(), BOSS_4_DAMAGE);
    }

    @Test
    public void testCreateBoss5() {
        Mapp room = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Boss boss = bosses.createBoss5(pos, vec, room);
        room.addDynamicGameObject(boss);
        assertEquals(boss.getMap(), room);
        assertEquals(boss.getObjectPosition(), pos);
        assertEquals(boss.getLife(), BOSS_5_LIFE);
        assertEquals(boss.getImpactDamage(), BOSS_5_DAMAGE);
    }

    @Test
    public void testCreateBoss6() {
        Mapp room = new MapImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Boss boss = bosses.createBoss6(pos, vec, room);
        room.addDynamicGameObject(boss);
        assertEquals(boss.getMap(), room);
        assertEquals(boss.getObjectPosition(), pos);
        assertEquals(boss.getLife(), BOSS_6_LIFE);
        assertEquals(boss.getImpactDamage(), BOSS_6_DAMAGE);
    }
}
