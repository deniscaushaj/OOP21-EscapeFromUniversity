package escapefromuniversity.model.quiz;

/**
 * A competition is an object with quizzes and related questions and answers.
 *
 */
public interface Competition {

	/**
	 * 
	 * @return The name of the teacher against whom the competition is being held
	 */
	String getTeacherName();

	/**
	 * 
	 * @return The subject matter on which the competition quizzes are based
	 */
	String getSubjectName();

	/**
	 * 
	 * @param state If set to true enables the use of a bonus answer to the quiz
	 */
	void setBonusQuiz(boolean state);
	
	/**
	 * 
	 * @return True if bonus response is available 
	 */
	boolean isBonusAvailable();

	/**
	 * 
	 * @return Next quiz if available
	 */
	Quiz getNextQuiz();

	/**
	 * 
	 * @return True if there are still quizzes to be taken
	 */
	boolean hasNextQuiz();

	/**
	 * 
	 * @return Percentage of completed quizzes out of total
	 */
	double getProgress();
	
	/**
	 * 
	 * @return Score representing quizzes answered correctly
	 */
	int getScore();
	
	/**
	 * 
	 * @return Max score for a competition
	 */
	int getMaxScore();
	
	/**
	 * 
	 * @return The total number of quizzes
	 */
	int getTotal();
	
	/**
	 * 
	 * @return True if the score is greater than 50% of the total quizzes
	 */
	boolean hasPassed();
	
	
}