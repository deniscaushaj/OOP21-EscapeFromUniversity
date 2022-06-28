package escapefromuniversity.inGame;

import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.shop.Items;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static escapefromuniversity.inGame.ShopViewImpl.*;

/**
 * The implementation of {@link ShopController} interface that implements also {@link MouseListener} to add a listener to the buttons.
 */
public class ShopControllerImpl implements ShopController, MouseListener {

    private ShopView shopView;
    private final GameController gameController;
    private Items itemType;
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
        this.initializeButtons();
        this.checkButtonsAvailability();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startView() {
        if(!this.isActive) {
            this.shopView = new ShopViewImpl(this);
            this.isActive = true;
        }
    }

    /* Initializes the shop screen buttons with their mouse listeners. */
    private void initializeButtons() {
        this.shopView.getExit().addMouseListener(this);
        this.shopView.getBuyLife().addMouseListener(this);
        this.shopView.getBuyArmor().addMouseListener(this);
        this.shopView.getBuyDamage().addMouseListener(this);
        this.shopView.getBuyDamage().addMouseListener(this);
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

    /* Buys an item. */
    private void buyItem() {
        switch(this.itemType) {
            case RESET_HEALTH:
                this.itemType.resetHealth(this.player);
                this.player.setCredits(this.player.getCredits() - resetHealthCost);
                break;
            case INCREASE_ARMOR:
                this.itemType.increaseArmor(this.player);
                this.player.setCredits(this.player.getCredits() - increaseArmorCost);
                break;
            case INCREASE_DAMAGE:
                this.itemType.increaseDamage(this.player);
                this.player.setCredits(this.player.getCredits() - increaseDamageCost);
                break;
            case DOUBLE_CHANCE:
                this.itemType.doubleChance(this.player);
                this.player.setCredits(this.player.getCredits() - doubleChanceCost);
                break;
            default: {
            }
        }
        this.checkButtonsAvailability();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (this.shopView.getExit().equals(source)) {
            this.closeShop();
        } else if (this.shopView.getBuyLife().equals(source)) {
            this.itemType = Items.RESET_HEALTH;
        } else if (this.shopView.getBuyArmor().equals(source)) {
            this.itemType = Items.INCREASE_ARMOR;
        } else if (this.shopView.getBuyDamage().equals(source)) {
            this.itemType = Items.INCREASE_DAMAGE;
        } else if (this.shopView.getBuyChance().equals(source)) {
            this.itemType = Items.DOUBLE_CHANCE;
        }
        this.buyItem();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mousePressed(MouseEvent e) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(MouseEvent e) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (this.shopView.getBuyLife().equals(source)) {
            this.shopView.setItemInfo(buyLifeInfo);
        } else if (this.shopView.getBuyArmor().equals(source)) {
            this.shopView.setItemInfo(buyArmorInfo);
        } else if (this.shopView.getBuyDamage().equals(source)) {
            this.shopView.setItemInfo(buyDamageInfo);
        } else if (this.shopView.getBuyChance().equals(source)) {
            this.shopView.setItemInfo(buyChanceInfo);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.shopView.setItemInfo("");
    }

    /* Checks if the items can be bought and sets them not clickable in case they cannot. */
    private void checkButtonsAvailability() {
        if(!this.itemType.increaseDamage(this.player) && this.player.getCredits() < increaseDamageCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyDamage());
        }
        if(!this.itemType.increaseArmor(this.player) && this.player.getCredits() < increaseArmorCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyArmor());
        }
        if(!this.itemType.resetHealth(this.player) && this.player.getCredits() < resetHealthCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyLife());
        }
        if(this.player.hasBonusQuiz() && this.player.getCredits() < doubleChanceCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyChance());
        }
    }
}
