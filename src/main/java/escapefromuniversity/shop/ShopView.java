package escapefromuniversity.shop;

import javax.swing.*;

/**
 * The interface of the shop's view.
 */
public interface ShopView {

    /**
     * Returns the button to buy health reset buff.
     * @return the button to buy health reset buff.
     */
    JButton getBuyLife();

    /**
     * Returns the button to buy armor buff.
     * @return the button to buy armor buff.
     */
    JButton getBuyArmor();

    /**
     * Returns the button to buy damage buff.
     * @return the button to buy damage buff.
     */
    JButton getBuyDamage();

    /**
     * Returns the button to buy the second chance.
     * @return the button to buy the second chance.
     */
    JButton getBuyChance();

    void setCreditsCounter();

    /**
     * Sets a button to not be clickable.
     * @param button the button to set inactive.
     */
    void setButtonNotClickable(JButton button);

    /**
     * Closes the shop.
     */
    void close();
    
    void startView();
}
