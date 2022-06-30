package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An implementation of Obstacle interface.
 */
public class ObstaclesFactory implements Obstacle {

    private static final int TILE_DIMENSION = 1;
    private static final String MAP_NAME = "final-map.tmx";
    private final MapProperties map;

    public ObstaclesFactory(final MapProperties map) {
        this.map = map;
    }

    private List<ObstacleObject> getObstacleList(final String property, final GameObjectType obsType) {
        //var map = new TMXMapParser(MAP_NAME);
        return map.getLayers()
                .stream()
                .filter(l -> l.getProperties().contains(property))
                .flatMap(l -> l.getVisibleTiles().stream())
                .map(t -> new ObstacleObject(obsType, this.calcTilePosInPixel(t.getX(), t.getY())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObstacleObject> getWallsList() {
        return getObstacleList("walls", GameObjectType.WALL);
    }

    @Override
    public List<ObstacleObject> getNPCList() {
        return getObstacleList("npc", GameObjectType.WALL);
    }

    @Override
    public List<ObstacleObject> getDoorList() {
        return getObstacleList("door", GameObjectType.DOOR);
    }

    @Override
    public List<ObstacleObject> getFurnitureList() {
        return getObstacleList("furniture", GameObjectType.FURNITURE);
    }

    private Rectangle calcTilePosInPixel(final int x, final int y) {
        return new Rectangle(new Point2D(x, y),
                new Point2D(x + 1, y + 1));
    }
}
