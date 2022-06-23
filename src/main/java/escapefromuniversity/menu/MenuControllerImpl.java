package escapefromuniversity.menu;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.GameState;

/**
 * 
 * implementation interface MenuController.
 *
 */
public class MenuControllerImpl implements MenuController {
    private final GameController gameController;
    private final MenuView view;
    private boolean activeMenu;

    /**
     * 
     * @param gameController
     */
    public MenuControllerImpl(final GameController gameController) {
        this.gameController = gameController;
        this.view = new MenuViewImpl(this);
        this.activeMenu = false;
    }

    @Override
    public void getCommand() {
        this.view.startCommandMenu();
    }

    @Override
    public void exit() {
        this.activeMenu = false;
        System.exit(0);
    }

    @Override
    public void resume() {
        this.activeMenu = false;
        this.view.close();
        this.gameController.setGameState(GameState.PLAY);
    }

    @Override
    public void back() {
        this.view.startMenu();
    }

    @Override
    public void startView() {
        if (!this.activeMenu) {
            this.activeMenu = true;
            this.view.startView();
        }
    }

}
