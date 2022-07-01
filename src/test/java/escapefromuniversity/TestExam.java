package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import escapefromuniversity.model.quiz.AnswerImpl;
import escapefromuniversity.model.quiz.ExamBuilder;
import escapefromuniversity.model.quiz.ExamImpl;
import escapefromuniversity.model.quiz.Question;
import escapefromuniversity.model.quiz.QuestionImpl;
import escapefromuniversity.model.quiz.Quiz;
import escapefromuniversity.model.quiz.QuizBuilder;
import escapefromuniversity.model.quiz.QuizImpl;
import escapefromuniversity.quiz.QuizView;

/**
 * 
 *
 */
public class TestExam {
	
	@Test
	public void testAnswerConstraint(){
		QuizBuilder qb = new QuizImpl.Builder(new QuestionImpl(1,"Quale animale ha meno di 4 zampe?"));
	    qb.addAnwser(new AnswerImpl(1, "Cane", false));
	    qb.addAnwser(new AnswerImpl(2, "Gatto", false));
	    qb.addAnwser(new AnswerImpl(3, "Canarino", true));
	    Throwable exception1 = assertThrows(IllegalStateException.class, () -> qb.build());
	    assertEquals("This quiz does not have exactly 4 answers", exception1.getMessage());
	}
	
	@Test
	public void testCorrectConstraint(){
		QuizBuilder qb = new QuizImpl.Builder(new QuestionImpl(1,"Quale animale ha meno di 4 zampe?"));
	    qb.addAnwser(new AnswerImpl(1, "Cane", false));
	    qb.addAnwser(new AnswerImpl(2, "Gatto", true));
	    qb.addAnwser(new AnswerImpl(3, "Canarino", true));
	    qb.addAnwser(new AnswerImpl(4, "Cavallo", true));
	    Throwable exception1 = assertThrows(IllegalStateException.class, () -> qb.build());
	    assertEquals("In each quiz there must be one and only one correct answer", exception1.getMessage());
	}
	
	@Test
	public void testQuestionConstraint(){
		QuizBuilder qb = new QuizImpl.Builder(null);
	    qb.addAnwser(new AnswerImpl(1, "Cane", false));
	    qb.addAnwser(new AnswerImpl(1, "Gatto", false));
	    qb.addAnwser(new AnswerImpl(1, "Canarino", true));
	    qb.addAnwser(new AnswerImpl(1, "Cavallo", false));
	    Throwable exception1 = assertThrows(IllegalStateException.class, () -> qb.build());
	    assertEquals("This quiz does not have a correctly set question", exception1.getMessage());
	}
	
	@Test
	public void testQuizConstraint(){
		ExamBuilder eb = new ExamImpl.Builder();
		eb.setSubject("OOP");
		eb.setTeacher("Viroli");
		eb.setCredits(12);
	    Throwable exception1 = assertThrows(IllegalStateException.class, () -> eb.build());
	    assertEquals("This competition must have at least one quiz", exception1.getMessage());
	}

}
