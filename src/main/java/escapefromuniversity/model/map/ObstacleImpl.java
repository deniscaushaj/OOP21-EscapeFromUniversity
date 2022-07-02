package escapefromuniversity.model.map;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Rectangle;
import escapefromuniversity.model.gameObject.GameObjectType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An implementation of Obstacle interface.
 */
public class ObstacleImpl implements Obstacle {

    private static final String MAP_NAME = "final-map.tmx";
    private final MapProperties map;

    /**
     * A constructor for ObstaclesFactory.
     * @param map the map
     */
    public ObstacleImpl(final MapProperties map) {
        this.map = map;
    }

    private List<ObstacleObject> getObstacleList(final String property, final GameObjectType obsType, final GameInit gameInit) {
        return map.getLayers()
                .stream()
                .filter(l -> l.getProperties().contains(property))
                .flatMap(l -> l.getVisibleTiles().stream())
                .map(t -> new ObstacleObject(obsType, this.calcTilePosInPixel(t.getX(), t.getY()), gameInit))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObstacleObject> getWallsList(final GameInit gameInit) {
        return getObstacleList("walls", GameObjectType.WALL, gameInit);
    }

    @Override
    public List<ObstacleObject> getNPCList(final GameInit gameInit) {
        return getObstacleList("npc", GameObjectType.NPC, gameInit);
    }

    @Override
    public List<ObstacleObject> getDoorList(final GameInit gameInit) {
        return getObstacleList("door", GameObjectType.DOOR, gameInit);
    }

    @Override
    public List<ObstacleObject> getVictoryDoorList(final GameInit gameInit) {
        return getObstacleList("victory-door", GameObjectType.DOOR, gameInit);
    }

    @Override
    public List<ObstacleObject> getFurnitureList(final GameInit gameInit) {
        return getObstacleList("furniture", GameObjectType.FURNITURE, gameInit);
    }

    @Override
    public List<ObstacleObject> getShopList(final GameInit gameInit) {
        return getObstacleList("shop", GameObjectType.SHOP, gameInit);
    }

    private Rectangle calcTilePosInPixel(final int x, final int y) {
        return new Rectangle(new Point2D(x, y),
                new Point2D(x + 1, y + 1));
    }
}
