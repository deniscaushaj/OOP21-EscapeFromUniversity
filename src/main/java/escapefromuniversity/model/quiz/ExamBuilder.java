package escapefromuniversity.model.quiz;

public interface ExamBuilder {

	/**
	 * 
	 * @param quiz Quiz you want to add to the exam
	 */
	ExamBuilder addQuiz(Quiz quiz);

	/**
	 * 
	 * @param teacherName The name of the teacher of the exam
	 */
	ExamBuilder setTeacher(String teacherName);

	/**
	 * 
	 * @param subjectName The subject matter on which the exam is focused
	 */
	ExamBuilder setSubject(String subjectName);

	/**
	 * 
	 * @return The exam object complete with all mandatory parts
	 */
	Exam build();

}