package escapefromuniversity.model.shop;

import java.util.Collections;
import java.util.Map;

public class ItemImpl implements Item{

    private Map<Items, Integer> items;

    @Override
    public Map<Items, Integer> getAllItems() {
        return Collections.unmodifiableMap(items);
    }

    private void setItemsPrice(){
        items.put(Items.INCREASE_ATTACK, 12);
        items.put(Items.INCREASE_DEFENSE, 12);
        items.put(Items.RESET_HEALTH, 6);
        items.put(Items.DOUBLE_CHANCE, 18);
    }
}
