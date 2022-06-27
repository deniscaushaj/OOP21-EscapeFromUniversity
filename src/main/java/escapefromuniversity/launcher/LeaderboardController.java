package escapefromuniversity.launcher;

import escapefromuniversity.ReadFile;
import escapefromuniversity.utilities.WindowSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.awt.*;
import java.io.IOException;

import static escapefromuniversity.launcher.LauncherView.*;

/**
 * The controller of the fxml file that displays the leaderboard.
 */
public class LeaderboardController {

    @FXML
    private Button backButton;

    @FXML
    private GridPane leaderboard;

    @FXML
    void back(ActionEvent event) {
        launcherWindow.setScene(launcher);
    }

    /**
     * Initializes the leaderboard.
     */
    @FXML
    public void initialize() throws IOException {
        ReadFile reader = new ReadFile("score", "score.txt");
        for(int i=0; i<10; i++) {
            String newLine = reader.newLine();
            if(newLine!=null) {
                Text line = new Text(newLine);
                line.setStyle("-fx-text-fill: black;");
                line.setFont(Font.font("OCR A Extended", 20));
                line.setTextAlignment(TextAlignment.CENTER);
                this.leaderboard.addRow(i, line);
            } else {
                break;
             }
        }
        reader.close();
    }
}
