package escapefromuniversity.model.shop;

import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.quiz.Competition;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static escapefromuniversity.model.shop.ShopViewImpl.*;

public class ShopControllerImpl implements ShopController, MouseListener {

    private final ShopView shopView;
    private Items itemType;
    private Player player; // TODO initialize
    private Competition competition; // TODO same
    private static final int resetHealthCost = 6;
    private static final int increaseArmorCost = 12;
    private static final int increaseDamageCost = 12;
    private static final int doubleChanceCost = 18;

    public ShopControllerImpl() {
        this.shopView = new ShopViewImpl(this);
        this.initializeButtons();
        this.checkButtonsAvailability();
    }

    private void initializeButtons() {
        this.shopView.getExit().addMouseListener(this);
        this.shopView.getBuyLife().addMouseListener(this);
        this.shopView.getBuyArmor().addMouseListener(this);
        this.shopView.getBuyDamage().addMouseListener(this);
        this.shopView.getBuyDamage().addMouseListener(this);
    }

    @Override
    public void closeShop() {
        // TODO set gamestate SHOP
    }

    @Override
    public void buyItem() {
        switch(this.getItemType()) {
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
                this.itemType.doubleChance(this.competition);
                this.player.setCredits(this.player.getCredits() - doubleChanceCost);
                break;
            default: {
            }
        }
        this.checkButtonsAvailability();
    }

    @Override
    public void setItemType(final Items itemType) {
        this.itemType = itemType;
    }

    @Override
    public Items getItemType() {
        return this.itemType;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (this.shopView.getExit().equals(source)) {
            this.closeShop();
        } else if (this.shopView.getBuyLife().equals(source)) {
            this.setItemType(Items.RESET_HEALTH);
        } else if (this.shopView.getBuyArmor().equals(source)) {
            this.setItemType(Items.INCREASE_ARMOR);
        } else if (this.shopView.getBuyDamage().equals(source)) {
            this.setItemType(Items.INCREASE_DAMAGE);
        } else if (this.shopView.getBuyChance().equals(source)) {
            this.setItemType(Items.DOUBLE_CHANCE);
        }
        this.buyItem();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

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

    @Override
    public void mouseExited(MouseEvent e) {
        this.shopView.setItemInfo("");
    }

    @Override
    public void checkButtonsAvailability() {
        if(!this.itemType.increaseDamage(this.player)) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyDamage());
        }
        if(!this.itemType.increaseArmor(this.player)) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyArmor());
        }
        if(!this.itemType.resetHealth(this.player)) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyLife());
        }
        if(!this.competition.isBonusAvailable()) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyChance());
        }
    }
}
