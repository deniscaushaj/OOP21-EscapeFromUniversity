package escapefromuniversity;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainViewController {
    @FXML
    private Canvas gameCanvas;

    @FXML
    private Button myButton;

    @FXML
    public final void myButtonOnClickHandler(final MouseEvent evt) {
        /*final var gc = gameCanvas.getGraphicsContext2D();
        Image image = new Image(getClass().getResourceAsStream("/images/map.png"));
        gc.drawImage(image, 0, 0, 400, 400);*/
        
        /*final var prova = new TMXMapParser(getClass().getResourceAsStream("/map/map2.tmx"));
        try {
            System.out.println(prova.parse());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
