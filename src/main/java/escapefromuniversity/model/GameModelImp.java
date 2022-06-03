package escapefromuniversity.model;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapManagerImpl;

public class GameModelImp implements GameModel{
	private final MapManager mapManaget = new MapManagerImpl();

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

}
