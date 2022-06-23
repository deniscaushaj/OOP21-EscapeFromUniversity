package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import escapefromuniversity.quiz.QuizView;

/**
 * 
 *
 */
public class TestQuiz {

	@Test
	public void testImport() throws Exception {
	    QuizView.startQuizCompetition();
	}

}
