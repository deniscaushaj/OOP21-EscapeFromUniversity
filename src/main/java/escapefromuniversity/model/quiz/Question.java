package escapefromuniversity.model.quiz;

/**
 * This is the interface of a quiz question.
 *
 */
public interface Question {
	
	/**
	 * 
	 * @return The numeric ID of the question
	 */
	int getID();

	/**
	 * 
	 * @return The actual text of the question
	 */
	String getText();

}
