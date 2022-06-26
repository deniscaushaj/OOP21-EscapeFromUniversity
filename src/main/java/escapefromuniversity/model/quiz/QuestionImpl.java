package escapefromuniversity.model.quiz;

/**
 * QuestionImpl is the implementation of the Question interface .
 *
 */
public class QuestionImpl implements Question {
	
	private final int id;
	private final String text;
	
	/**
	 * 
	 * @param id The numeric ID of the question.
	 * @param text The actual text of the question.
	 */ 
	public QuestionImpl(final int id, final String text) {
		this.id = id;
		this.text = text;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return "[Question n." + this.id + "] " + this.text;
	}
	
	
}
