package escapefromuniversity.model.shop;

import escapefromuniversity.utilities.WindowSet;
import escapefromuniversity.utilities.OSFixes;

import javax.swing.*;
import java.awt.*;

public class ShopViewImpl extends JPanel implements ShopView {

    private final ShopController shopController;

    private Items itemType;
    private final double windowRatio = WindowSet.getWindowRatio();
    private final JLabel creditsCounter = new JLabel("Credits", (Icon) this.creditsIcon, SwingConstants.CENTER);
    private JTextArea itemInfo;
    private JButton buyLife, buyArmor, buyDamage, buyChance, exit;
    private final ImageIcon creditsIcon = new ImageIcon(OSFixes.getLocation("hud", "credits.png"));
    private final ImageIcon lifeIcon = new ImageIcon(OSFixes.getLocation("hud", "life.png"));
    private final ImageIcon armorIcon = new ImageIcon(OSFixes.getLocation("hud", "armor.png"));
    private final ImageIcon damageIcon = new ImageIcon(OSFixes.getLocation("hud", "damage.png"));
    private final ImageIcon chanceIcon = new ImageIcon(OSFixes.getLocation("hud", "second_chance.png"));
    private final Rectangle creditsCounterPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle itemInfoPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyLifePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyArmorPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyDamagePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyChancePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle exitPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));

    public ShopViewImpl(final ShopController shopController) { // TODO chiamare con WindowSet.getWindowRatio()t
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

        this.buyLife.addActionListener(e -> {
            this.shopController.buyItem();
            this.setItemType(Items.RESET_HEALTH);
        });
        this.exit.addActionListener(e -> this.shopController.closeShop());


        this.add(this.creditsCounter);
        this.add(this.itemInfo);
        this.add(this.buyLife);
        this.add(this.buyArmor);
        this.add(this.buyDamage);
        this.add(this.buyChance);
        this.add(this.exit);
        this.setVisible(true);
    }

    // TODO non vanno qua:
    @Override
    public void setItemType(Items itemType) {
        this.itemType = itemType;
    }

    @Override
    public Items getItemType() {
        return this.itemType;
    }

}
