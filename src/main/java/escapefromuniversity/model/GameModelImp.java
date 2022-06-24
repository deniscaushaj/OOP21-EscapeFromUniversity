package escapefromuniversity.model;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapManagerImpl;
import escapefromuniversity.model.gameObject.player.Player;

public class GameModelImp implements GameModel{
	private final MapManager mapManager;
	private final GameController gameController;
	
	public GameModelImp(GameController gameController) {
		this.gameController = gameController;
		this.mapManager = new MapManagerImpl(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<GameObject> getAllGameObj() {
		return new LinkedList<GameObject>(this.mapManager.getRoom().getAllGameObject());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateGame(double deltaTime) {
		this.mapManager.getRoom().update(deltaTime);
		
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
		this.gameController.setGameState(GameState.SHOP);
	}

	@Override
	public void setQuiz(Boss boss) {
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
	public Point2D getPositionOfID(int id) {
		for(final GameObject obj : this.mapManager.getRoom().getAllGameObject()) {
			if(obj.getID() == id) {
				return obj.getObjectPosition();
			}
		}
		return null;
	}

	@Override
	public int getPlayerFinalMark() {
		return this.getPlayer().getFinalMark();
	}

	@Override
	public Boss getCurrentBoss() {
		return null;
	} // TODO change return

    @Override
    public State getStateID(int id) {
        return null;
    }

    @Override
    public GameObjectType getTypeID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
