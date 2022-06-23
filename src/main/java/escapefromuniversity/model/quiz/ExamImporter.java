package escapefromuniversity.model.quiz;

import java.io.FileReader;

import org.json.simple.*;
import org.json.simple.parser.*;
import escapefromuniversity.model.quiz.*;
import escapefromuniversity.utilities.OSFixes;

/**
 * Useful object for creating a exam by importing quizzes from a JSON file.
 *
 */
public class ExamImporter {
	
	private final String path;
	
	/**
	 * 
	 * @param path Path of the JSON file from which to import the exam.
	 */
	public ExamImporter(final String path) {
		this.path = path;
	}
	
	/**
	 * 
	 * @return The exam built by importing the
	 * @throws Exception
	 */
	public Exam importExam() throws Exception {

		final ExamBuilder examBuilder = new ExamImpl.Builder();
	
		final JSONParser parser = new JSONParser();
		final Object obj = parser.parse(new FileReader(OSFixes.getLocation("quiz", path)));
        final JSONObject jsonObject = (JSONObject) obj;

		examBuilder.setTeacher(jsonObject.get("teacher").toString());
		examBuilder.setSubject(jsonObject.get("subject").toString());

		final JSONArray quizes = (JSONArray) jsonObject.get("quiz");

		for (int i = 0; i < quizes.size(); i++)	{
			final JSONObject quiz = (JSONObject) quizes.get(i);
			final Long correct = (Long) quiz.get("correct");
			final JSONArray answers = (JSONArray) quiz.get("answers");
			final QuizBuilder quizBuilder = new QuizImpl.Builder(new QuestionImpl(i + 1, quiz.get("question").toString()));
			for (int j = 0; j < answers.size(); j++) {
				quizBuilder.addAnwser(new AnswerImpl(j + 1, answers.get(j).toString(), j + 1 == correct));
			}
			examBuilder.addQuiz(quizBuilder.build());
		}
		return examBuilder.build();
	}
	
}
