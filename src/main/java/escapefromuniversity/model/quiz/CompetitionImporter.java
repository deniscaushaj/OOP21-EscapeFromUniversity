package escapefromuniversity.model.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import escapefromuniversity.model.quiz.*;
import escapefromuniversity.utilities.OSFixes;

public class CompetitionImporter {
	
	private final String path;
	
	public CompetitionImporter(final String path) {
		this.path = path;
	}
	
	public CompetitionImpl importCompetition() throws Exception {

		CompetitionImpl.Builder competitionBuilder = new CompetitionImpl.Builder();
	
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(OSFixes.getLocation("quiz",path)));
        JSONObject jsonObject = (JSONObject)obj;
        
		competitionBuilder.setTeacher(jsonObject.get("teacher").toString());
		competitionBuilder.setSubject(jsonObject.get("subject").toString());
		
		JSONArray quizes = (JSONArray) jsonObject.get("quiz");
		

		for (int i = 0; i < quizes.size(); i++)	{
			JSONObject quiz = (JSONObject) quizes.get(i);
			String question = (String) quiz.get("question");
			String correct = (String) quiz.get("correct");
			JSONArray answers = (JSONArray) quiz.get("answers");
			
			QuizImpl.Builder quizBuilder = new QuizImpl.Builder(new QuestionImpl(i+1, quiz.get("question").toString()));
			
			for (int j = 0; j < answers.size(); j++) {
				quizBuilder.addAnwser(new AnswerImpl(j+1, answers.get(j).toString(), (correct.equals(answers.get(i).toString()))));
			}
			
			competitionBuilder.addQuiz(quizBuilder.build());
		}
		
		return competitionBuilder.build();
	}
	
}
