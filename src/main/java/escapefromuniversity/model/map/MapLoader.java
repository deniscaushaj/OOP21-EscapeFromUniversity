package escapefromuniversity.model.map;
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
        Image image = new Image(getClass().getResourceAsStream("/images/map.png"));
        gc.drawImage(image, 0, 0, 400, 400);
        final var prova = new TMXMapParser("final-map.tmx");
        try {
            System.out.println(prova.parse());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
