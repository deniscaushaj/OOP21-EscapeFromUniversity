package escapefromuniversity.model.quiz;

public class AnwserImpl implements Anwser {

	private final char id;
	private final String text;
	private final boolean correct;
	
	public AnwserImpl(char id, String text, boolean correct) {
		this.id = id;
		this.text = text;
		this.correct = correct;
	}

	@Override
	public char getId() {
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
	
	
	
	
}
