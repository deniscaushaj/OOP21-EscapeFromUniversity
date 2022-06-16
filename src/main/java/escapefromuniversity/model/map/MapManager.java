package escapefromuniversity.model.map;

import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.player.Player;

public interface MapManager {

    void update(double deltaTime);

    Room getRoom();

    Player getPlayer();

    void goQuiz(GameObjectType type);

    void setCurrentRoom(Door door);

    void goShop();

}
