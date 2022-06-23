package escapefromuniversity.model.map;

import escapefromuniversity.model.gameObject.GameObjectType;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * An interface of an obstacle
 */
public interface Obstacle {

    /**
     * Returns a list of obstacles IDs
     * @throws ParserConfigurationException indicates a serious configuration error.
     * @throws SAXException encapsulate a general SAX error or warning
     * @throws IOException signals that an I/O exception of some sort has occurred
     */
    List<ObstacleObject> getObstacleList(String property, GameObjectType obsType) throws ParserConfigurationException, IOException, SAXException;
}
