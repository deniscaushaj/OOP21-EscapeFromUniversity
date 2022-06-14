package escapefromuniversity.launcher;

import escapefromuniversity.game.GameViewImpl;
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

public class LauncherController {
    
    @FXML
    private Button creditsButton, exitButton, leaderboardButton, newGameButton;

    @FXML
    void newGame(ActionEvent event) {
<<<<<<< HEAD:src/main/java/escapefromuniversity/launcher/LauncherController.java
        GameViewImpl.startGame();
        LauncherView.launcherWindow.close();
=======
		try {
			FXMLLoader loader = new FXMLLoader();
			URL fileLocation = new File(OSFixes.getLocation("layouts","Game.fxml")).toURI().toURL();
			loader.setLocation(fileLocation);
			Parent gameRoot = loader.load();
			Scene game = new Scene(gameRoot, LauncherResizer.sceneWidth, LauncherResizer.sceneHeight);
			LauncherView.launcherWindow.setScene(game);
		} catch (Exception e) {
			System.out.println(e);
		}
>>>>>>> Edit LauncherController for testing purposes:src/main/java/escapefromuniversity/LauncherController.java
    }
    
    @FXML
    void leaderboard(ActionEvent event) {

    }
    
    @FXML	
    void credits(ActionEvent event) {
    	try {
    	    FXMLLoader loader = new FXMLLoader();
    	    URL fileLocation = new File(OSFixes.getLocation("layouts","Credits.fxml")).toURI().toURL();
    	    loader.setLocation(fileLocation);
    	    Parent creditsRoot = loader.load();
    	    Scene credits = new Scene(creditsRoot, LauncherResizer.sceneWidth, LauncherResizer.sceneHeight);
    	    LauncherView.launcherWindow.setScene(credits);
    	} catch (Exception e) {
    	    System.out.println(e);
    	}
    }
    
    @FXML
    void exit(MouseEvent event) {
    	Platform.exit();
    }
    
}