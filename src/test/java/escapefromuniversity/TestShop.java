package escapefromuniversity;

import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.gameObject.player.PlayerImpl;
import escapefromuniversity.model.quiz.ExamImpl;
import escapefromuniversity.model.shop.Items;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestShop {

    private final Player player;

    public TestShop(Player player){
        this.player = new PlayerImpl(GameObjectType.PLAYER, null, 0, null, 0, null);
    }

    @Test
    public void testAttack() {
        for (int i = 0; i < 4; i++) {
            assertTrue(Items.INCREASE_DAMAGE.increaseDamage(player));
        }
        assertFalse(Items.INCREASE_DAMAGE.increaseDamage(player));
    }

    @Test
    public void testArmor() {
        for (int i = 0; i < 4; i++) {
            assertTrue(Items.INCREASE_ARMOR.increaseArmor(player));
        }
        assertFalse(Items.INCREASE_ARMOR.increaseArmor(player));
    }

    @Test
    public void testLife() {
        player.setLife(5);
        assertTrue(Items.RESET_HEALTH.resetHealth(player));
        player.setLife(player.getMaxLife());
        assertFalse(Items.RESET_HEALTH.resetHealth(player));
    }
}
