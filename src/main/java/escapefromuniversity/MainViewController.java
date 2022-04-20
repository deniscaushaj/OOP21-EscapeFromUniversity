package escapefromuniversity;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class MainViewController {
    @FXML
    private Canvas gameCanvas;

    @FXML
    private Button myButton;

    @FXML
    public final void myButtonOnClickHandler(final MouseEvent evt) {
        var gc = gameCanvas.getGraphicsContext2D();
        Image image = new Image(getClass().getResourceAsStream("/images/map.png"));
        gc.drawImage(image, 0, 0, 400, 400);
    }
}
