package escapefromuniversity.model.quiz;

public interface QuizBuilder {

	/**
	 * 
	 * @param anwser One of the four questions you want to add
	 */
	QuizBuilder addAnwser(Answer anwser);

	/**
	 * 
	 * @return The quiz complete with all necessary parts
	 */
	Quiz build();

}