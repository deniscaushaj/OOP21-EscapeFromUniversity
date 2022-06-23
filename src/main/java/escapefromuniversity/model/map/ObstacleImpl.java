package escapefromuniversity.model.map;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An implementation of Obstacle interface.
 */
public class ObstacleImpl implements Obstacle {

    private static final String MAP_NAME = "final-map.tmx";
<<<<<<< HEAD
    //TODO: Posizione dell'hit-box (48x48)
    
=======
    //TODO: Calcolare la posizione dell'hit-box come gameobject (48x48)

>>>>>>> 6dc00950b1128f9e321b9b015b6008c5ea810803
    @Override
    public List<Integer> getObstacleList() throws ParserConfigurationException, IOException, SAXException {
        var map = new TMXMapParser(MAP_NAME);
        return map.parse().getLayers()
                .stream()
                .filter(l -> l.getProperties().contains("unwalkable"))
                .flatMap(l -> l.getData()
                                .stream()
                                .flatMap(ll -> ll
                                        .stream()
                                        .filter(d -> d.byteValue() != 0)))
                .collect(Collectors.toList());
    }
}
