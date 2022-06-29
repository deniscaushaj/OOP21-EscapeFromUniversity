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
     ** @return a list of ObstacleObject
     */
    List<ObstacleObject> getWallsList();

    /**
     * Returns the list of walls.
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getNPCList();

    /**
     * Returns the list of walls.
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getDoorList();

    /**
     * Returns the list of furniture.
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getFurnitureList();
}
