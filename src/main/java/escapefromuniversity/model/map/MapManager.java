package escapefromuniversity.model.map;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.player.Player;

/**
 * A class which manage the map.
 */
public interface MapManager {

    /**
     * Updates the map.
     * @param deltaTime specifies the time distance between the updates.
     */
    void update(double deltaTime);

    GameInit getGameInit();

    Player getPlayer();

    void setupQuiz(Boss boss);

    void setupShop();

    void remuveID(int id);

}
