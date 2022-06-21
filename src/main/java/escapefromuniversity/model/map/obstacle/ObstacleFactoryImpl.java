package escapefromuniversity.model.map.obstacle;

import escapefromuniversity.model.map.Layer;
import escapefromuniversity.model.map.TMXMapParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An implementation of ObstacleFactory interface.
 */
public class ObstacleFactoryImpl {

    private static final String MAP_NAME = "final-map.tmx";
    //TODO: Controllare che ID sia diverso da 0
    //TODO: Posizione dell'hit-box (48x48)
    //TODO: Settare tutti gli obstacle "unwalkable" così da dover fare un metodo unico per generalizzare.

    public List<Layer> getObstacleList() throws ParserConfigurationException, IOException, SAXException {
        var map = new TMXMapParser(MAP_NAME);
        return map.parse().getLayers()
                .stream()
                .filter(l -> l.getProperties().contains("unwalkable"))
                .collect(Collectors.toList());
    }
                //.filter(l -> l.getData().stream().filter( d -> !d.contains(0)))
    //.filter(l -> l.getData().stream().map(layer -> layer.stream().filter(v -> !v.equals("0")).collect(Collectors.toList())))
}
