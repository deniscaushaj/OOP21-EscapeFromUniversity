package escapefromuniversity.model.map;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An implementation of Obstacle interface.
 */
public class ObstaclesFactory implements Obstacle {

    private static final String MAP_NAME = "final-map.tmx";
    private final MapProperties mapp;

    /**
     * A constructor for ObstaclesFactory.
     * @param map the map
     */
    public ObstaclesFactory(final MapProperties mapp) {
        this.mapp = mapp;
    }

    private List<ObstacleObject> getObstacleList(final String property, final GameObjectType obsType, final GameInit map) {
        //var map = new TMXMapParser(MAP_NAME);
        return mapp.getLayers()
                .stream()
                .filter(l -> l.getProperties().contains(property))
                .flatMap(l -> l.getVisibleTiles().stream())
                .map(t -> new ObstacleObject(obsType, this.calcTilePosInPixel(t.getX(), t.getY()), map))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObstacleObject> getWallsList(GameInit map) {
        return getObstacleList("walls", GameObjectType.WALL, map);
    }

    @Override
    public List<ObstacleObject> getNPCList(GameInit map) {
        return getObstacleList("npc", GameObjectType.NPC, map);
    }

    @Override
    public List<ObstacleObject> getDoorList(GameInit map) {
        return getObstacleList("door", GameObjectType.DOOR, map);
    }

    @Override
    public List<ObstacleObject> getFurnitureList(GameInit map) {
        return getObstacleList("furniture", GameObjectType.FURNITURE, map);
    }

    @Override
    public List<ObstacleObject> getShopList(GameInit map) {
        return getObstacleList("shop", GameObjectType.SHOP, map);
    }

    private Rectangle calcTilePosInPixel(final int x, final int y) {
        return new Rectangle(new Point2D(x, y),
                new Point2D(x + 1, y + 1));
    }
}
