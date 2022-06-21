package escapefromuniversity.model.quiz;

public interface CompetitionBuilder {

	/**
	 * 
	 * @param quiz Quiz you want to add to the competition
	 */
	CompetitionBuilder addQuiz(Quiz quiz);

	/**
	 * 
	 * @param teacherName The name of the teacher of the competition
	 */
	CompetitionBuilder setTeacher(String teacherName);

	/**
	 * 
	 * @param subjectName The subject matter on which the competition is focused
	 */
	CompetitionBuilder setSubject(String subjectName);

	/**
	 * 
	 * @return The Competition object complete with all mandatory parts
	 */
	Competition build();

}