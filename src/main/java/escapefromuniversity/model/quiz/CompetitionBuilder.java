package escapefromuniversity.model.quiz;

public interface CompetitionBuilder {

	CompetitionBuilder addQuiz(Quiz quiz);

	CompetitionBuilder setTeacher(String teacherName);

	CompetitionBuilder setSubject(String subjectName);

	Competition build();

}