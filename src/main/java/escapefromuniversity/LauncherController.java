package escapefromuniversity;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class LauncherController {
    
	@FXML
    private Button creditsButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button leaderboardButton;

    @FXML
    private Button newGameButton;

    @FXML
    void newGame(ActionEvent event) {
        final var prova = new TMXMapParser("final-map.tmx");
        try {
            System.out.println(prova.parse());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @FXML
    void leaderboard(ActionEvent event) {

    }
    
    @FXML	
    void credits(ActionEvent event) { //creditsButton
    	try {
    		Parent creditsRoot = FXMLLoader.load(getClass().getResource("/layouts/Credits.fxml"));
	        Scene credits = new Scene(creditsRoot);
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