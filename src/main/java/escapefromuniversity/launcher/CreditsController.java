package escapefromuniversity.launcher;

import java.io.IOException;
import java.net.URISyntaxException;

import escapefromuniversity.utilities.OSFixes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class CreditsController {
	
    @FXML
    private Button backButton;
	
    @FXML
    private Hyperlink daniel, denis, emanuele, marco, tileset;

    @FXML
    void back(ActionEvent event) {
    	LauncherView.launcherWindow.setScene(LauncherView.launcher);
    }
    
    @FXML
    void openLink(ActionEvent event) throws URISyntaxException, IOException {
    	if (event.getSource().equals(daniel)) {
    	    OSFixes.openUrl("https://github.com/DanielCapannini");
    	} else if (event.getSource().equals(denis)) {
    	    OSFixes.openUrl("https://github.com/deniscaushaj");
    	} else if (event.getSource().equals(emanuele)) {
    	    OSFixes.openUrl("https://github.com/brtmnl");
    	} else if (event.getSource().equals(marco)) {
    	    OSFixes.openUrl("https://github.com/MarcoAntolini");
    	} else if(event.getSource().equals(tileset)) {
    	    OSFixes.openUrl("https://limezu.itch.io/");
        }
    }

}
