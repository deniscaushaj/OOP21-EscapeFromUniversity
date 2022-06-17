package escapefromuniversity.quiz;

import static escapefromuniversity.utilities.LauncherResizer.*;

import java.io.File;
import java.net.URL;

import escapefromuniversity.utilities.LauncherResizer;
import escapefromuniversity.utilities.OSFixes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public final class QuizView extends Application{

	static Stage quizWindow;
	static Scene quiz;
	static Pane content;
	
	public final void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		URL fileLocation = new File(OSFixes.getLocation("layouts","Quiz.fxml")).toURI().toURL();
		loader.setLocation(fileLocation);
		Parent startRoot = loader.load();
		LauncherResizer launcherResizer = new LauncherResizer();
		launcherResizer.setSceneSize(screenWidth, screenHeight);
		quiz = new Scene(startRoot, sceneWidth, sceneHeight);
        stage.setTitle("Test Quiz");
        stage.setScene(quiz);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        quizWindow = stage;
	}
	
	public static void startQuizCompetition(final String[] args) {
        launch();
    }
	
}
