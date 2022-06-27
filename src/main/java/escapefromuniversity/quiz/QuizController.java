package escapefromuniversity.quiz;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.quiz.Exam;
import escapefromuniversity.model.quiz.ExamImporter;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.enemy.Boss.BossState;
import escapefromuniversity.model.quiz.Quiz;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
	
	private Exam exam;
	private Quiz currentQuiz;
	private Boss boss;
	private GameController gc;
	
	/**
	 * Constructor.
	 */
	public QuizController(final Boss boss) {
		try {
			System.out.println("La varibiale vale: " + path);
			this.exam = new ExamImporter(path).importExam();
			if (this.exam.hasNextQuiz()) {
				currentQuiz = this.exam.getNextQuiz();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
			this.boss.setQuizResult(this.exam.getGrade());
			this.boss.setQuizCredit(this.exam.getCredits());
			if (this.exam.hasPassed()) {
				questionButton.setText("Complimenti, sei stato PROMOSSO!");
				questionButton.setTextFill(Color.DARKGREEN);
				questionButton.setStyle("-fx-background-image:url('questionRight.png');");
				this.boss.kill();
			} else {
				questionButton.setText("Noo, sei stato BOCCIATO!");
				questionButton.setTextFill(Color.DARKRED);
				questionButton.setStyle("-fx-background-image:url('questionWrong.png');");
				this.boss.setBossState(BossState.FIGHT);
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
