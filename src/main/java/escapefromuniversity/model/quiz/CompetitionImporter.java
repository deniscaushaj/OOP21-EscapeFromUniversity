package escapefromuniversity.model.quiz;

import org.json.*;

import escapefromuniversity.model.quiz.CompetitionImpl.Builder;

public class CompetitionImporter {
	
	private final String path;
	
	public CompetitionImporter(final String path) {
		this.path = path;
	}
	
	public CompetitionImpl importCompetition() {
		
		CompetitionImpl competition = null;
		Builder competitionBuilder = new Builder();
		
		JSONObject obj = new JSONObject(path);
		competitionBuilder.setTeacher(obj.getString("teacher"));
		competitionBuilder.setSubject(obj.getString("subject"));

		JSONArray arr = obj.getJSONArray("quiz");
		
		//Cicle for quiz
		for (int i = 0; i < arr.length(); i++)
		{
		    String question = arr.getJSONObject(i).getString("question");
		    JSONArray answer = arr.getJSONObject(i).getJSONArray("answer");
		    String a = answer.getJSONObject(0).getString("a");
		    String b = answer.getJSONObject(1).getString("b");
		    String c = answer.getJSONObject(2).getString("c");
		    String d = answer.getJSONObject(3).getString("d");
		    String correct = arr.getJSONObject(i).getString("correct");
		}
		
		return competition;
	}
	
	
}
