package escapefromuniversity.model.map;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.IteretorOfID;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.gameObject.player.Player;

public class MapImpl implements GameInit {
    private final List<StaticGameObject> staticGameObjects = new LinkedList<>();
    private final List<DynamicGameObject> dynamicGameObjects = new LinkedList<>();
    private final MapManager mapManager;
    private final MapProperties mapProperties;
    private IteretorOfID iterator = new IteretorOfID();

    private static final String TMX_MAP_PATH = "final-map.tmx";


    public MapImpl(final MapManager mapManager) {
        this.mapManager = mapManager;
        this.mapProperties = new TMXMapParser(TMX_MAP_PATH).parse();
    }


    @Override
    public void update(final double deltaTime) {
        this.dynamicGameObjects.iterator().forEachRemaining(obj -> {
            obj.update(deltaTime);
        });
        for (final GameObject obj : this.dynamicGameObjects) {
            for (final GameObject obj2 : this.getAllGameObject()) {
                //System.out.println(obj + "  " + obj2);
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
    public void deleteGameObject(final GameObject gameObject) {
        staticGameObjects.remove(gameObject);
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
        return (Player) this.dynamicGameObjects.stream().filter(e -> e.getType() == GameObjectType.PLAYER).findAny().orElse(null);
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
