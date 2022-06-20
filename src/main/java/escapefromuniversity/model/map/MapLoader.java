package escapefromuniversity.model.map;
import escapefromuniversity.model.basics.Point2D;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MapLoader {

    @FXML
    private Canvas gameCanvas;

    @FXML
    private Button myButton;

    @FXML
    private Slider zoomSlider;

    @FXML
    public final void myButtonOnClickHandler(final MouseEvent evt) {
        final int zoom = (int)zoomSlider.getValue();
        final var gc = gameCanvas.getGraphicsContext2D();
        final var parser = new TMXMapParser("final-map.tmx");
        try {
            var map = parser.parse();
            var drawer = new TileDrawerImpl(map, new CanvasDrawerImpl(gc));

            map.getLayers().forEach(l -> {
                for (int i = 0; i < map.getWidth(); i++) {
                    for (int j = 0; j < map.getHeight(); j++) {
                        drawer.drawTileByID(l.getData().get(j).get(i),
                                new Rectangle(new Point2D(i * zoom, j * zoom), new Point2D((i+1) * zoom, (j+1) * zoom)));
                    }
                }
            });
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
