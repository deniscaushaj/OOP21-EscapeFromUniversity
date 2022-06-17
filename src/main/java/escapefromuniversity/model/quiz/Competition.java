package escapefromuniversity.model.quiz;

public interface Competition {

	String getTeacherName();

	String getSubjectName();

	void setBonusQuiz(boolean state);

	Quiz getNextQuiz();

	boolean hasNextQuiz();

	double getProgress();

}