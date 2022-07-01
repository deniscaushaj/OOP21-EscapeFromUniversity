package escapefromuniversity.model.map;

import org.xml.sax.SAXException;

import escapefromuniversity.model.GameInit;

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
    List<ObstacleObject> getWallsList(GameInit map);

    /**
     * Returns the list of walls.
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getNPCList(GameInit map);

    /**
     * Returns the list of walls.
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getDoorList(GameInit map);

    /**
     * Returns the list of furniture.
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getFurnitureList(GameInit map);

    /**
     * Returns the list of the tiles of the shop.
     * @return the list of the tiles of the shop
     */
    List<ObstacleObject> getShopList(GameInit map);
}
