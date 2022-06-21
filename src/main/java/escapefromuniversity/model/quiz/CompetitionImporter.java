package escapefromuniversity.model.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.json.simple.*;
import org.json.simple.parser.*;
import escapefromuniversity.model.quiz.*;
import escapefromuniversity.utilities.OSFixes;

public class CompetitionImporter {
	
	private final String path;
	
	public CompetitionImporter(final String path) {
		this.path = path;
	}
	
	public Competition importCompetition() throws Exception {

		CompetitionBuilder competitionBuilder = new CompetitionImpl.Builder();
	
		final JSONParser parser = new JSONParser();
		final Object obj = parser.parse(new FileReader(OSFixes.getLocation("quiz", path)));
        final JSONObject jsonObject = (JSONObject) obj;

		competitionBuilder.setTeacher(jsonObject.get("teacher").toString());
		competitionBuilder.setSubject(jsonObject.get("subject").toString());

		final JSONArray quizes = (JSONArray) jsonObject.get("quiz");

		for (int i = 0; i < quizes.size(); i++)	{
			JSONObject quiz = (JSONObject) quizes.get(i);
			String question = (String) quiz.get("question");
			Long correct = (Long) quiz.get("correct");
			JSONArray answers = (JSONArray) quiz.get("answers");
			
			QuizBuilder quizBuilder = new QuizImpl.Builder(new QuestionImpl(i+1, quiz.get("question").toString()));
			
			for (int j = 0; j < answers.size(); j++) {
				quizBuilder.addAnwser(new AnswerImpl(j+1, answers.get(j).toString(), (j+1==correct)));
			}
			
			competitionBuilder.addQuiz(quizBuilder.build());
		}
		
		return competitionBuilder.build();
	}
	
}
