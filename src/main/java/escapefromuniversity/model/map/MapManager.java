package escapefromuniversity.model.map;

import escapefromuniversity.model.enemy.Boss;
import escapefromuniversity.model.player.Player;

public interface MapManager {

    void update(double deltaTime);

    Room getRoom();

    Player getPlayer();

    void goQuiz(Boss boss);

    void setCurrentRoom(Door door);

    void goShop();

}
