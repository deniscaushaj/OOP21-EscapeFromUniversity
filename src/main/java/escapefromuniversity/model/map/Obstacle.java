package escapefromuniversity.model.map;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * An interface of an obstacle.
 */
public interface Obstacle {

    /**
     * Returns the list of walls.
     * @throws ParserConfigurationException indicates a serious configuration error.
     * @throws SAXException encapsulate a general SAX error or warning
     * @throws IOException signals that an I/O exception of some sort has occurred
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getWallsList() throws ParserConfigurationException, IOException, SAXException;

    /**
     * Returns the list of walls.
     * @throws ParserConfigurationException indicates a serious configuration error.
     * @throws SAXException encapsulate a general SAX error or warning
     * @throws IOException signals that an I/O exception of some sort has occurred
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getNPCList() throws ParserConfigurationException, IOException, SAXException;

    /**
     * Returns the list of walls.
     * @throws ParserConfigurationException indicates a serious configuration error.
     * @throws SAXException encapsulate a general SAX error or warning
     * @throws IOException signals that an I/O exception of some sort has occurred
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getDoorList() throws ParserConfigurationException, IOException, SAXException;

    /**
     * Returns the list of furniture.
     * @throws ParserConfigurationException indicates a serious configuration error.
     * @throws SAXException encapsulate a general SAX error or warning
     * @throws IOException signals that an I/O exception of some sort has occurred
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getFurnitureList() throws ParserConfigurationException, IOException, SAXException;
}
