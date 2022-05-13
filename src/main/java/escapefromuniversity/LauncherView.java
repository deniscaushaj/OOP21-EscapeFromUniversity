package escapefromuniversity;

import escapefromuniversity.model.LauncherResizer;
import escapefromuniversity.model.OSFixes;

import static escapefromuniversity.model.LauncherResizer.*;
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public final class LauncherView extends Application{

	static Stage launcherWindow;
	static Scene launcher;
	static Pane content;
	
	public final void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		URL fileLocation = new File(OSFixes.getLocation("layouts","Launcher.fxml")).toURI().toURL();
		loader.setLocation(fileLocation);
		Parent startRoot = loader.load();
		LauncherResizer launcherResizer = new LauncherResizer();
		launcherResizer.setSceneSize(screenWidth, screenHeight);
		launcher = new Scene(startRoot, sceneWidth, sceneHeight);
        stage.setTitle("Escape From University");
        stage.setScene(launcher);
        stage.setResizable(false);
        stage.centerOnScreen();
        Image logo = new Image("file:src/main/resources/images/logo.png");
        stage.getIcons().add(logo);
        stage.show();
        launcherWindow = stage;
	}
	
	public static void createLauncher(final String[] args) {
        launch();
    }
	
}
