package escapefromuniversity.model.quiz;

/**
 * Interface of an Exam builder.
 * 
 */
public interface ExamBuilder {
	
	/**
	 * 
	 * @param quiz Quiz you want to add to the exam.
	 * @return The builder.
	 */
	ExamBuilder addQuiz(Quiz quiz);

	/**
	 * 
	 * @param teacherName The name of the teacher of the exam.
	 * @return The builder.
	 */
	ExamBuilder setTeacher(String teacherName);

	/**
	 * 
	 * @param subjectName The subject matter on which the exam is focused.
	 * @return The builder.
	 */
	ExamBuilder setSubject(String subjectName);
	
	/**
	 * 
	 * @param credits The credits of this exam.
	 * @return The builder.
	 */
	ExamBuilder setCredits(int credits);

	/**
	 * 
	 * @return The exam object complete with all mandatory parts
	 */
	Exam build();

}
