package escapefromuniversity;

import java.io.IOException;
import java.net.URISyntaxException;

import escapefromuniversity.model.OSFixes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class CreditsController {
	
	@FXML
    private Button backButton;
	
	@FXML
    private Hyperlink daniel;

    @FXML
    private Hyperlink denis;

    @FXML
    private Hyperlink emanuele;

    @FXML
    private Hyperlink marco;

    @FXML
    private Hyperlink tileset;

    @FXML
    void back(ActionEvent event) {
    	LauncherView.launcherWindow.setScene(LauncherView.launcher);
    }
    
    @FXML
    void openLink(ActionEvent event) throws URISyntaxException, IOException {
    	OSFixes osFixes = new OSFixes();
    	if (event.getSource().equals(daniel)) {
    		osFixes.openUrl("https://github.com/DanielCapannini");
    	} else if (event.getSource().equals(denis)) {
    		osFixes.openUrl("https://github.com/deniscaushaj");
    	} else if (event.getSource().equals(emanuele)) {
    		osFixes.openUrl("https://github.com/brtmnl");
    	} else if (event.getSource().equals(marco)) {
    		osFixes.openUrl("https://github.com/MarcoAntolini");
    	} else if(event.getSource().equals(tileset)) {
    		osFixes.openUrl("https://limezu.itch.io/");
        }
    }

}
