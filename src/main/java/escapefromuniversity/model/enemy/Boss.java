package escapefromuniversity.model.enemy;

public interface Boss extends Enemy{
	
	enum BossState{
		QUIZ,
		FIGHT;
	}
	
	int getImpactDamage();
	
	//getQuiz

}
