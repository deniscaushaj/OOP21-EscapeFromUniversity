package escapefromuniversity.model;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.enemy.Boss;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapManagerImpl;
import escapefromuniversity.model.player.Player;

public class GameModelImp implements GameModel{
	private final MapManager mapManager;
	private final GameController controller;
	
	public GameModelImp(GameController controller) {
		this.controller = controller;
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
	public boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLost() {
		return false; //this.mapManager.gameOver();
	}

	/**
	 * {@
	 */
	@Override
	public Player getPlayer() {
		return this.mapManager.getPlayer();
	}

	@Override
	public void goQuiz(Boss boss) {
		this.controller.goQuiz();
		
	}

	
	public Point2D getPositionOfID(int id) {
		for(final GameObject obj : this.mapManager.getRoom().getAllGameObject()) {
			if(obj.getID() == id) {
				return obj.getObjectPosition();
			}
		}
		return null;
	}

	@Override
	public void goShop() {
		// TODO Auto-generated method stub
		
	}

}
