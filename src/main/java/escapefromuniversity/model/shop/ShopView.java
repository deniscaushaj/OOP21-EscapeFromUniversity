package escapefromuniversity.model.shop;

import javax.swing.*;

public interface ShopView {

    JButton getBuyLife();

    JButton getBuyArmor();

    JButton getBuyDamage();

    JButton getBuyChance();

    JButton getExit();

    void setItemInfo(String itemInfo);

    void setButtonNotClickable(JButton button);

    void close();
}
