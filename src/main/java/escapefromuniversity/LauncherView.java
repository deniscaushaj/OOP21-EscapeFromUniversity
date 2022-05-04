package escapefromuniversity;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public final class LauncherView extends Application{

	static Stage launcherWindow;
	
	public final void start(Stage stage) throws Exception {
        Parent startRoot = FXMLLoader.load(getClass().getResource("/layouts/Launcher.fxml"));
        Scene launcher = new Scene(startRoot);
        stage.setTitle("Escape From University");
        stage.setScene(launcher);
        stage.setResizable(false);
        stage.centerOnScreen();
        Image logo = new Image(ClassLoader.getSystemResourceAsStream("logo.png")); //file to be changed
        stage.getIcons().add(logo);
        stage.show();
        LauncherView.launcherWindow = stage;
	}
	
	public static void createLauncher(final String[] args) {
        launch();
    }
	
}
