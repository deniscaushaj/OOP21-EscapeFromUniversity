package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.enemy.Boss;
import escapefromuniversity.model.enemy.BossFactory;
import escapefromuniversity.model.enemy.BossFactoryImpl;
import escapefromuniversity.model.map.Room;
import escapefromuniversity.model.map.RoomImpl;

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
        Room room = new RoomImpl(null);
        final Vector2D vec = new Vector2D(0, 1);
        final Point2D pos = new Point2D(0, 0);
        Boss boss = bosses.createBoss1(pos, vec, room);
        room.addDynamicGameObject(boss);
        assertEquals(boss.getRoom(), room);
        assertEquals(boss.getObjectPosition(), pos);
        assertEquals(boss.getLife(), BOSS_1_LIFE);
        assertEquals(boss.getImpactDamage(), BOSS_1_DAMAGE);
    }

}
