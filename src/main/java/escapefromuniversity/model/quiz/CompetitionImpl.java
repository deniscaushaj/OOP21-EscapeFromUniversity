package escapefromuniversity.model.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompetitionImpl {
	
	private final Map<Integer,Quiz> competition;
	private final String name;
	private int currentQuiz = 0;
	
	private CompetitionImpl(Map<Integer,Quiz> competition, String name) {
		this.competition = competition;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Quiz getNextQuiz() {
		currentQuiz++;
		return this.competition.get(currentQuiz);
	}
	
	public boolean hasNextQuiz() {
		return currentQuiz+1 <= competition.size();
	}
	
	public double getProgress() {
		return (float) (competition.size() / currentQuiz) * 100;
	}
	
	public static class Builder {
		private final Map<Integer,Quiz> competition = new HashMap<Integer,Quiz>();;
		private final String name;
		
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder addQuiz(Quiz quiz) {
			if(this.competition.containsKey(quiz.getID())) {
				throw new IllegalStateException("There is already a quiz with id " + quiz.getID() + " in this package");
			} else {
				this.competition.put(quiz.getID(), quiz);
			}
			return this;
		}
		
		public CompetitionImpl build() {
			if(this.name == null) {
				throw new IllegalStateException("This competition does not have a correctly set name");
			}
			if(this.competition.size() < 1) {
				throw new IllegalStateException("This competition must have at least one quiz");
			}
			return new CompetitionImpl(this.competition, this.name);
		}
	}
	
	
}
