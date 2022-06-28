package escapefromuniversity;

import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.map.Obstacle;
import escapefromuniversity.model.map.ObstaclesFactory;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestObstacle {

    @Test
    public void testObstacleList() throws ParserConfigurationException, IOException, SAXException {
        Obstacle obs = new ObstaclesFactory();
        assertTrue(obs.getDoorList().stream().allMatch(n -> n.getType() == (GameObjectType.DOOR)));
        assertTrue(obs.getFurnitureList().stream().allMatch(n -> n.getType() == (GameObjectType.FURNITURE)));
        assertTrue(obs.getWallsList().stream().allMatch(n -> n.getType() == (GameObjectType.WALL)));
        assertFalse(obs.getWallsList().stream().anyMatch(n -> n.getType() == (GameObjectType.DOOR)));
    }
}
