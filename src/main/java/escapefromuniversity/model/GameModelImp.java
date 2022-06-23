package escapefromuniversity.model;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapManagerImpl;
import escapefromuniversity.model.gameObject.player.Player;

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
	public void isWin() {
		this.controller.setGameState(GameState.WIN);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isLost() {
		this.controller.setGameState(GameState.LOST);
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
	@Override
	public void goQuiz(Boss boss) {
		this.controller.setGameState(GameState.QUIZ);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void goShop() {
		this.controller.setGameState(GameState.SHOP);
	}

	@Override
	public int finalMark() {
		return this.getPlayer().getFinalMark();
	}

	@Override
	public Boss getCurrentBoss() {
		return null;
	}

}
