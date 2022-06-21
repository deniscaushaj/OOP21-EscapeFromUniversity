package escapefromuniversity.model.shop;

import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.quiz.Competition;

public class ShopControllerImpl implements ShopController {

    ShopView shopView; // TODO initialize
    Items items; // TODO same
    Player player; // TODO same
    Competition competition; // TODO same

    public ShopControllerImpl() {
    }

    @Override
    public void closeShop() {

    };

    @Override
    public void buyItem() {
        switch(this.shopView.getItemType()) {
            case RESET_HEALTH:
                this.items.resetHealth(this.player);
                break;
            case INCREASE_DEFENSE:
                this.items.increaseDefense(this.player);
                break;
            case INCREASE_ATTACK:
                this.items.increaseAttack(this.player);
                break;
            case DOUBLE_CHANCE:
                this.items.doubleChance(this.competition);
                break;
            default: {
            }
        }
    }

}
