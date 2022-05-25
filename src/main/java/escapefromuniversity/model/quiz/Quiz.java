package escapefromuniversity.model.quiz;

import java.util.List;
import java.util.Map;

public interface Quiz {

	int getID();

	Question getQuestion();

	Map<Character,Anwser> getAllAnwsers();
	
	boolean hasBeenAnswered();
	
	boolean giveAnAnswer(char chose);

}