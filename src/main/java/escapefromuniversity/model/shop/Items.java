package escapefromuniversity.model.shop;

import escapefromuniversity.model.bullet.Bullet;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.quiz.Anwser;
import escapefromuniversity.model.quiz.Quiz;

public enum Items {

    INCREASE_ATTACK, INCREASE_DEFENSE, RESET_HEALTH, DOUBLE_CHANCE;

    public void increaseAttack(GameObject gameObject, Bullet bullet){
        if(gameObject.getType() == GameObjectType.PLAYER){
            bullet.setDamage(bullet.getDamage() * 150 / 100);
        }
    }

    public void increaseDefense(GameObject gameObject, Bullet bullet){
        if(gameObject.getType() == GameObjectType.BOSS1 || gameObject.getType() == GameObjectType.BOSS2 ||
                gameObject.getType() == GameObjectType.BOSS3 || gameObject.getType() == GameObjectType.BOSS4 ||
                gameObject.getType() == GameObjectType.BOSS5 || gameObject.getType() == GameObjectType.BOSS6){
            bullet.setDamage(bullet.getDamage() * 50 / 100);
        }
    }

    public void resetHealth(Player player){
        if(player.getLife() != player.getMaxLife()){
            player.setLife(player.getMaxLife());
        }
    }

    public void doubleChance(Anwser ans, Quiz quiz){
        if(!ans.isCorrect()){
            quiz.doubleChance();
        }
    }
}
