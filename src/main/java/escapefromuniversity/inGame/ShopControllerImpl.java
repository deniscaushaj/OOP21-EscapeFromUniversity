package escapefromuniversity.inGame;

import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.shop.Items;

import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

/**
 * The implementation of {@link ShopController} interface that implements also {@link MouseListener} to add a listener to the buttons.
 */
public class ShopControllerImpl implements ShopController {

    private final ShopView shopView;
    private final GameController gameController;
    private final Items items;
    private final Player player;
    private boolean isActive;
    private static final int resetHealthCost = 6;
    private static final int increaseArmorCost = 12;
    private static final int increaseDamageCost = 12;
    private static final int doubleChanceCost = 18;

    /**
     * Instantiates the controller of the shop and initializes its buttons.
     * @param gameController the game controller to link to the shop controller.
     * @param gameModel      the game model.
     */
    public ShopControllerImpl(GameController gameController, GameModel gameModel) {
        this.gameController = gameController;
        this.player = gameModel.getPlayer();
        this.isActive = false;
        this.shopView = new ShopViewImpl(this);
        this.items = new Items();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startView() {
        if(!this.isActive) {
            this.isActive = true;
            this.shopView.startView();
            this.checkButtonsAvailability();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void closeShop() {
        this.gameController.setGameState(this.gameController.getPrevGameState());
        this.shopView.close();
        this.isActive = false;
    }

    @Override
    public void buyItem(ActionEvent e) {
        var source = e.getSource();
        if (this.shopView.getBuyLife().equals(source)) {
            this.items.resetHealth(this.player);
            this.player.decreaseCredits(resetHealthCost);
        } else if (this.shopView.getBuyArmor().equals(source)) {
            this.items.increaseArmor(this.player);
            this.player.decreaseCredits(increaseArmorCost);
        } else if (this.shopView.getBuyDamage().equals(source)) {
            this.items.increaseDamage(this.player);
            this.player.decreaseCredits(increaseDamageCost);
        } else if (this.shopView.getBuyChance().equals(source)) {
            this.items.doubleChance(this.player);
            this.player.decreaseCredits(doubleChanceCost);
        }
        this.checkButtonsAvailability();
        this.shopView.setCreditsCounter();
    }

    /* Checks if the items can be bought and sets them not clickable in case they cannot. */
    private void checkButtonsAvailability() {
        if(!this.items.increaseDamage(this.player) || this.player.getCredits() < increaseDamageCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyDamage());
        }
        if(!this.items.increaseArmor(this.player) || this.player.getCredits() < increaseArmorCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyArmor());
        }
        if(!this.items.resetHealth(this.player) || this.player.getCredits() < resetHealthCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyLife());
        }
        if(this.player.hasBonusQuiz() || this.player.getCredits() < doubleChanceCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyChance());
        }
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }
}
