package escapefromuniversity.model.quiz;

public interface Answer {

	/**
	 * 
	 * @return The numeric ID of the answer
	 */
	int getId();

	/**
	 * 
	 * @return The actual text of the response
	 */
	String getText();

	/**
	 * 
	 * @return True if the answer is correct, False otherwise
	 */
	boolean isCorrect();

}