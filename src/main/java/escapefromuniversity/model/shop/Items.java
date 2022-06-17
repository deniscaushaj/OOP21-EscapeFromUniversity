package escapefromuniversity.model.shop;

import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.quiz.Answer;
import escapefromuniversity.model.quiz.Competition;

public enum Items {

    INCREASE_ATTACK, INCREASE_DEFENSE, RESET_HEALTH, DOUBLE_CHANCE;

    public void increaseAttack(Player player){
        var maxDam = player.getMaxDamage();
        var currDam = player.getDamage();
        if(currDam < maxDam){
            player.setDamageBuff(currDam+10);
        }
    }

    public void increaseDefense(Player player){
        var maxDef = player.getMaxArmor();
        var currDef = player.getArmor();
        if(currDef < maxDef){
            player.setArmorBuff(currDef+10);
        }
    }

    public void resetHealth(Player player){
        var maxLife = player.getMaxLife();
        var currLife = player.getLife();
        if(currLife != maxLife){
            player.resetLife();
        }
    }

    public void doubleChance(Answer ans, Competition competition){
        if(!ans.isCorrect() && !competition.getBonusQuiz()){
           competition.setBonusQuiz(true);
        }
    }
}
