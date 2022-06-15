package escapefromuniversity.model.map;

import escapefromuniversity.model.player.Player;

public interface MapManager {

    void update(double deltaTime);

    Room getRoom();

    Player getPlayer();

    void goQuiz();

    void setCurrentRoom(Door door);

    void goShop();

}
