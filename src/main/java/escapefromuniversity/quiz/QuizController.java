package escapefromuniversity.quiz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.launcher.LauncherView;
import escapefromuniversity.model.quiz.Exam;
import escapefromuniversity.model.quiz.ExamImporter;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.enemy.Boss.BossState;
import escapefromuniversity.model.quiz.Quiz;
import escapefromuniversity.utilities.LauncherResizer;
import escapefromuniversity.view.map.MapLoader;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * The controller of the quiz exam.
 */
public class QuizController {
	
	@FXML
	private Label profLabel, subjectLabel, creditsLabel, gradeLabel, maxGradeLabel, provaLabel;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Button questionButton, nextButton, uno, due, tre, quattro;
	@FXML
	private HBox answerBox1, answerBox2, backGameBox;
	
	private Exam exam;
	private Quiz currentQuiz;
	private Boss boss;
	private GameController gc;
	
	/**
	 * Constructor.
	 */
	public QuizController(final GameController gc) {
		this.gc = gc;
		this.boss = gc.getModel().getCurrentBoss();
		try {
			this.exam = new ExamImporter(boss.getBossExam()).importExam();
			if (this.exam.hasNextQuiz()) {
				currentQuiz = this.exam.getNextQuiz();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void setParameters(final Boss boss, final Player player) {
//		try {
//			this.exam = new ExamImporter(boss.getBossExam()).importExam();
//			if (this.exam.hasNextQuiz()) {
//				currentQuiz = this.exam.getNextQuiz();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@FXML
	void initialize() {
		creditsLabel.setText("" + this.exam.getCredits());
		gradeLabel.setText("" + this.exam.getGrade());
		maxGradeLabel.setText("" + this.exam.getMaxGrade());
		questionButton.setStyle("-fx-background-image:url('question.png');");
		setDisableToAll(false);
		progressBar.setProgress(this.exam.getProgress());
		questionButton.setTextFill(Color.BLACK);
		profLabel.setText(this.exam.getTeacherName());
		subjectLabel.setText(this.exam.getSubjectName());
		questionButton.setText(this.currentQuiz.getQuestion().getText());
		uno.setText(this.currentQuiz.getAllAnwsers().get(1).getText());
		due.setText(this.currentQuiz.getAllAnwsers().get(2).getText());
		tre.setText(this.currentQuiz.getAllAnwsers().get(3).getText());
		quattro.setText(this.currentQuiz.getAllAnwsers().get(4).getText());
		nextButton.setDisable(true);
	}

	// Event Listener on Button[#nextButton].onAction
	@FXML
	public void next(final ActionEvent event) {
		progressBar.setProgress(this.exam.getProgress());
		if (this.exam.hasNextQuiz()) {
			currentQuiz = this.exam.getNextQuiz();
			this.initialize();
		} else {
			nextButton.setDisable(true);
			answerBox1.setVisible(false);
			answerBox2.setVisible(false);
			backGameBox.setVisible(true);
			if (this.exam.hasPassed()) {
				this.gc.getPlayer().increaseCredits(this.exam.getCredits());
				this.gc.getPlayer().setFinalMark(this.exam.getGrade());
				questionButton.setText("Complimenti, sei stato PROMOSSO!");
				questionButton.setTextFill(Color.DARKGREEN);
				questionButton.setStyle("-fx-background-image:url('questionRight.png');");
				this.gc.getModel().getCurrentBoss().kill();
				this.gc.getGameView().checkID();
				this.gc.setGameState(GameState.PLAY);
			} else {
				questionButton.setText("Noo, sei stato BOCCIATO!");
				questionButton.setTextFill(Color.DARKRED);
				questionButton.setStyle("-fx-background-image:url('questionWrong.png');");
				this.boss.setBossState(BossState.FIGHT);
				this.gc.setGameState(GameState.FIGHT);
			}
		}
	}
	
	// Event Listener on Button[#a].onAction
	@FXML
	public void answer(final ActionEvent event) {	
		try {
			char choce;
			if (event.getSource().equals(uno)) {
	    		answerUpdate(1);
	    	} else if (event.getSource().equals(due)) {	
	    		answerUpdate(2);
	    	} else if (event.getSource().equals(tre)) {
	    		answerUpdate(3);
	    	} else if (event.getSource().equals(quattro)) {
	    		answerUpdate(4);
	    	}
			nextButton.setDisable(false);
			creditsLabel.setText("" + this.exam.getCredits());
			gradeLabel.setText("" + this.exam.getGrade());
			maxGradeLabel.setText("" + this.exam.getMaxGrade());
    	} catch (Exception e) {
    		System.out.println(e);
    	}
	}
	
	@FXML
	public void backToGame(final ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/Game.fxml"));
		loader.setController(this.gc.getGameView());
		Parent gameRoot = loader.load();
		Scene game = new Scene(gameRoot, LauncherResizer.sceneWidth, LauncherResizer.sceneHeight);
		LauncherView.launcherWindow.setScene(game);
	}
	
	private void answerUpdate(final int choice) {
		if (this.currentQuiz.giveAnAnswer(choice)) {
			questionButton.setTextFill(Color.DARKGREEN);
			questionButton.setStyle("-fx-background-image:url('questionRight.png');");
		} else {
			questionButton.setTextFill(Color.DARKRED);
			questionButton.setStyle("-fx-background-image:url('questionWrong.png');");
		}
		setDisableToAll(true);
	}
	
	private void setDisableToAll(final boolean state) {
		uno.setDisable(state);
		due.setDisable(state);
		tre.setDisable(state);
		quattro.setDisable(state);
	}
}
