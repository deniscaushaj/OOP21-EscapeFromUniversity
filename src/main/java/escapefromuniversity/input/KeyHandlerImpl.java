package escapefromuniversity.input;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import escapefromuniversity.inGame.*;
import escapefromuniversity.menu.MenuController;
import escapefromuniversity.menu.MenuControllerImpl;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.gameObject.Direction;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.gameObject.player.PlayerMovement;
import escapefromuniversity.model.gameObject.player.PlayerMovementImpl;

/**
 * The implementation of {@link KeyHandler}. Contains all the methods to check the keys pressed and execute commands.
 */
public class KeyHandlerImpl implements KeyHandler {

    private final GameController gameController;
    private final GameView gameView;
    private final Player player;
    private final PlayerMovement playerMovement;
    private final ShopController shopController;
    private final MenuController menuController;
    private final GameKeyListener gameKeyListener;
    private Optional<Command<Integer, Boolean, Optional<Direction>>> command;
    private final List<Command<Integer, Boolean, Optional<Direction>>> keyList = new ArrayList<>();

    /**
     * Instantiates the key handler.
     * @param gameModel
     * @param gameController
     */
    public KeyHandlerImpl(final GameModel gameModel, final GameController gameController) {
        this.gameController = gameController;
        this.gameView = new GameViewImpl(this.gameController);
        this.player = gameModel.getPlayer();
        this.playerMovement = new PlayerMovementImpl(this.player);
        this.shopController = new ShopControllerImpl(this.gameController);
        this.menuController = new MenuControllerImpl(this.gameController);
        this.gameKeyListener = new GameKeyListener(this.gameController);
        this.createKeyList();
    }

    /* Creates a list with all the possible keyboard buttons that can be detected and used inside the game. */
    private void createKeyList() {
        this.keyList.add(new Command<>(KeyEvent.VK_W, false, Optional.of(Direction.UP)));
        this.keyList.add(new Command<>(KeyEvent.VK_A, false, Optional.of(Direction.LEFT)));
        this.keyList.add(new Command<>(KeyEvent.VK_S, false, Optional.of(Direction.DOWN)));
        this.keyList.add(new Command<>(KeyEvent.VK_D, false, Optional.of(Direction.RIGHT)));
        this.keyList.add(new Command<>(KeyEvent.VK_UP, false, Optional.of(Direction.UP)));
        this.keyList.add(new Command<>(KeyEvent.VK_LEFT, false, Optional.of(Direction.LEFT)));
        this.keyList.add(new Command<>(KeyEvent.VK_DOWN, false, Optional.of(Direction.DOWN)));
        this.keyList.add(new Command<>(KeyEvent.VK_RIGHT, false, Optional.of(Direction.RIGHT)));
        this.keyList.add(new Command<>(KeyEvent.VK_SPACE, false, Optional.empty()));
        this.keyList.add(new Command<>(KeyEvent.VK_ENTER, false, Optional.empty()));
        this.keyList.add(new Command<>(KeyEvent.VK_ESCAPE, false, Optional.empty()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Command<Integer, Boolean, Optional<Direction>>> getKeyList() {
        return this.keyList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeCommand() {
        this.keyList.forEach(key -> {
            int keyCode;
            if (key.getClicked()) {
                keyCode = key.getKey();
                this.command = findKey(keyCode);
                if (this.command.isEmpty()) {
                    switch (this.gameController.getGameState()) {
                        case FIGHT:
                            this.fightCommands(keyCode);
                            this.playCommands(keyCode);
                            break;
                        case MENU:
                        case SHOP_MENU:
                            this.menuCommands(keyCode);
                            break;
                        case PLAY:
                        case GRADUATED:
                        case SHOP_ROOM:
                            this.playCommands(keyCode);
                            break;
                        default: {
                        }
                    }
                }
            }
        });
        if (this.checkVerticalKeys()) {
            this.playerMovement.stopVertical();
        }
        if (this.checkHorizontalKeys()) {
            this.playerMovement.stopHorizontal();
        }
    }

    /* Handles all the possible keyboard commands while playing. */
    private void playCommands(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE) {
            this.gameKeyListener.openMenu();
        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            this.playerMovement.move(Direction.LEFT);
            this.player.setLastDirection(Direction.LEFT);
        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            this.playerMovement.move(Direction.DOWN);
            this.player.setLastDirection(Direction.DOWN);
        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            this.playerMovement.move(Direction.RIGHT);
            this.player.setLastDirection(Direction.RIGHT);
        } else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            this.playerMovement.move(Direction.UP);
            this.player.setLastDirection(Direction.UP);
        }
    }

    /* Handles also the possible keyboard command while fighting. */
    private void fightCommands(int keyCode) {
        if(keyCode == KeyEvent.VK_SPACE) {
            this.player.setShoot(true, this.player.getLastDirection());
        }
    }

    /* Handles the possible keyboard command while in a menu. */
    private void menuCommands(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE) {
            if(this.gameController.getGameState().equals(GameState.MENU)) {
                this.menuController.resume();
            } else if(this.gameController.getGameState().equals(GameState.SHOP_MENU)) {
                this.shopController.closeShop();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setKey(final int key, final boolean clicked) {
        final Optional<Command<Integer, Boolean, Optional<Direction>>> command = this.keyList.stream()
                .filter(obj -> obj.getKey() == key)
                .findFirst();
        command.ifPresent(integerBooleanOptionalCommand -> integerBooleanOptionalCommand.setClicked(clicked));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAllInactive() {
        this.keyList.forEach(k -> k.setClicked(false));
    }

    /* Finds a key in the key list. */
    private Optional<Command<Integer, Boolean, Optional<Direction>>> findKey(final int key) {
        return this.keyList.stream().filter(obj -> obj.getKey() == key).findFirst();
    }

    /* Checks if the vertical movement keys are being pressed and returns true if non is active. */
    private boolean checkVerticalKeys() {
        if (this.command.isPresent()) {
            return !this.findKey(KeyEvent.VK_S).get().getClicked() && !this.findKey(KeyEvent.VK_W).get().getClicked();
        }
        return false;
    }

    /* Checks if the horizontal movement keys are being pressed and returns true if non is active. */
    private boolean checkHorizontalKeys() {
        if (this.command.isPresent()) {
            return !this.findKey(KeyEvent.VK_D).get().getClicked() && !this.findKey(KeyEvent.VK_A).get().getClicked();
        }
        return false;
    }

}
