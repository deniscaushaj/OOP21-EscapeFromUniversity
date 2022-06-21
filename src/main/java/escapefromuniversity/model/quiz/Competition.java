package escapefromuniversity.model.quiz;

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
	boolean getBonusQuiz();

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
	
}