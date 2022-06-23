package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * An implementation of Obstacle interface.
 */
public class ObstacleImpl implements Obstacle {

    private static final String MAP_NAME = "final-map.tmx";

    //TODO: Calcolare la posizione dell'hit-box come gameobject (48x48)

    @Override
    public List<ObstacleObject> getObstacleList(String property, GameObjectType obsType) throws ParserConfigurationException, IOException, SAXException {
        var map = new TMXMapParser(MAP_NAME);
        return map.parse().getLayers()
                .stream()
                .filter(l -> l.getProperties().contains(property))
                .flatMap(l -> l.getData()
                                .stream()
                                .flatMap(ll -> ll
                                        .stream()
                                        .map(x -> new ObstacleObject(obsType, new Point2D(0, 0), new Point2D(0, 0), x.byteValue()))
                                        .filter(d -> d.getByteValue() != 0)))
                .collect(Collectors.toList());
    }

    public List<ObstacleObject> getWallsList() throws ParserConfigurationException, IOException, SAXException {
        return getObstacleList("walls", GameObjectType.WALL);
    }

    public List<ObstacleObject> getNPCList() throws ParserConfigurationException, IOException, SAXException {
        return getObstacleList("npc", GameObjectType.WALL);
    }

    public List<ObstacleObject> getDoorList() throws ParserConfigurationException, IOException, SAXException {
        return getObstacleList("door", GameObjectType.DOOR);
    }

    public List<ObstacleObject> getFornitureList() throws ParserConfigurationException, IOException, SAXException {
        return getObstacleList("forniture", GameObjectType.FORNITURE);
    }
}
