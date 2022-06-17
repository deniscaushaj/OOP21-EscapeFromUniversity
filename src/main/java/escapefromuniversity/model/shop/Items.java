package escapefromuniversity.model.shop;

import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.quiz.Answer;
import escapefromuniversity.model.quiz.Quiz;

public enum Items {

    INCREASE_ATTACK, INCREASE_DEFENSE, RESET_HEALTH, DOUBLE_CHANCE;

    public void increaseAttack(Player player){
        player.setDamageBuff(0); //cambiare valore TODO
    }

    public void increaseDefense(Player player){
        player.setArmorBuff(0); // cambia valore TODO
    }

    public void resetHealth(Player player){
        player.resetLife();
    }

    public void doubleChance(Answer ans, Quiz quiz){
        if(!ans.isCorrect()){
           // quiz.doubleChance(); TODO
        }
    }
}
