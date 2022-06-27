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

/**
 * The view of the quiz exam.
 */
public final class QuizView extends Application{
	
	private static Stage quizWindow;
	private static Scene quiz;
	private static Pane content;
	
	/**
	 * Start method for star the view.
	 * @param stage The stage.
	 */
	public void start(final Stage stage) throws Exception {
		final FXMLLoader loader = new FXMLLoader();
		final URL fileLocation = new File(OSFixes.getLocation("layouts", "Quiz.fxml")).toURI().toURL();
		loader.setLocation(fileLocation);
		loader.setController(new QuizController());
		final Parent startRoot = loader.load();
		final LauncherResizer launcherResizer = new LauncherResizer();
		launcherResizer.setSceneSize(SCREENWIDTH, SCREENHEIGHT);
		quiz = new Scene(startRoot, sceneWidth, sceneHeight);
        stage.setTitle("Exam");
        stage.setScene(quiz);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        quizWindow = stage;
	}
	
	/**
	 * Start the windows.
	 */
	public static void startQuizCompetition() {
        launch();
    }
	
}
