package escapefromuniversity.model.quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * QuizImpl is the implementation of the Quiz interface .
 *
 */
public class QuizImpl implements Quiz {

	private final Question question;
	private final Map<Integer, Answer> anwsers;
	private boolean answered;
	private Optional<Boolean> correct;

	private QuizImpl(final Question question, final Map<Integer, Answer> anwsers) {
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
	public Map<Integer, Answer> getAllAnwsers() {
		return this.anwsers;
	}

	@Override
	public boolean hasBeenAnswered() {
		return this.answered;
	}

	@Override
	public boolean giveAnAnswer(final int choice) {
		this.answered = true;
		this.correct = Optional.of(this.anwsers.get(choice).isCorrect());
		return this.correct.get();
	}

	@Override
	public String toString() {
		return "[Quiz n." + this.getID() + "] " + this.question.toString() + this.getAllAnwsers().toString();
	}

	@Override
	public Optional<Boolean> hasAnsweredWell() {
		return this.correct;
	}

	/**
	 * 
	 *
	 */
	public static class Builder implements QuizBuilder {

		private Question question;
		private Map<Integer, Answer> anwsers = new HashMap<Integer, Answer>();

		public Builder(final Question question) {
			this.question = question;
		}

		@Override
		public QuizBuilder addAnwser(final Answer anwser) {
			this.anwsers.put(anwser.getId(), anwser);
			return this;
		}

		@Override
		public Quiz build() {
			if (this.question == null) {
				throw new IllegalStateException("This quiz does not have a correctly set question");
			}
			if(this.anwsers.values().stream().filter(ans -> ans.isCorrect()).count() != 1) {
				throw new IllegalStateException("In each quiz there must be one and only one correct answer");
			}
			if (this.anwsers.size() != 4) {
				throw new IllegalStateException("This quiz does not have exactly 4 answers");
			}
			return new QuizImpl(this.question, this.anwsers);
		}

	}

}
