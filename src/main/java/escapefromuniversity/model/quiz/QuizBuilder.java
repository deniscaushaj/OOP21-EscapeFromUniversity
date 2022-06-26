package escapefromuniversity.model.quiz;

/**
 * Interface of a Quiz builder.
 *
 */
public interface QuizBuilder {
	
	/**
	 * 
	 * @param anwser One of the four questions you want to add
	 * @return The builder.
	 */
	QuizBuilder addAnwser(Answer anwser);

	/**
	 * 
	 * @return The quiz complete with all necessary parts
	 */
	Quiz build();

}
