package escapefromuniversity.menu;

import escapefromuniversity.inGame.GameController;

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
        this.gameController.setGameState(this.gameController.getPrevGameState());
        this.activeMenu = false;
        this.view.close();
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
