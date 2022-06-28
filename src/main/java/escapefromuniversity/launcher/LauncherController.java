package escapefromuniversity.launcher;

import escapefromuniversity.menu.MenuController;
import escapefromuniversity.menu.MenuControllerImpl;
import escapefromuniversity.utilities.LauncherResizer;

import escapefromuniversity.utilities.OSFixes;

import java.io.File;
import java.net.URL;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import static escapefromuniversity.utilities.LauncherResizer.sceneWidth;
import static escapefromuniversity.utilities.LauncherResizer.sceneHeight;

/**
 * The controller of the fxml file that displays the launcher window.
 */
public class LauncherController {

    @FXML
    private Button creditsButton, exitButton, leaderboardButton, newGameButton;

    /* Starts the game. */
    @FXML
    void newGame(ActionEvent event) {

    	//MenuController menu = new MenuControllerImpl(null);
    	//menu.startView();
//        GameViewImpl.startGame();

//        GameControllerImpl gameController = new GameControllerImpl();
//        gameController.gameLoop();
//        LauncherView.launcherWindow.close();  //this.creditsButton.getScene().getWindow().hide();
//        Platform.exit();

		try {
			FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/Game.fxml"));
			Parent gameRoot = loader.load();
			Scene game = new Scene(gameRoot, LauncherResizer.sceneWidth, LauncherResizer.sceneHeight);
			LauncherView.launcherWindow.setScene(game);
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    /* Opens the leaderboard scene. */
    @FXML
    void leaderboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Leaderboard.fxml"));
            //URL fileLocation = new File(OSFixes.getLocation("layouts","Leaderboard.fxml")).toURI().toURL();
            //loader.setLocation(fileLocation);
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
            //URL fileLocation = new File(OSFixes.getLocation("layouts","Credits.fxml")).toURI().toURL();
            //loader.setLocation(fileLocation);
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