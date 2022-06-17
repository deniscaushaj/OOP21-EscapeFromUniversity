package escapefromuniversity.model.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompetitionImpl {
	
	private final Map<Integer,Quiz> competition;
	private final String teacherName;
	private final String subjectName;
	private int currentQuiz = 0;
	
	private CompetitionImpl(Map<Integer,Quiz> competition, String teacherName, String subjectName) {
		this.competition = competition;
		this.teacherName = teacherName;
		this.subjectName = subjectName;
	}   
	
	public String getTeacherName() {
		return this.teacherName;
	}
	
	public String getSubjectName() {
		return this.subjectName;
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
		private String teacherName;
		private String subjectName;
		
		public Builder addQuiz(final Quiz quiz) {
			if(this.competition.containsKey(quiz.getID())) {
				throw new IllegalStateException("There is already a quiz with id " + quiz.getID() + " in this package");
			} else {
				this.competition.put(quiz.getID(), quiz);
			}
			return this;
		}
		
		public Builder setTeacher(final String teacherName) {
			this.teacherName = teacherName;
			return this;
		}
		
		public Builder setSubject(final String subjectName) {
			this.subjectName = subjectName;
			return this;
		}
		
		public CompetitionImpl build() {
			if(this.teacherName == null) {
				throw new IllegalStateException("This competition does not have a correctly set teacher");
			}
			if(this.subjectName == null) {
				throw new IllegalStateException("This competition does not have a correctly set subject");
			}
			if(this.competition.size() < 1) {
				throw new IllegalStateException("This competition must have at least one quiz");
			}
			return new CompetitionImpl(this.competition, this.teacherName, this.subjectName);
		}

		
	}
	
	
}
