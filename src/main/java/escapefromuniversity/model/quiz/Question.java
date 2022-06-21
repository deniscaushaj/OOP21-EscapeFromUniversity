package escapefromuniversity.model.quiz;

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