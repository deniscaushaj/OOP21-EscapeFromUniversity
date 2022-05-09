package escapefromuniversity;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
    	if(event.getSource().equals(daniel)) {
    		Desktop.getDesktop().browse(new URI("https://github.com/DanielCapannini"));
    	} else if(event.getSource().equals(denis)) {
    		Desktop.getDesktop().browse(new URI("https://github.com/deniscaushaj"));
    	} else if(event.getSource().equals(emanuele)) {
    		Desktop.getDesktop().browse(new URI("https://github.com/brtmnl"));
    	} else if(event.getSource().equals(marco)) {
    		Desktop.getDesktop().browse(new URI("https://github.com/MarcoAntolini"));
    	} else if(event.getSource().equals(tileset)) {
            Desktop.getDesktop().browse(new URI("https://limezu.itch.io/"));
        }
    }

}
