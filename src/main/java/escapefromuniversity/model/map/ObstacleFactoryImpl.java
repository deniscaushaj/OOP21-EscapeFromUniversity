package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.HitBox;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * An implementation of ObstacleFactory interface.
 */
public class ObstacleFactoryImpl implements ObstacleFactory {

    private static final String MAP_NAME = "final-map.tmx";
    //TODO: Controllare che ID sia diverso da 0
    //TODO: Creare un iterator per generare gli ID
    //TODO: Posizione dell'hit-box (48x48)
    private Obstacle genObstacle(String propertyName) throws ParserConfigurationException, IOException, SAXException {
        var map = new TMXMapParser(MAP_NAME);
        var obs = map.parse().getLayers()
                .stream()
                .filter(l -> l.getProperties().contains(propertyName))
                .collect(Collectors.toList());
        return new Obstacle() {
            @Override
            public HitBox getObjectHitBox() {
                return null;
            }

            @Override
            public Point2D getObjectPosition() {
                return null;
            }

            @Override
            public int getID() {
                return 0;
            }

            @Override
            public void setID(int id) {

            }

            @Override
            public GameObjectType getType() {
                return null;
            }

            @Override
            public void collisionWith(GameObject gObj2) {

            }

            @Override
            public boolean collisionWithCheck(GameObject gObj2) {
                return false;
            }

            @Override
            public Room getRoom() {
                return null;
            }
        };
    }
    @Override
    public Obstacle createObstacle() throws ParserConfigurationException, IOException, SAXException {
        return genObstacle("unwalkable");
    }

    @Override
    public Obstacle createWall() throws ParserConfigurationException, IOException, SAXException {
        return genObstacle("border");
    }

    public Obstacle createNPC() throws ParserConfigurationException, IOException, SAXException {
        return genObstacle("npc");
    }
}
