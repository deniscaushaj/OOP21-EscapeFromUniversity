package escapefromuniversity.model.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizImpl implements Quiz {

	private final Question question;
	private final Map<Character,Anwser> anwsers;
	private boolean answered = false;
	
	private QuizImpl(Question question, Map<Character,Anwser> anwsers) {
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
	public Map<Character,Anwser> getAllAnwsers() {
		return this.anwsers;
	}
	
	@Override
	public boolean hasBeenAnswered() {
		return this.answered;
	}
	
	@Override
	public boolean giveAnAnswer(char chose) {
		this.answered = true;
		return this.anwsers.get(chose).isCorrect();
		
	}
	
	public static class Builder {

		private Question question;
		private Map<Character,Anwser> anwsers = new HashMap<Character,Anwser>();
		
		public Builder(Question question) {
			this.question = question;
		}
		
		public Builder addAnwser(Anwser anwser) {
			this.anwsers.put(anwser.getId(), anwser);
			return this;
		}
		
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
