package escapefromuniversity.model.shop;

import escapefromuniversity.model.gameObject.player.Player;

/**
 * An enumeration for all the existing items.
 */
public enum Items {

    /**
     * Available items in the shop.
     */
    INCREASE_DAMAGE, INCREASE_ARMOR, RESET_HEALTH, DOUBLE_CHANCE;

    private static final int DAMAGE_BUFF = 5;
    private static final int ARMOR_BUFF = 5;

    /**
     * Increase player's attack.
     * @param player the player
     * @return {@code true} if current damage is less than max damage, {@code false} otherwise
     */
    public boolean increaseDamage(final Player player) {
        var maxDam = player.getMaxDamage();
        var currDam = player.getDamage();
        if (currDam < maxDam) {
            player.setDamageBuff(DAMAGE_BUFF);
            return true;
        }
        return false;
    }

    /**
     * Increase player's armor.
     * @param player the player
     * @return {@code true} if current armor is less than max armor, {@code false} otherwise
     */
    public boolean increaseArmor(final Player player) {
        var maxDef = player.getMaxArmor();
        var currDef = player.getArmor();
        if (currDef < maxDef) {
            player.setArmorBuff(ARMOR_BUFF);
            return true;
        }
        return false;
    }

    /**
     * Reset player's health.
     * @param player the player
     * @return {@code true} if current life is less than max life, {@code false} otherwise
     */
    public boolean resetHealth(final Player player) {
        var maxLife = player.getMaxLife();
        var currLife = player.getLife();
        if (currLife < maxLife) {
            player.resetLife();
            return true;
        }
        return false;
    }

    /**
     * Gives an extra correct answer during the next exam.
     * @param player the player
     */
    public void doubleChance(final Player player) {
        if (!player.hasBonusQuiz()) {
            player.setBonusQuiz(true);
        }
    }
}
