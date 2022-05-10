package escapefromuniversity;

import escapefromuniversity.model.LauncherResizer;
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
		Parent startRoot = FXMLLoader.load(getClass().getResource("/layouts/Launcher.fxml"));
		LauncherResizer launcherResizer = new LauncherResizer();
		launcherResizer.setSceneSize(LauncherResizer.screenWidth, LauncherResizer.screenHeight);
		launcher = new Scene(startRoot, LauncherResizer.sceneWidth, LauncherResizer.sceneHeight);
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
