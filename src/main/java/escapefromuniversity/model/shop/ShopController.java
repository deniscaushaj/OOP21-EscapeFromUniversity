package escapefromuniversity.model.shop;

public interface ShopController {

    void closeShop();

    void buyItem();

    void setItemType(Items itemType);

    Items getItemType();

}
