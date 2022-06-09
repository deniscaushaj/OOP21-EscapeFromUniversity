package escapefromuniversity;

import escapefromuniversity.model.utilities.LauncherResizer;
import escapefromuniversity.model.utilities.OSFixes;

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
        GameView.startGame();
        LauncherView.launcherWindow.close();
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