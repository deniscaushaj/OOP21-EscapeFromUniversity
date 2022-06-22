package escapefromuniversity.model.quiz;

import java.io.FileReader;

import org.json.simple.*;
import org.json.simple.parser.*;
import escapefromuniversity.model.quiz.*;
import escapefromuniversity.utilities.OSFixes;

/**
 * Useful object for creating a Competition by importing quizzes from a JSON file.
 *
 */
public class CompetitionImporter {
	
	private final String path;
	
	/**
	 * 
	 * @param path Path of the JSON file from which to import the competition.
	 */
	public CompetitionImporter(final String path) {
		this.path = path;
	}
	
	/**
	 * 
	 * @return The competition built by importing the
	 * @throws Exception
	 */
	public Competition importCompetition() throws Exception {

		final CompetitionBuilder competitionBuilder = new CompetitionImpl.Builder();
	
		final JSONParser parser = new JSONParser();
		final Object obj = parser.parse(new FileReader(OSFixes.getLocation("quiz", path)));
        final JSONObject jsonObject = (JSONObject) obj;

		competitionBuilder.setTeacher(jsonObject.get("teacher").toString());
		competitionBuilder.setSubject(jsonObject.get("subject").toString());

		final JSONArray quizes = (JSONArray) jsonObject.get("quiz");

		for (int i = 0; i < quizes.size(); i++)	{
			final JSONObject quiz = (JSONObject) quizes.get(i);
			final Long correct = (Long) quiz.get("correct");
			final JSONArray answers = (JSONArray) quiz.get("answers");
			final QuizBuilder quizBuilder = new QuizImpl.Builder(new QuestionImpl(i + 1, quiz.get("question").toString()));
			for (int j = 0; j < answers.size(); j++) {
				quizBuilder.addAnwser(new AnswerImpl(j + 1, answers.get(j).toString(), j + 1 == correct));
			}
			competitionBuilder.addQuiz(quizBuilder.build());
		}
		return competitionBuilder.build();
	}
	
}
