package escapefromuniversity.model.shop;

import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.quiz.Answer;
import escapefromuniversity.model.quiz.Competition;

public enum Items {

    INCREASE_ATTACK, INCREASE_DEFENSE, RESET_HEALTH, DOUBLE_CHANCE;

    private static final int ATT_BUFF = 10;
    private static final int DEF_BUFF = 10;
    private Player player;

    /**
     * Increase player's attack
     * @return true if current damage is less then max damage, false otherwise
     */
    public boolean increaseAttack(){
        var maxDam = player.getMaxDamage();
        var currDam = player.getDamage();
        if(currDam < maxDam){
            player.setDamageBuff(currDam+ATT_BUFF);
            return true;
        }
        return false;
    }

    /**
     * Increase player's armor
     * @return true if current armor is less then max armor, false otherwise
     */
    public boolean increaseDefense(){
        var maxDef = player.getMaxArmor();
        var currDef = player.getArmor();
        if(currDef < maxDef){
            player.setArmorBuff(currDef+DEF_BUFF);
            return true;
        }
        return false;
    }

    /**
     * Reset player's health
     */
    public void resetHealth(){
        var maxLife = player.getMaxLife();
        var currLife = player.getLife();
        if(currLife < maxLife){
            player.resetLife();
        }
    }

    /**
     * Gives another chance to the player when the answer is incorrect
     * @param ans the answer given by the user
     * @param competition the current exam
     */
    public void doubleChance(Answer ans, Competition competition){
        if(!ans.isCorrect() && !competition.getBonusQuiz()){
            competition.setBonusQuiz(true);
        }
    }
}