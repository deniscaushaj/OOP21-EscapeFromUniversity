package escapefromuniversity.quiz;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import escapefromuniversity.model.quiz.Competition;
import escapefromuniversity.model.quiz.CompetitionImporter;
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
	private Button questionButton, nextButton, a, b, c, d;
	
	public QuizController() {
		try {
			Competition comp = new CompetitionImporter("boss1.json").importCompetition();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#nextButton].onAction
	@FXML
	public void next(ActionEvent event) {
		progressBar.setProgress(progressBar.getProgress()+0.25);
		nextButton.setDisable(true);
	}
	// Event Listener on Button[#a].onAction
	@FXML
	public void answer(ActionEvent event) {	
		try {
			char choce;
			if (event.getSource().equals(a)) {
	    		choce = 'a';
	    	} else if (event.getSource().equals(b)) {	
	    		choce = 'b';
	    	} else if (event.getSource().equals(c)) {
	    		choce = 'c';
	    	} else if (event.getSource().equals(d)) {
	    		choce = 'd';
	    	}
			nextButton.setDisable(false);
			
    	} catch (Exception e) {
    		System.out.println(e);
    	}
	}
	
	public void update() {
		
	}
}
