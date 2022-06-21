package escapefromuniversity.model.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompetitionImpl implements Competition {
	
	private final Map<Integer,Quiz> competition;
	private final String teacherName;
	private final String subjectName;
	private int currentQuiz = 0;
	private boolean bonusQuiz = false;
	
	
	private CompetitionImpl(final Map<Integer, Quiz> competition, final String teacherName, final String subjectName) {
		this.competition = competition;
		this.teacherName = teacherName;
		this.subjectName = subjectName;
	}
	
	private int completedQuiz() {
		return (int) this.competition.entrySet().stream().filter(q -> q.getValue().hasBeenAnswered()).count();
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
	public boolean getBonusQuiz() {
		return this.bonusQuiz;
	}
	
	@Override
	public Quiz getNextQuiz() {
		currentQuiz++;
		return this.competition.get(currentQuiz);
	}
	
	@Override
	public boolean hasNextQuiz() {
		return currentQuiz + 1 <= competition.size();
	}
	
	@Override
	public double getProgress() {
		return (float) ((float) (this.completedQuiz()) / competition.size());
	}
	
	@Override
	public int getScore() {
		return (int) this.competition.entrySet().stream().filter(q -> q.getValue().hasBeenAnswered() && q.getValue().hasAnsweredWell()).count();
	}
	
	/**
	 * 
	 *
	 */
	public static class Builder implements CompetitionBuilder {
		private final Map<Integer, Quiz> competition = new HashMap<Integer, Quiz>();;
		private String teacherName;
		private String subjectName;

		@Override
		public CompetitionBuilder addQuiz(final Quiz quiz) {
			if (this.competition.containsKey(quiz.getID())) {
				throw new IllegalStateException("There is already a quiz with id " + quiz.getID() + " in this package");
			} else {
				this.competition.put(quiz.getID(), quiz);
			}
			return this;
		}

		@Override
		public CompetitionBuilder setTeacher(final String teacherName) {
			this.teacherName = teacherName;
			return this;
		}

		@Override
		public CompetitionBuilder setSubject(final String subjectName) {
			this.subjectName = subjectName;
			return this;
		}

		@Override
		public Competition build() {
			if (this.teacherName == null) {
				throw new IllegalStateException("This competition does not have a correctly set teacher");
			}
			if (this.subjectName == null) {
				throw new IllegalStateException("This competition does not have a correctly set subject");
			}
			if (this.competition.size() < 1) {
				throw new IllegalStateException("This competition must have at least one quiz");
			}
			return new CompetitionImpl(this.competition, this.teacherName, this.subjectName);
		}

	}
	
	
	
	
}
