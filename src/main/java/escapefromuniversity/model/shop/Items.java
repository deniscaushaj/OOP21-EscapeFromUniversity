package escapefromuniversity.model.shop;

import escapefromuniversity.model.quiz.Exam;
import escapefromuniversity.model.gameObject.player.Player;

public enum Items {

    INCREASE_DAMAGE, INCREASE_ARMOR, RESET_HEALTH, DOUBLE_CHANCE;

    private static final int DAMAGE_BUFF = 10;
    private static final int ARMOR_BUFF = 10;

    /**
     * Increase player's attack
     * @param player the player
     * @return true if current damage is less then max damage, false otherwise
     */
    public boolean increaseDamage(final Player player){
        var maxDam = player.getMaxDamage();
        var currDam = player.getDamage();
        if(currDam < maxDam){
            player.setDamageBuff(DAMAGE_BUFF);
            return true;
        }
        return false;
    }

    /**
     * Increase player's armor
     * @param player the player
     * @return true if current armor is less than max armor, false otherwise
     */
    public boolean increaseArmor(final Player player){
        var maxDef = player.getMaxArmor();
        var currDef = player.getArmor();
        if(currDef < maxDef){
            player.setArmorBuff(ARMOR_BUFF);
            return true;
        }
        return false;
    }

    /**
     * Reset player's health.
     * @param player the player
     * @return true if current life is less than max life, false otherwise
     */
    public boolean resetHealth(final Player player){
        var maxLife = player.getMaxLife();
        var currLife = player.getLife();
        if(currLife < maxLife){
            player.resetLife();
            return true;
        }
        return false;
    }

    /**
     * Gives another chance to the player when the answer is incorrect.
     * @param competition the current exam
     */
    public void doubleChance(Exam competition){
        if(!competition.isBonusAvailable()){
            competition.setBonusQuiz(true);
        }
    }
}