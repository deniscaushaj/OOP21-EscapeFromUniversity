package escapefromuniversity.launcher;

import static escapefromuniversity.utilities.LauncherResizer.*;

import escapefromuniversity.utilities.LauncherResizer;
import escapefromuniversity.utilities.OSFixes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public final class LauncherView extends Application{

    public static Stage launcherWindow;
    static Scene launcher;

    /**
     * Loads the launcher fxml file and sets it up.
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {
        OSFixes.createHomeFolder();
        OSFixes.createScoreFile();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Launcher.fxml"));
        //URL fileLocation = new File(OSFixes.getLocation("layouts","Launcher.fxml")).toURI().toURL();
        //loader.setLocation(fileLocation);
        Parent startRoot = loader.load();
        LauncherResizer launcherResizer = new LauncherResizer();
        launcherResizer.setSceneSize(SCREENWIDTH, SCREENHEIGHT);
        launcher = new Scene(startRoot, sceneWidth, sceneHeight);
        stage.setTitle("Escape From University");
        stage.setScene(launcher);
        stage.setResizable(true);
        stage.centerOnScreen();
        Image logo = new Image("file:" + OSFixes.getLocation("images", "logo.png")); // TODO change icon
        stage.getIcons().add(logo);
        stage.show();
        launcherWindow = stage;
    }

    /**
     * Calls the starter method of the launcher view.
     */
    public static void createLauncher() {
        launch();
    }

}
