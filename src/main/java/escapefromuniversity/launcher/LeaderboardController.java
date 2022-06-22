package escapefromuniversity.launcher;

import escapefromuniversity.ReadFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.io.IOException;

import static escapefromuniversity.launcher.LauncherView.*;

public class LeaderboardController {

    @FXML
    private Button backButton;

    @FXML
    private GridPane leaderboard;

    @FXML
    void back(ActionEvent event) {
        launcherWindow.setScene(launcher);
    }

    public void createLeaderboard() throws IOException {
        ReadFile reader = new ReadFile("score", "score.txt");
        this.leaderboard = new GridPane();
        for(int i=0; i<10; i++) {
            String newLine = reader.newLine();
            if(newLine!=null) {
                TextField line = new TextField(newLine);
                line.setStyle("-fx-text-fill: black;");
                this.leaderboard.addRow(i, line);
            } else {
                break;
            }
        }
        reader.close();
    }
}
