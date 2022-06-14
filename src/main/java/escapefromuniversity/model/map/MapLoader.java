package escapefromuniversity.model.map;
import escapefromuniversity.model.basics.Point2D;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
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
    public final void myButtonOnClickHandler(final MouseEvent evt) {
        final var gc = gameCanvas.getGraphicsContext2D();
        //Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        //gc.drawImage(image, 0, 0, 400, 400);
        final var parser = new TMXMapParser("final-map.tmx");
        try {
            var map = parser.parse();
            var drawer = new TileDrawerImpl(map, new CanvasDrawerImpl(gc));

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
