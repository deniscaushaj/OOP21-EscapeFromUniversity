package escapefromuniversity.model.quiz;

public interface QuizBuilder {

	QuizBuilder addAnwser(Answer anwser);

	Quiz build();

}