package escapefromuniversity.launcher;

import static escapefromuniversity.utilities.LauncherResizer.sceneHeight;
import static escapefromuniversity.utilities.LauncherResizer.sceneWidth;

import escapefromuniversity.inGame.GameControllerImpl;
import escapefromuniversity.inGame.GameViewImpl;
import escapefromuniversity.utilities.LauncherResizer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * The controller of the fxml file that displays the launcher window.
 */
public class LauncherController {

    @FXML
    private Button creditsButton, exitButton, leaderboardButton, newGameButton;

    /* Starts the game. */
    @FXML
    void newGame(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/Game.fxml"));
            var x = new GameViewImpl();
			loader.setController(x);
			Parent gameRoot = loader.load();
			Scene game = new Scene(gameRoot, LauncherResizer.sceneWidth, LauncherResizer.sceneHeight);
			LauncherView.launcherWindow.setScene(game);
            x.drawLayers();
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    /* Opens the leaderboard scene. */
    @FXML
    void leaderboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Leaderboard.fxml"));
            Parent leaderboardRoot = loader.load();
            Scene leaderboard = new Scene(leaderboardRoot, sceneWidth, sceneHeight);
            LauncherView.launcherWindow.setScene(leaderboard);
            LeaderboardController leaderboardController = new LeaderboardController();
            loader.setController(leaderboardController);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* Opens the leaderboard scene.*/
    @FXML
    void credits(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Credits.fxml"));
            Parent creditsRoot = loader.load();
            Scene credits = new Scene(creditsRoot, sceneWidth, sceneHeight);
            LauncherView.launcherWindow.setScene(credits);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* Closes the launcher. */
    @FXML
    void exit(MouseEvent event) {
        Platform.exit();
    }

}