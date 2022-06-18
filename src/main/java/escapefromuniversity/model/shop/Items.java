package escapefromuniversity.model.shop;

import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.quiz.Answer;
import escapefromuniversity.model.quiz.Competition;

public enum Items {

    INCREASE_ATTACK, INCREASE_DEFENSE, RESET_HEALTH, DOUBLE_CHANCE;

    public void increaseDamage(Player player, int damageBuff){
//        if(player.getDamage() < player.getMaxDamage()){} TODO l'if è da usare fuori quando chiami il metodo, altrimenti così puoi comprarlo sempre e poi l'if a volte lo rende inefficace
        player.setDamageBuff(damageBuff);
    }

    public void increaseArmor(Player player, int armorBuff){
//        if(player.getArmor() < player.getMaxArmor()){} TODO idem
        player.setArmorBuff(armorBuff);
    }

    public void resetHealth(Player player){
//        if(player.getLife() != player.getMaxLife()){} TODO idem
        player.resetLife();
    }

    public void doubleChance(Answer ans, Competition competition){
//        if(!ans.isCorrect() && !competition.getBonusQuiz()){} TODO idem
        competition.setBonusQuiz(true);
    }
}
