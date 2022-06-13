package escapefromuniversity.model.quiz;

import org.json.*;

import escapefromuniversity.model.quiz.CompetitionImpl.Builder;

public class CompetitionImporter {
	
	private final String path;
	
	public CompetitionImporter(final String path) {
		this.path = path;
	}
	
	public CompetitionImpl importCompetition() {
		CompetitionImpl competition;
		Builder competitionBuilder = new Builder();
		
		JSONObject obj = new JSONObject(path);
		
		competitionBuilder.setTeacher(obj.getString("teacher"));
		competitionBuilder.setSubject(obj.getString("subject"));

		JSONArray arr = obj.getJSONArray("quiz");
		
		for (int i = 0; i < arr.length(); i++)
		{
			
		    String post_id = arr.getJSONObject(i).getString("post_id");
		}
	}
	
	
}
