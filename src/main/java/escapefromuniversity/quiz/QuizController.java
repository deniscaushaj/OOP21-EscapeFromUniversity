package escapefromuniversity.quiz;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.enemy.Boss;
import escapefromuniversity.model.quiz.Competition;
import escapefromuniversity.model.quiz.CompetitionImporter;
import escapefromuniversity.model.quiz.Quiz;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;

public class QuizController {
	@FXML
	private Label profLabel, subjectLabel;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Button questionButton, nextButton, uno, due, tre, quattro;
	
	private Competition comp;
	private Quiz currentQuiz;
	private Boss boss;
	private GameController gc;
	
	public QuizController() {
		try {
			this.comp = new CompetitionImporter("boss1.json").importCompetition();
			if(this.comp.hasNextQuiz()) {
				currentQuiz = this.comp.getNextQuiz();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setParameters(Boss boss, GameController gc) {
		this.boss = boss;
		this.gc = gc;
		try {
			this.comp = new CompetitionImporter(boss.getType().toString()).importCompetition();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	void initialize(){
		questionButton.setStyle("-fx-background-image:url('question.png');");
		setDisableToAll(false);
		progressBar.setProgress(this.comp.getProgress());
		questionButton.setTextFill(Color.BLACK);
		profLabel.setText(this.comp.getTeacherName());
		subjectLabel.setText(this.comp.getSubjectName());
		questionButton.setText(this.currentQuiz.getQuestion().getText());
		uno.setText(this.currentQuiz.getAllAnwsers().get(1).getText());
		due.setText(this.currentQuiz.getAllAnwsers().get(2).getText());
		tre.setText(this.currentQuiz.getAllAnwsers().get(3).getText());
		quattro.setText(this.currentQuiz.getAllAnwsers().get(4).getText());
		nextButton.setDisable(true);
	}

	// Event Listener on Button[#nextButton].onAction
	@FXML
	public void next(ActionEvent event) {
		if(this.comp.hasNextQuiz()) {
			currentQuiz = this.comp.getNextQuiz();
			this.initialize();
		} else {
			nextButton.setDisable(true);
			questionButton.setText("QUIZ COMPLETATO");
			this.boss.setQuizResult(this.comp.getScore());
		}
		progressBar.setProgress(this.comp.getProgress());
	}
	
	// Event Listener on Button[#a].onAction
	@FXML
	public void answer(ActionEvent event) {	
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
    	} catch (Exception e) {
    		System.out.println(e);
    	}
	}
	
	private void answerUpdate(int choice) {
		if(this.currentQuiz.giveAnAnswer(choice)) {
			questionButton.setTextFill(Color.DARKGREEN);
			questionButton.setStyle("-fx-background-image:url('questionRight.png');");
			correct++;
		} else {
			questionButton.setTextFill(Color.DARKRED);
			questionButton.setStyle("-fx-background-image:url('questionWrong.png');");
		}
		setDisableToAll(true);
	}
	
	private void setDisableToAll(boolean state) {
		uno.setDisable(state);
		due.setDisable(state);
		tre.setDisable(state);
		quattro.setDisable(state);
	}
}
