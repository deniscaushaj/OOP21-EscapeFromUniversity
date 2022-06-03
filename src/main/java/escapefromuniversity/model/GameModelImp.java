package escapefromuniversity.model;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapManagerImpl;

public class GameModelImp implements GameModel{
	private final MapManager mapManaget = new MapManagerImpl();

	@Override
	public List<GameObject> getAllGameObj() {
		return new LinkedList<GameObject>(this.mapManaget.getRoom().getAllGameObject());
	}

	@Override
	public void updateGame(double deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLost() {
		// TODO Auto-generated method stub
		return false;
	}

}
