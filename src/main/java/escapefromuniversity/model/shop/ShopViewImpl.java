package escapefromuniversity.model.shop;

import escapefromuniversity.utilities.WindowSet;
import escapefromuniversity.utilities.OSFixes;

import javax.swing.*;
import java.awt.*;

public class ShopViewImpl extends JPanel implements ShopView {

    private final ShopController shopController;
    private final double windowRatio = WindowSet.getWindowRatio();
    private final JLabel creditsCounter = new JLabel("Credits", (Icon) this.creditsIcon, SwingConstants.CENTER);
    private JTextArea itemInfo = new JTextArea("");
    private final JButton buyLife = new JButton("", this.creditsIcon);
    private final JButton buyArmor = new JButton("", this.creditsIcon);
    private final JButton buyDamage = new JButton("", this.creditsIcon);
    private final JButton buyChance = new JButton("", this.creditsIcon);
    private final JButton exit = new JButton("", this.creditsIcon);
    private final ImageIcon creditsIcon = new ImageIcon(OSFixes.getLocation("hud", "credits.png"));
    private final ImageIcon lifeIcon = new ImageIcon(OSFixes.getLocation("hud", "life.png"));
    private final ImageIcon armorIcon = new ImageIcon(OSFixes.getLocation("hud", "armor.png"));
    private final ImageIcon damageIcon = new ImageIcon(OSFixes.getLocation("hud", "damage.png"));
    private final ImageIcon chanceIcon = new ImageIcon(OSFixes.getLocation("hud", "second_chance.png"));
    private final Rectangle creditsCounterPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle itemInfoPos = new Rectangle((int) (10 * windowRatio), (int) (10 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyLifePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyArmorPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyDamagePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyChancePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle exitPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
//    TODO private final Rectangle iconspos
    public static final String buyLifeInfo = "Restores your HP to max.";
    public static final String buyArmorInfo = "Increases your armor.";
    public static final String buyDamageInfo = "Increases your damage.";
    public static final String buyChanceInfo = "Gives you a second chance when attending an exam quiz.";

    public ShopViewImpl(final ShopController shopController) {
        this.shopController = shopController;
        this.setFont(WindowSet.FONT);
        this.initializeShop();
    }

    private void initializeShop() {
        this.creditsCounter.setBounds(this.creditsCounterPos);
        this.itemInfo.setBounds(this.itemInfoPos);
        this.buyLife.setBounds(this.buyLifePos);
        this.buyArmor.setBounds(this.buyArmorPos);
        this.buyDamage.setBounds(this.buyDamagePos);
        this.buyChance.setBounds(this.buyChancePos);
        this.exit.setBounds(this.exitPos);
//      TODO altri settings
        this.add(this.creditsCounter);
        this.add(this.itemInfo);
        this.add(this.buyLife);
        this.add(this.buyArmor);
        this.add(this.buyDamage);
        this.add(this.buyChance);
        this.add(this.exit);
        this.setVisible(true);
    }

    @Override
    public JButton getBuyLife() {
        return this.buyLife;
    }

    @Override
    public JButton getBuyArmor() {
        return this.buyArmor;
    }

    @Override
    public JButton getBuyDamage() {
        return this.buyDamage;
    }

    @Override
    public JButton getBuyChance() {
        return this.buyChance;
    }

    @Override
    public JButton getExit() {
        return this.exit;
    }

    @Override
    public void setItemInfo(final String itemInfo) {
        this.itemInfo.setText(itemInfo);
    }

    @Override
    public void setButtonNotClickable(final JButton button) {
        button.setOpaque(true);
        button.setEnabled(false);
    }

    @Override
    public void close() {
        this.setVisible(false);
    }

}
