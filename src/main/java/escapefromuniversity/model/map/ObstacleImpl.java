package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.StaticGameObject;
import escapefromuniversity.model.gameObject.StaticGameObjectImpl;
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

    /*
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
    */

    public List<ObstacleObject> getObstacleList(String property, GameObjectType obsType) throws ParserConfigurationException, IOException, SAXException {
        var map = new TMXMapParser(MAP_NAME);
        var layers = map.parse().getLayers();
        return layers
                .stream()
                .filter(l -> l.getProperties().contains(property))
                .flatMap(l -> IntStream.range(0, layers.size())
                        .flatMap(ll -> IntStream.iterate(0, j->j+1).limit(l.getData().size())
                                .map(x -> new ObstacleObject(obsType, new Point2D(i, ll), new Point2D(x, ll), l.getData().get(ll).get(x).byteValue()))
                                .filter(d -> d.getByteValue() != 0)))
                .collect(Collectors.toList());

    }

    public List<StaticGameObjectImpl> getWallsList() throws ParserConfigurationException, IOException, SAXException {
        var l = getObstacleList("walls", GameObjectType.WALL);
        List<StaticGameObjectImpl> ago;
        return l.stream().map(o -> new StaticGameObjectImpl(GameObjectType.WALL, new Point2D(0,0), new Point2D(0,0)).collect(Collectors.toList());
    }

}
