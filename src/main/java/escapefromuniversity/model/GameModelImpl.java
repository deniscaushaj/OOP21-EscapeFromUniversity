package escapefromuniversity.model;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapManagerImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

/**
 * 
 * class implement GameModel.
 *
 */
public class GameModelImpl implements GameModel {
    private final MapManager mapManager;
    private final GameController gameController;
    private Boss currentBoss;

    /**
     * 
     * @param gameController
     */
    public GameModelImpl(final GameController gameController) throws ParserConfigurationException, IOException, SAXException {
        this.gameController = gameController;
        this.mapManager = new MapManagerImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DynamicGameObject> getAllDynamicGameObj() {
        return new LinkedList<DynamicGameObject>(this.mapManager.getMap().getAllDynamicGameObject());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateGame(final double deltaTime) {
        this.mapManager.getMap().update(deltaTime);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWin() {
        this.gameController.setGameState(GameState.WIN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLost() {
        this.gameController.setGameState(GameState.LOST);
    }

    @Override
    public void setShop() {
        this.gameController.setGameState(GameState.SHOP_MENU);
    }

    @Override
    public void setQuiz(final Boss boss) {
        this.currentBoss = boss;
        this.gameController.setGameState(GameState.QUIZ);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return this.mapManager.getPlayer();
    }

    /**
     * {@inheritDoc}
     */
    public Point2D getPositionOfID(final int id) {
        DynamicGameObject a = this.mapManager.getMap().getAllDynamicGameObject().stream().filter(e -> e.getID() == id).findFirst().orElse(null);
        return a.getObjectPosition();
    }

    @Override
    public int getPlayerFinalMark() {
        return this.getPlayer().getFinalMark();
    }

    @Override
    public Boss getCurrentBoss() {
        return this.currentBoss;
    }

    @Override
    public State getStateID(final int id) {
        DynamicGameObject a = this.mapManager.getMap().getAllDynamicGameObject().stream().filter(e -> e.getID() == id).findFirst().orElse(null);
        return a.getState();
    }

    @Override
    public GameObjectType getTypeID(final int id) {
        DynamicGameObject a = this.mapManager.getMap().getAllDynamicGameObject().stream().filter(e -> e.getID() == id).findFirst().orElse(null);
        return a.getType();
    }

}