package escapefromuniversity.model.shop;

public interface ShopController {

    void startView();

    void closeShop();

    void buyItem();

    void setItemType(Items itemType);

    Items getItemType();

    void checkButtonsAvailability();
}
