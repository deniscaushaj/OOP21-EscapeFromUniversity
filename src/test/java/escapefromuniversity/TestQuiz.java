package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import escapefromuniversity.model.quiz.*;


public class TestQuiz {

	@Test
	public void testImport() throws Exception {
	    CompetitionImpl comp = new CompetitionImporter("boss1.json").importCompetition();
	    while(comp.hasNextQuiz()) {
	    	System.out.println(comp.getNextQuiz());
	    }
	}

}
