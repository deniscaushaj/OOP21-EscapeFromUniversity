package escapefromuniversity.model.map;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * A class which models an Obstacle.
 */
public interface ObstacleFactory {

    Obstacle createObstacle() throws ParserConfigurationException, IOException, SAXException;

    Obstacle createWall() throws ParserConfigurationException, IOException, SAXException;

    Obstacle createNPC() throws ParserConfigurationException, IOException, SAXException;
}
