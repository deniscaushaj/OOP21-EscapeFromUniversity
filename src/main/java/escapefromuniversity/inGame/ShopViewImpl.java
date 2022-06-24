package escapefromuniversity.inGame;

import escapefromuniversity.utilities.WindowSet;
import escapefromuniversity.utilities.OSFixes;

import javax.swing.*;
import java.awt.*;

/**
 * The implementation of {@link ShopView} that extends also {@link JPanel} to add all the shop components to the screen.
 */
public class ShopViewImpl extends JPanel implements ShopView {

    private final ShopController shopController;
    private final double windowRatio = WindowSet.getWindowRatio();
    private final ImageIcon buttonBackground = new ImageIcon(OSFixes.getLocation("images", "back.png"));
    private final ImageIcon creditsIcon = new ImageIcon(OSFixes.getLocation("hud", "credits.png"));
    private final ImageIcon lifeIcon = new ImageIcon(OSFixes.getLocation("hud", "life.png"));
    private final ImageIcon armorIcon = new ImageIcon(OSFixes.getLocation("hud", "armor.png"));
    private final ImageIcon damageIcon = new ImageIcon(OSFixes.getLocation("hud", "damage.png"));
    private final ImageIcon chanceIcon = new ImageIcon(OSFixes.getLocation("hud", "second_chance.png"));
    private JTextArea itemInfo = new JTextArea("");
    private final JButton buyLife = new JButton(buyButton, buttonBackground);
    private final JButton buyArmor = new JButton(buyButton, buttonBackground);
    private final JButton buyDamage = new JButton(buyButton, buttonBackground);
    private final JButton buyChance = new JButton(buyButton, buttonBackground);
    private final JButton exit = new JButton("Exit");
    private final JLabel creditsCounter = new JLabel("Credits", (Icon) this.creditsIcon, SwingConstants.CENTER);
    private final JLabel lifeLabel = new JLabel("6", this.lifeIcon, SwingConstants.CENTER);
    private final JLabel armorLabel = new JLabel("12", this.armorIcon, SwingConstants.CENTER);
    private final JLabel damageLabel = new JLabel("12", this.damageIcon, SwingConstants.CENTER);
    private final JLabel chanceLabel = new JLabel("18", this.chanceIcon, SwingConstants.CENTER);
    private final Rectangle creditsCounterPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle itemInfoPos = new Rectangle((int) (10 * windowRatio), (int) (10 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyLifePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyArmorPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyDamagePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle buyChancePos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle exitPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle lifeLabelPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle armorLabelPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle damageLabelPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    private final Rectangle chanceLabelPos = new Rectangle((int) (60 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio), (int) (50 * windowRatio));
    public static final String buyButton = "Buy";
    public static final String buyLifeInfo = "Restores your HP to max.";
    public static final String buyArmorInfo = "Increases your armor.";
    public static final String buyDamageInfo = "Increases your damage.";
    public static final String buyChanceInfo = "Gives you a second chance when attending an exam quiz.";

    /**
     * Instantiates the view of the shop and initializes its window.
     * @param shopController the shop controller to assign to this shop view.
     */
    public ShopViewImpl(final ShopController shopController) {
        this.shopController = shopController;
        this.setFont(WindowSet.FONT);
        this.initializeShop();
    }

    /* Initializes and sets up all the shop screen components. */
    private void initializeShop() {
        this.creditsCounter.setBounds(this.creditsCounterPos);
        this.itemInfo.setBounds(this.itemInfoPos);
        this.buyLife.setBounds(this.buyLifePos);
        this.buyArmor.setBounds(this.buyArmorPos);
        this.buyDamage.setBounds(this.buyDamagePos);
        this.buyChance.setBounds(this.buyChancePos);
        this.exit.setBounds(this.exitPos);
        this.lifeLabel.setBounds(this.lifeLabelPos);
        this.armorLabel.setBounds(this.armorLabelPos);
        this.damageLabel.setBounds(this.damageLabelPos);
        this.chanceLabel.setBounds(this.chanceLabelPos);


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

    /**
     * {@inheritDoc}
     */
    @Override
    public JButton getBuyLife() {
        return this.buyLife;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JButton getBuyArmor() {
        return this.buyArmor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JButton getBuyDamage() {
        return this.buyDamage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JButton getBuyChance() {
        return this.buyChance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JButton getExit() {
        return this.exit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setItemInfo(final String itemInfo) {
        this.itemInfo.setText(itemInfo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setButtonNotClickable(final JButton button) {
        button.setOpaque(true);
        button.setEnabled(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
        this.setVisible(false);
    }

}
