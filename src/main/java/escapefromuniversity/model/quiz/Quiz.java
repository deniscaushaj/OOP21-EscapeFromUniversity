package escapefromuniversity.model.quiz;

import java.util.Map;
import java.util.Optional;

/**
 * A quiz contains a question and answers.
 */
public interface Quiz {
	
	/**
	 * Get the ID of the quiz.
	 * @return The numeric ID of the question
	 */
	int getID();

	/**
	 * Get the question of the quiz.
	 * @return The question for this quiz
	 */
	Question getQuestion();
	
	/**
	 * Get all answers of the quiz.
	 * @return All answers in this quiz numbered with their ID
	 */
	Map<Integer, Answer> getAllAnwsers();
	
	/**
	 * Check if the quiz has been answered.
	 * @return True if an answer was given by the user
	 */
	boolean hasBeenAnswered();
	
	/**
	 * Check if the quiz has been answered correctly.
	 * @return True if the quiz is answered correctly.
	 */
	Optional<Boolean> hasAnsweredWell();
	
	/**
	 * Try to give an answer to the quiz.
	 * @param choice The numeric ID of the response you want to select
	 * @return True if the selected answer is correct, false otherwise
	 */
	boolean giveAnAnswer(int choice);

}
