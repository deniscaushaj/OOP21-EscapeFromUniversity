package escapefromuniversity.model.quiz;

public class QuestionImpl implements Question {
	
	private final int id;
	private final String text;
	
	public QuestionImpl(int id, String text) {
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
