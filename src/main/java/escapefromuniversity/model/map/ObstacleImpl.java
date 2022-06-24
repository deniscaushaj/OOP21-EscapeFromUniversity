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
public class ObstacleImpl implements Obstacle {

    private static final int TILE_DIMENSION = 48;
    private static final String MAP_NAME = "final-map.tsx";

    private List<ObstacleObject> getObstacleList(final String property, final GameObjectType obsType) throws ParserConfigurationException, IOException, SAXException {
        var map = new TMXMapParser(MAP_NAME);
        return map.parse().getLayers()
                .stream()
                .filter(l -> l.getProperties().contains(property))
                .flatMap(l -> l.getData()
                                .stream()
                                .flatMap(ll -> ll
                                        .stream()
                                        .map(x -> new ObstacleObject(obsType, calcTilePosInPixel(l, ll.indexOf(x)), x.byteValue()))
                                        .filter(d -> d.getByteValue() != 0)))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObstacleObject> getWallsList() throws ParserConfigurationException, IOException, SAXException {
        return getObstacleList("walls", GameObjectType.WALL);
    }

    @Override
    public List<ObstacleObject> getNPCList() throws ParserConfigurationException, IOException, SAXException {
        return getObstacleList("npc", GameObjectType.WALL);
    }

    @Override
    public List<ObstacleObject> getDoorList() throws ParserConfigurationException, IOException, SAXException {
        return getObstacleList("door", GameObjectType.DOOR);
    }

    @Override
    public List<ObstacleObject> getFurnitureList() throws ParserConfigurationException, IOException, SAXException {
        return getObstacleList("furniture", GameObjectType.FURNITURE);
    }

    private Rectangle calcTilePosInPixel(final Layer layer, final int pos) {
        var cols = layer.getWidth();
        var x = pos % cols;
        var y = pos / cols;
        return new Rectangle(new Point2D(x * TILE_DIMENSION, y * TILE_DIMENSION),
                             new Point2D((x + 1) * TILE_DIMENSION, (y + 1) * TILE_DIMENSION));
    }
}
