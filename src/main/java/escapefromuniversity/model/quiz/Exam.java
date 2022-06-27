package escapefromuniversity.model.quiz;

/**
 * A exam is an object with quizzes and related questions and answers.
 *
 */
public interface Exam {
	
	/**
	 * 
	 * @return The name of the teacher against whom the exam is being held
	 */
	String getTeacherName();

	/**
	 * 
	 * @return The subject matter on which the exam quizzes are based
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
	int getGrade();
	
	/**
	 * 
	 * @return Max score for a exam
	 */
	int getMaxGrade();
	
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
	
	/**
	 * 
	 * @return	The credits of this Exam.
	 */
	int getCredits();
}
