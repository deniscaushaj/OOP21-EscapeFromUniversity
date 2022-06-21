package escapefromuniversity.model.quiz;

import java.util.List;
import java.util.Map;

public interface Quiz {

	/**
	 * 
	 * @return The numeric ID of the question
	 */
	int getID();

	/**
	 * @return The question for this quiz
	 */
	Question getQuestion();
	
	/**
	 * 
	 * @return All answers in this quiz numbered with their ID
	 */
	Map<Integer, Answer> getAllAnwsers();
	
	/**
	 * 
	 * @return True if an answer was given by the user
	 */
	boolean hasBeenAnswered();
	
	/**
	 * 
	 * @return True if the quiz is answered correctly.
	 */
	boolean hasAnsweredWell();
	
	/**
	 * 
	 * @param choice The numeric ID of the response you want to select
	 * @return True if the selected answer is correct, false otherwise
	 */
	boolean giveAnAnswer(int choice);

}