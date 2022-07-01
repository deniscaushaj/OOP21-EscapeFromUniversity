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
     * @param gameInit the game initialization
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getWallsList(GameInit gameInit);

    /**
     * Returns the list of walls.
     * @param gameInit the game initialization
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getNPCList(GameInit gameInit);

    /**
     * Returns the list of doors.
     * @param gameInit the game initialization
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getDoorList(GameInit gameInit);

    /**
     * Returns the list of the victory doors.
     * @param gameInit the game initialization
     * @return the list of the victory doors
     */
    List<ObstacleObject> getVictoryDoorList(GameInit gameInit);

    /**
     * Returns the list of furniture.
     * @param gameInit the game initialization
     * @return a list of ObstacleObject
     */
    List<ObstacleObject> getFurnitureList(GameInit gameInit);

    /**
     * Returns the list of the tiles of the shop.
     * @param gameInit the game initialization
     * @return the list of the tiles of the shop
     */
    List<ObstacleObject> getShopList(GameInit gameInit);
}
