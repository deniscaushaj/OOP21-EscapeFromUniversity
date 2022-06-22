package escapefromuniversity.model.shop;

import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.quiz.Competition;

public class ShopControllerImpl implements ShopController {

    private final ShopView shopView;
    private Items itemType;
    private Player player; // TODO initialize
    private Competition competition; // TODO same

    public ShopControllerImpl() {
        this.shopView = new ShopViewImpl(this);
    }

    @Override
    public void closeShop() {

    }

    @Override
    public void buyItem() {
        switch(this.getItemType()) {
            case RESET_HEALTH:
                this.itemType.resetHealth(this.player);
                break;
            case INCREASE_ARMOR:
                this.itemType.increaseArmor(this.player);
                break;
            case INCREASE_DAMAGE:
                this.itemType.increaseDamage(this.player);
                break;
            case DOUBLE_CHANCE:
                this.itemType.doubleChance(this.competition);
                break;
            default: {
            }
        }
    }

    @Override
    public void setItemType(Items itemType) {
        this.itemType = itemType;
    }

    @Override
    public Items getItemType() {
        return this.itemType;
    }

}
