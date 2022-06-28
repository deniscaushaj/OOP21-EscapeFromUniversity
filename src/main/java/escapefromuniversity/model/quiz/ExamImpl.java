package escapefromuniversity.model.quiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the Exam interface.
 *
 */
public final class ExamImpl implements Exam {
	
	private final Map<Integer, Quiz> exam;
	private final String teacherName;
	private final String subjectName;
	private final int credits;
	private int currentQuiz;
	private static final  int MAXSCORE = 30;
	private static final int PASSEDSCORE = 18;	
	
	private ExamImpl(final Map<Integer, Quiz> exam, final String teacherName, final String subjectName, final int credits) {
		this.exam = exam;
		this.teacherName = teacherName;
		this.subjectName = subjectName;
		this.credits = credits;
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
	public int getGrade() {
		return (int) this.getMaxGrade() / this.getTotal() * (int) this.exam.entrySet().stream().filter(q -> q.getValue().hasBeenAnswered() && q.getValue().hasAnsweredWell().get()).count();
	}
	
	@Override
	public int getMaxGrade() {
		return MAXSCORE;
	}
	
	@Override
	public int getTotal() {
		return exam.size();
	}
	
	@Override
	public int getCredits() {
		return this.credits;
	}
	
	@Override
	public boolean hasPassed() {
		return this.getGrade() >= PASSEDSCORE;
	}
	
	/**
	 * A Builder for an Exam.
	 *
	 */
	public static class Builder implements ExamBuilder {
		private final Map<Integer, Quiz> exam = new HashMap<>();
		private int credits;
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
		public ExamBuilder setCredits(final int credits) {
			this.credits = credits;
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
			if (this.credits == 0) {
				throw new IllegalStateException("This competition does not have a correctly set credits");
			}
			if (this.subjectName == null) {
				throw new IllegalStateException("This competition does not have a correctly set subject");
			}
			if (this.exam.size() < 1) {
				throw new IllegalStateException("This competition must have at least one quiz");
			}
			return new ExamImpl(this.exam, this.teacherName, this.subjectName, credits);
		}

	}
	
}
