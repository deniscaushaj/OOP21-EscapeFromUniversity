package escapefromuniversity.model.shop;

import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.quiz.Answer;
import escapefromuniversity.model.quiz.Competition;

public enum Items {

    INCREASE_ATTACK, INCREASE_DEFENSE, RESET_HEALTH, DOUBLE_CHANCE;

    private static final int ATT_BUFF = 10;
    private static final int DEF_BUFF = 10;

    /**
     * Increase player's attack
     * @param player the player
     * @return true if current damage is less then max damage, false otherwise
     */
    public boolean increaseAttack(final Player player){
        var maxDam = player.getMaxDamage();
        var currDam = player.getDamage();
        if(currDam < maxDam){
            player.setDamageBuff(ATT_BUFF);
            return true;
        }
        return false;
    }

    /**
     * Increase player's armor
     * @param player the player
     * @return true if current armor is less than max armor, false otherwise
     */
    public boolean increaseDefense(final Player player){
        var maxDef = player.getMaxArmor();
        var currDef = player.getArmor();
        if(currDef < maxDef){
            player.setArmorBuff(DEF_BUFF);
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
     * @param ans the answer given by the user
     * @param competition the current exam
     */
    public void doubleChance(Answer ans, Competition competition){
        if(!competition.getBonusQuiz()){
            competition.setBonusQuiz(true);
        }
    }
}