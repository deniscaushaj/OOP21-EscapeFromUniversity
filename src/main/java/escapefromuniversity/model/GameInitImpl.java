package escapefromuniversity.model;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.map.MapManager;
import escapefromuniversity.model.map.MapProperties;
import escapefromuniversity.model.map.TMXMapParser;

/**
 * 
 * class implement gameInit.
 *
 */
public class GameInitImpl implements GameInit {
    private final List<StaticGameObject> staticGameObjects = new LinkedList<>();
    private final List<DynamicGameObject> dynamicGameObjects = new LinkedList<>();
    private final MapManager mapManager;
    private final MapProperties mapProperties;
    private IteratorOfID iterator = new IteratorOfID();

    private static final String TMX_MAP_PATH = "final-map.tmx";


    /**
     * 
     * @param mapManager
     */
    public GameInitImpl(final MapManager mapManager) {
        this.mapManager = mapManager;
        this.mapProperties = new TMXMapParser(TMX_MAP_PATH).parse();
    }

    @Override
    public void update(final double deltaTime) {
        List<DynamicGameObject> copyListDGO = new LinkedList<>(List.copyOf(this.dynamicGameObjects));
        copyListDGO.iterator().forEachRemaining(obj -> {
            obj.update(deltaTime);
        });
        for (final GameObject obj : this.dynamicGameObjects) {
            for (final GameObject obj2 : this.getAllGameObject()) {
                if (obj.getObjectHitBox() == null || obj2.getObjectHitBox() == null || obj.equals(obj2)) {
                    continue;
                } else {
                    obj.collisionWith(obj2);
                }
            }
        }
    }

    private List<GameObject> getAllGameObject() {
        final List<GameObject> obj = new LinkedList<>(staticGameObjects);
        obj.addAll(dynamicGameObjects);
        return obj;
    }

    @Override
    public void deleteGameObject(final DynamicGameObject gameObject) {
        //staticGameObjects.remove(gameObject);
        this.getMapManager().removeID(gameObject.getID());
        dynamicGameObjects.remove(gameObject);
    }


    @Override
    public void addDynamicGameObject(final DynamicGameObject dGObj) {
        dGObj.setID(iterator.next());
        dynamicGameObjects.add(dGObj);

    }

    @Override
    public void addStaticGameObject(final StaticGameObject sGObj) {
        sGObj.setID(iterator.next());
        staticGameObjects.add(sGObj);

    }

    @Override
    public List<DynamicGameObject> getAllDynamicGameObject() {
        return this.dynamicGameObjects;
    }

    @Override
    public Player getPlayer() {
        return (Player) this.dynamicGameObjects.stream().filter(e -> e.getType() == GameObjectType.PLAYER).findAny().get();
    }

    @Override
    public void goQuiz(final Boss boss) {
        this.getMapManager().setupQuiz(boss);
    }

    @Override
    public MapManager getMapManager() {
        return this.mapManager;
    }

    @Override
    public MapProperties getMap() {
        return this.mapProperties;
    }
}
