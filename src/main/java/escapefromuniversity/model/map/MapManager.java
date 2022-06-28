package escapefromuniversity.model.map;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.player.Player;

public interface MapManager {

    void update(double deltaTime);

    GameInit getMap();

    Player getPlayer();

    void setupQuiz(Boss boss);

    void setCurrentRoom(Door door);

    void setupShop();

}
