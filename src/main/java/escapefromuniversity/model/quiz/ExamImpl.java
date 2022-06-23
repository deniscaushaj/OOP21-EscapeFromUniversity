package escapefromuniversity.model.quiz;

import escapefromuniversity.model.gameObject.player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the Exam interface
 *
 */
public class ExamImpl implements Exam {
	
	private final Map<Integer, Quiz> exam;
	private final String teacherName;
	private final String subjectName;
	private int currentQuiz;
	private boolean bonusQuiz;
	private final static int MAXSCORE = 30;
	private final static int PASSEDSCORE = 18;
	private Player player; // TODO initialize
	
	
	private ExamImpl(final Map<Integer, Quiz> exam, final String teacherName, final String subjectName) {
		this.exam = exam;
		this.teacherName = teacherName;
		this.subjectName = subjectName;
	}
	
	private int completedQuiz() {
		return (int) this.exam.entrySet().stream().filter(q -> q.getValue().hasBeenAnswered()).count();
	}
	
	@Override
	public String getTeacherName() {
		return this.teacherName;
	}
	
	@Override
	public String getSubjectName() {
		return this.subjectName;
	}
	
	@Override
	public void setBonusQuiz(final boolean state) {
		this.bonusQuiz = state;
	}

	@Override
	public boolean isBonusAvailable() {
		return !this.bonusQuiz;
	}
	
	@Override
	public Quiz getNextQuiz() {
		currentQuiz++;
		return this.exam.get(currentQuiz);
	}
	
	@Override
	public boolean hasNextQuiz() {
		return currentQuiz + 1 <= exam.size();
	}
	
	@Override
	public double getProgress() {
		return (float) ((float) (this.completedQuiz()) / exam.size());
	}
	
	@Override
	public int getScore() {
		return (int) this.getMaxScore() / this.getTotal() * (int) this.exam.entrySet().stream().filter(q -> q.getValue().hasBeenAnswered() && q.getValue().hasAnsweredWell().get()).count();
	}
	
	@Override
	public int getMaxScore() {
		return this.MAXSCORE;
	}
	
	@Override
	public int getTotal() {
		return exam.size();
	}
	
	@Override
	public boolean hasPassed() {
		return this.getScore() > this.PASSEDSCORE;
	}
	
	/**
	 * A Builder for an Exam.
	 *
	 */
	public static class Builder implements ExamBuilder {
		private final Map<Integer, Quiz> exam = new HashMap<>();;
		private String teacherName;
		private String subjectName;

		@Override
		public ExamBuilder addQuiz(final Quiz quiz) {
			if (this.exam.containsKey(quiz.getID())) {
				throw new IllegalStateException("There is already a quiz with id " + quiz.getID() + " in this package");
			} else {
				this.exam.put(quiz.getID(), quiz);
			}
			return this;
		}

		@Override
		public ExamBuilder setTeacher(final String teacherName) {
			this.teacherName = teacherName;
			return this;
		}

		@Override
		public ExamBuilder setSubject(final String subjectName) {
			this.subjectName = subjectName;
			return this;
		}

		@Override
		public Exam build() {
			if (this.teacherName == null) {
				throw new IllegalStateException("This competition does not have a correctly set teacher");
			}
			if (this.subjectName == null) {
				throw new IllegalStateException("This competition does not have a correctly set subject");
			}
			if (this.exam.size() < 1) {
				throw new IllegalStateException("This competition must have at least one quiz");
			}
			return new ExamImpl(this.exam, this.teacherName, this.subjectName);
		}

	}

	@Override
	public void addCredits() {
		this.player.setCredits(this.player.getCredits() + this.getScore());
	}
	
	
	
	
}
