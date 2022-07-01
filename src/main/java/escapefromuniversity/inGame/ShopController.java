package escapefromuniversity.inGame;

import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.shop.Items;

import java.awt.event.ActionEvent;

/**
 * The interface of the controller of the in game shop.
 */
public interface ShopController {

    /**
     * Starts the view of the shop.
     */
    void startView();

    /**
     * Closes the shop.
     */
    void closeShop();

    void buyItem(ActionEvent e);

    Player getPlayer();
}
