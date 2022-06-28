package escapefromuniversity.model.map;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.gameObject.player.Player;

public class MapImpl implements Mapp {
    private final List<StaticGameObject> staticGameObjects = new LinkedList<>();
    private final List<DynamicGameObject> dynamicGameObjects = new LinkedList<>();
    private final MapManager mapManager;
    
    
    public MapImpl(final MapManager mapManager) {
    	this.mapManager = mapManager;
    }


    @Override
    public void update(final double deltaTime) {
        final List<DynamicGameObject> listDGObj = new LinkedList<>(List.copyOf(this.dynamicGameObjects));
        /*listDGObj.iterator().forEachRemaining(obj -> { obj.update(deltaTime);});
        listDGObj.iterator().forEachRemaining(obj -> {
            for (final GameObject obj2 : this.getAllGameObject()) {
                obj.collisionWith(obj2);
            }
        });*/
    }
    
    private List<GameObject> getAllGameObject() {
        final List<GameObject> obj = new LinkedList<>(staticGameObjects);
        obj.addAll(dynamicGameObjects);
        return obj;
    }

    @Override
    public void deleteGameObject(final GameObject gameObject) {
        staticGameObjects.remove(gameObject);
        dynamicGameObjects.remove(gameObject);
    }


    @Override
    public void addDynamicGameObject(final DynamicGameObject dGObj) {
        dynamicGameObjects.add(dGObj);

    }

    @Override
    public void addStaticGameObject(final StaticGameObject sGObj) {
        staticGameObjects.add(sGObj);

    }

    @Override
    public List<DynamicGameObject> getAllDynamicGameObject() {
        return this.dynamicGameObjects;
    }

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void goQuiz(final Boss boss) {
		this.getMapManager().setupQuiz(boss);
	}

	@Override
	public MapManager getMapManager() {
		return this.mapManager;
	}
}
