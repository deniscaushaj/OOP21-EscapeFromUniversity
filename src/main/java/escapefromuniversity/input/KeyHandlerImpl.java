package escapefromuniversity.input;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.gameObject.Direction;
import escapefromuniversity.model.player.Player;
import escapefromuniversity.model.player.PlayerMovement;
import escapefromuniversity.model.player.PlayerMovementImpl;

public class KeyHandlerImpl implements KeyHandler {

    private final GameController gameController;
    private final Player player;
    private final PlayerMovement playerMovement;
    private Optional<Command<Integer, Boolean, Optional<Direction>>> command;
    private final List<Command<Integer, Boolean, Optional<Direction>>> keyList = new ArrayList<>();

    public KeyHandlerImpl(final GameModel gameModel, final GameController gameController) {
        this.gameController = gameController;
        this.player = gameModel.getPlayer();
        this.playerMovement = new PlayerMovementImpl(this.player);
        this.createKeyList();
    }

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

    @Override
    public List<Command<Integer, Boolean, Optional<Direction>>> getKeyList() {
        return this.keyList;
    }

    public void executeCommand() {
        this.keyList.forEach(key -> {
            int keyCode;
            if (key.getClicked()) {
                keyCode = key.getKey();
                this.command = findKey(keyCode);
                if (this.command.isEmpty()) {
                    switch (this.gameController.getGameState()) {
                        case FIGHT -> {
                            this.fightCommands(keyCode);
                            this.playCommands(keyCode);
                        }
                        case MENU -> this.menuCommands(keyCode);
                        case PLAY, WIN -> this.playCommands(keyCode);
                        case QUIZ -> this.quizCommands(keyCode);
                        case SHOP -> this.shopCommands(keyCode);
                        default -> {
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

    private void playCommands(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE) {
//             open menu
        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            playerMovement.move(Direction.LEFT);
        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            playerMovement.move(Direction.DOWN);
        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            playerMovement.move(Direction.RIGHT);
        } else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            playerMovement.move(Direction.UP);
        }
    }

    private void fightCommands(int keyCode) {
        if(keyCode == KeyEvent.VK_SPACE) {
            // shoot
        }
    }

    private void menuCommands(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE) {
//            close menu
        } else if (keyCode == KeyEvent.VK_ENTER) {

        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {

        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {

        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {

        } else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {

        }
    }

    private void quizCommands(int keyCode) {
        if (keyCode == KeyEvent.VK_ENTER) {

        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {

        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {

        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {

        } else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {

        }
    }

    private void shopCommands(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE) {
//          close shop
        } else if (keyCode == KeyEvent.VK_ENTER) {

        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {

        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {

        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {

        } else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {

        }
    }

    public void setKey(final int key, final boolean clicked) {
        final Optional<Command<Integer, Boolean, Optional<Direction>>> command = this.keyList.stream()
                                                                                             .filter(obj -> obj.getKey() == key)
                                                                                             .findFirst();
        command.ifPresent(integerBooleanOptionalCommand -> integerBooleanOptionalCommand.setClicked(clicked));
    }

    @Override
    public void setAllInactive() {
        this.keyList.forEach(k -> k.setClicked(false));
    }

    private Optional<Command<Integer, Boolean, Optional<Direction>>> findKey(final int key) {
        return this.keyList.stream().filter(obj -> obj.getKey() == key).findFirst();
    }

    private boolean checkVerticalKeys() {
        if (this.command.isPresent()) {
            return !this.findKey(KeyEvent.VK_S).get().getClicked() && !this.findKey(KeyEvent.VK_W).get().getClicked();
        }
        return false;
    }

    private boolean checkHorizontalKeys() {
        if (this.command.isPresent()) {
            return  !this.findKey(KeyEvent.VK_D).get().getClicked() && !this.findKey(KeyEvent.VK_A).get().getClicked();
        }
        return false;
    }

}