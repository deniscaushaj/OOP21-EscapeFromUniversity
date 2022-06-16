package escapefromuniversity.model;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapManagerImpl;
import escapefromuniversity.model.player.Player;

public class GameModelImp implements GameModel{
	private final MapManager mapManaget;
	private final GameController controller;
	
	public GameModelImp(GameController controller) {
		this.controller = controller;
		this.mapManaget = new MapManagerImpl(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<GameObject> getAllGameObj() {
		return new LinkedList<GameObject>(this.mapManaget.getRoom().getAllGameObject());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateGame(double deltaTime) {
		this.mapManaget.getRoom().update(deltaTime);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLost() {
		return this.mapManaget.gameOver();
	}

	/**
	 * {@
	 */
	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void goQuiz(GameObjectType type) {
		this.controller.goQuiz();
		
	}

	
	public Point2D getPositionOfID(int id) {
		for(final GameObject obj : this.mapManaget.getRoom().getAllGameObject()) {
			if(obj.getID() == id) {
				return obj.getObjectPosition();
			}
		}
		return null;
	}

}
