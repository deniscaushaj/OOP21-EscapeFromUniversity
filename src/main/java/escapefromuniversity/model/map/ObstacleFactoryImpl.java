package escapefromuniversity.model.map;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * An implementation of ObstacleFactory interface.
 */
public class ObstacleFactoryImpl implements ObstacleFactory {

    private static final String MAP_NAME = "final-map.tmx";

    private Obstacle genObstacle(String propertyName) throws ParserConfigurationException, IOException, SAXException {
        var map = new TMXMapParser(MAP_NAME);
        var obs = map.parse().getLayers()
                .stream()
                .filter(l -> l.getProperties().contains(propertyName))
                .collect(Collectors.toList());
        return null;
    }
    @Override
    public Obstacle createObstacle() throws ParserConfigurationException, IOException, SAXException {
        return genObstacle("unwalkable");
    }

    @Override
    public Obstacle createWall() throws ParserConfigurationException, IOException, SAXException {
        return genObstacle("border");
    }
}
