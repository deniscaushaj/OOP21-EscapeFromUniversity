package escapefromuniversity.model.quiz;

public interface Competition {

	String getTeacherName();

	String getSubjectName();

	void setBonusQuiz(boolean state);
	
	boolean getBonusQuiz();

	Quiz getNextQuiz();

	boolean hasNextQuiz();

	double getProgress();
	
}