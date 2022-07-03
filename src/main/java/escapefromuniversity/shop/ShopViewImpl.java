package escapefromuniversity.shop;

import escapefromuniversity.utilities.WindowSet;
import escapefromuniversity.utilities.OSFixes;

import javax.swing.*;
import java.awt.*;

import static escapefromuniversity.utilities.LauncherResizer.SCREENHEIGHT;
import static escapefromuniversity.utilities.LauncherResizer.SCREENWIDTH;
import static escapefromuniversity.utilities.WindowSet.FONT;

/**
 * The implementation of {@link ShopView} that extends also {@link JPanel} to add all the shop components to the screen.
 */
public class ShopViewImpl implements ShopView {

    private final ShopController shopController;
    private final double windowRatio = WindowSet.getWindowRatio();
    private final JFrame window = new JFrame();
    private JPanel shopPanel;
    private final ImageIcon buttonBackground = new ImageIcon(getClass().getResource("/images/back.png"));
    private final ImageIcon creditsIcon = new ImageIcon(getClass().getResource("/hud/credits.png"));
    private final ImageIcon lifeIcon = new ImageIcon(getClass().getResource("/hud/life.png"));
    private final ImageIcon armorIcon = new ImageIcon(getClass().getResource("/hud/armor.png"));
    private final ImageIcon damageIcon = new ImageIcon(getClass().getResource("/hud/damage.png"));
    private final ImageIcon chanceIcon = new ImageIcon(getClass().getResource("/hud/second_chance.png"));
    private final JLabel itemInfo = new JLabel("", this.creditsIcon, SwingConstants.CENTER);
    private final JButton buyLife = new JButton(buyButton, buttonBackground);
    private final JButton buyArmor = new JButton(buyButton, buttonBackground);
    private final JButton buyDamage = new JButton(buyButton, buttonBackground);
    private final JButton buyChance = new JButton(buyButton, buttonBackground);
    private final JButton exit = new JButton("Exit", buttonBackground);
    private final JLabel creditsCounter = new JLabel();
    private final JLabel lifeLabel = new JLabel("6 Credits", this.lifeIcon, SwingConstants.CENTER);
    private final JLabel armorLabel = new JLabel("12 Credits", this.armorIcon, SwingConstants.CENTER);
    private final JLabel damageLabel = new JLabel("12 Credits", this.damageIcon, SwingConstants.CENTER);
    private final JLabel chanceLabel = new JLabel("18 Credits", this.chanceIcon, SwingConstants.CENTER);
    private final Rectangle creditsCounterPos = new Rectangle((int) (20 * windowRatio), (int) (5 * windowRatio), (int) (150 * windowRatio), (int) ((creditsIcon.getIconHeight() + 20) * windowRatio));
    private final Rectangle itemInfoPos = new Rectangle((int) (40 * windowRatio), (int) ((SCREENHEIGHT + 20) * windowRatio), (int) (300 * windowRatio), (int) (200 * windowRatio));
    private final Rectangle buyLifePos = new Rectangle((int) (SCREENWIDTH / 2.5 * windowRatio), (int) (250 * windowRatio), (buttonBackground.getIconWidth()), (buttonBackground.getIconHeight()));
    private final Rectangle buyArmorPos = new Rectangle((int) (SCREENWIDTH / 2.5 * windowRatio), (int) (350 * windowRatio), (buttonBackground.getIconWidth()), (buttonBackground.getIconHeight()));
    private final Rectangle buyDamagePos = new Rectangle((int) (SCREENWIDTH / 2.5 * windowRatio), (int) (450 * windowRatio), (buttonBackground.getIconWidth()), (buttonBackground.getIconHeight()));
    private final Rectangle buyChancePos = new Rectangle((int) (SCREENWIDTH / 2.5 * windowRatio), (int) (550 * windowRatio), (buttonBackground.getIconWidth()), (buttonBackground.getIconHeight()));
    private final Rectangle exitPos = new Rectangle((int) ((SCREENWIDTH - buttonBackground.getIconWidth() - 40) * windowRatio), (int) ((SCREENHEIGHT - buttonBackground.getIconHeight() - 20) * windowRatio), (buttonBackground.getIconWidth()), (buttonBackground.getIconHeight()));
    private final Rectangle lifeLabelPos = new Rectangle((int) (SCREENWIDTH / 2.5 * windowRatio), (int) (200 * windowRatio), (lifeIcon.getIconWidth() + 150), (lifeIcon.getIconHeight() + 20));
    private final Rectangle armorLabelPos = new Rectangle((int) (SCREENWIDTH / 2.5 * windowRatio), (int) (300 * windowRatio), (armorIcon.getIconWidth() + 150), (armorIcon.getIconHeight() + 20));
    private final Rectangle damageLabelPos = new Rectangle((int) (SCREENWIDTH / 2.5 * windowRatio), (int) (400 * windowRatio), (damageIcon.getIconWidth() + 150), (damageIcon.getIconHeight() + 20));
    private final Rectangle chanceLabelPos = new Rectangle((int) (SCREENWIDTH / 2.5 * windowRatio), (int) (500 * windowRatio), (chanceIcon.getIconWidth() + 150), (chanceIcon.getIconHeight() + 20));
    private final Color color = new Color(255, 241, 179);
    public static final String buyButton = "Buy";
    public static final String buyLifeInfo = "Restores your HP to max.";
    public static final String buyArmorInfo = "Increases your armor.";
    public static final String buyDamageInfo = "Increases your damage.";
    public static final String buyChanceInfo = "Gives you one more chance to answer a new question when attending an exam quiz.";

    /**
     * Instantiates the view of the shop and initializes its window.
     * @param shopController the shop controller to assign to this shop view.
     */
    public ShopViewImpl(final ShopController shopController) {
        this.shopController = shopController;
        this.creditsCounter.setBounds(this.creditsCounterPos);
        this.creditsCounter.setFont(FONT);
        this.itemInfo.setBounds(this.itemInfoPos);
        this.itemInfo.setFont(FONT);
        this.buyLife.setBounds(this.buyLifePos);
        this.buyLife.setFont(FONT);
        this.buyLife.setHorizontalTextPosition(SwingConstants.CENTER);
        this.buyLife.addActionListener(this.shopController::buyItem);
        this.lifeLabel.setBounds(this.lifeLabelPos);
        this.lifeLabel.setFont(FONT);
        this.buyArmor.setBounds(this.buyArmorPos);
        this.buyArmor.setFont(FONT);
        this.buyArmor.setHorizontalTextPosition(SwingConstants.CENTER);
        this.buyArmor.addActionListener(this.shopController::buyItem);
        this.armorLabel.setBounds(this.armorLabelPos);
        this.armorLabel.setFont(FONT);
        this.buyDamage.setBounds(this.buyDamagePos);
        this.buyDamage.setFont(FONT);
        this.buyDamage.setHorizontalTextPosition(SwingConstants.CENTER);
        this.buyDamage.addActionListener(this.shopController::buyItem);
        this.damageLabel.setBounds(this.damageLabelPos);
        this.damageLabel.setFont(FONT);
        this.buyChance.setBounds(this.buyChancePos);
        this.buyChance.setFont(FONT);
        this.buyChance.setHorizontalTextPosition(SwingConstants.CENTER);
        this.buyChance.addActionListener(this.shopController::buyItem);
        this.chanceLabel.setBounds(this.chanceLabelPos);
        this.chanceLabel.setFont(FONT);
        this.exit.setBounds(this.exitPos);
        this.exit.setFont(FONT);
        this.exit.setHorizontalTextPosition(SwingConstants.CENTER);
        this.exit.addActionListener(e -> this.shopController.closeShop());
        this.itemInfo.setText("HP Restore:" + buyLifeInfo + "\n" + "Armor Buff:" + buyArmorInfo + "\n" + "Damage Buff:" + buyDamageInfo + "\n" + "Second Chance:" + buyChanceInfo);
        this.setCreditsCounter();
        this.window.setTitle("Escape From University");
        this.window.setSize((int) (SCREENWIDTH * this.windowRatio), (int) (SCREENHEIGHT * this.windowRatio));
        this.window.setResizable(false);
        this.window.setUndecorated(true);
        this.window.setLocationRelativeTo(null);
        this.shopPanel = new JPanel();
        this.shopPanel.setOpaque(false);
        this.window.getContentPane().add(this.shopPanel);
        this.window.setBackground(this.color);
    }

    @Override
    public void startView() {
        this.window.setVisible(true);
        this.initializeShop();
    }

    /* Adds all the components to the panel. */
    private void initializeShop() {
        this.shopPanel.setBackground(this.color);
        this.shopPanel.add(this.creditsCounter);
        this.shopPanel.add(this.itemInfo);
        this.shopPanel.add(this.buyLife);
        this.shopPanel.add(this.buyArmor);
        this.shopPanel.add(this.buyDamage);
        this.shopPanel.add(this.buyChance);
        this.shopPanel.add(this.exit);
        this.shopPanel.add(this.lifeLabel);
        this.shopPanel.add(this.armorLabel);
        this.shopPanel.add(this.damageLabel);
        this.shopPanel.add(this.chanceLabel);
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

    @Override
    public void setCreditsCounter() {
        this.creditsCounter.setText(this.shopController.getPlayer().getCredits() + "Credits");
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
        this.window.setVisible(false);
    }

}
