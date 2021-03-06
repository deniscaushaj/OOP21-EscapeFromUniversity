package escapefromuniversity.model.quiz;

/**
 * AnswerImpl is the implementation of the Answer interface .
 *
 */
public class AnswerImpl implements Answer {
	
	private final int id;
	private final String text;
	private final boolean correct;
	
	/**
	 * 
	 * @param id Response identification number.
	 * @param text Actual text of the response we are representing.
	 * @param correct Set to true if it is a correct answer.
	 */
	public AnswerImpl(final int id, final String text, final boolean correct) {
		this.id = id;
		this.text = text;
		this.correct = correct;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public boolean isCorrect() {
		return correct;
	}
	
	@Override
	public String toString() {
		return "[Answer n." + this.id + "] " + this.text + ", is correct: " + this.correct;
	}

}
