package escapefromuniversity.model.quiz;

/**
 * Interface of an Exam builder.
 * 
 */
public interface QuizBuilder {
	
	/**
	 * Add an answer to the quiz.
	 * @param anwser One of the four questions you want to add.
	 * @return The builder.
	 */
	QuizBuilder addAnwser(Answer anwser);

	/**
	 * 
	 * @return The quiz complete with all necessary parts.
	 */
	Quiz build();

}
