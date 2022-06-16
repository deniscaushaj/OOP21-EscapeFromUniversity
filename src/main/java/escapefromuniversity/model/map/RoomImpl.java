package escapefromuniversity.model.map;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.player.Player;

public class RoomImpl implements Room {
    private final List<StaticGameObject> staticGameObjects = new LinkedList<>();
    private final List<DynamicGameObject> dynamicGameObjects = new LinkedList<>();
    private final MapManager mapManager;
    
    
    public RoomImpl(MapManager mapManager) {
    	this.mapManager = mapManager;
    }

    @Override
    public void update(double deltaTime) {
        final List<DynamicGameObject> listDGObj = new LinkedList<>(List.copyOf(this.dynamicGameObjects));
        listDGObj.iterator().forEachRemaining(obj -> { obj.update(deltaTime);});
        listDGObj.iterator().forEachRemaining(obj -> {
            for(final GameObject obj2 : this.getAllGameObject()) {
                obj.collisionWith(obj2);
            }
        });
    }

    @Override
    public void deleteGameObject(GameObject gameObject) {
        staticGameObjects.remove(gameObject);
        dynamicGameObjects.remove(gameObject);
    }


    @Override
    public void addDynamicGameObject(DynamicGameObject dGObj) {
        dynamicGameObjects.add(dGObj);

    }

    @Override
    public void addStaticGameObject(StaticGameObject sGObj) {
        staticGameObjects.add(sGObj);

    }

    @Override
    public List<GameObject> getAllGameObject() {
        final List<GameObject> gameObjects = new LinkedList<>();
        gameObjects.addAll(this.dynamicGameObjects);
        gameObjects.addAll(this.staticGameObjects);
        return gameObjects;
    }

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void goQuiz(GameObjectType type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MapManager getMapManager() {
		return this.mapManager;
	}
}
