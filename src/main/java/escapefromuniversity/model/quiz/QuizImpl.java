package escapefromuniversity.model.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizImpl implements Quiz {

	private final Question question;
	private final Map<Integer,Answer> anwsers;
	private boolean answered = false;
	
	private QuizImpl(Question question, Map<Integer,Answer> anwsers) {
		this.question = question;
		this.anwsers = anwsers;
	}
	
	@Override
	public int getID() {
		return this.question.getID();
	}
	
	@Override
	public Question getQuestion() {
		return this.question;
	}
	
	@Override
	public Map<Integer,Answer> getAllAnwsers() {
		return this.anwsers;
	}
	
	@Override
	public boolean hasBeenAnswered() {
		return this.answered;
	}
	
	@Override
	public boolean giveAnAnswer(int choice) {
		this.answered = true;
		return this.anwsers.get(choice).isCorrect();
	}
	
	@Override
	public String toString() {
		return "[Quiz n."+ this.getID() + "] " + this.question.toString() + this.getAllAnwsers().toString();
	}
	
	public static class Builder implements QuizBuilder {

		private Question question;
		private Map<Integer,Answer> anwsers = new HashMap<Integer,Answer>();
		
		public Builder(Question question) {
			this.question = question;
		}
		
		@Override
		public QuizBuilder addAnwser(Answer anwser) {
			this.anwsers.put(anwser.getId(), anwser);
			return this;
		}
		
		@Override
		public Quiz build() {
			if(this.question == null){
				throw new IllegalStateException("This quiz does not have a correctly set question");
			}
			if(this.anwsers.size() != 4){
				throw new IllegalStateException("This quiz does not have exactly 4 answers");
			}
			return new QuizImpl(this.question, this.anwsers);
		}

	}
	
}
