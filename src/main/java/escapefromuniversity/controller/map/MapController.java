package escapefromuniversity.controller.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.view.map.canvas.CanvasDrawerImpl;
import escapefromuniversity.model.map.Rectangle;
import escapefromuniversity.model.map.TMXMapParser;
import escapefromuniversity.model.map.TileDrawerImpl;
import javafx.scene.canvas.Canvas;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MapController {

    public MapController(){
        final var gc = new Canvas().getGraphicsContext2D();
        final var parser = new TMXMapParser("final-map.tmx");
        try {
            var map = parser.parse();
            var drawer = new TileDrawerImpl(map, new CanvasDrawerImpl(new Canvas()));

            map.getLayers().forEach(l -> {
                for (int i = 0; i < map.getWidth(); i++) {
                    for (int j = 0; j < map.getHeight(); j++) {
                        drawer.drawTileByID(l.getData().get(i).get(j),
                                new Rectangle(new Point2D(i * 20, j * 20), new Point2D((i+1) * 20, (j+1) * 20)));
                    }
                }
            });
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
