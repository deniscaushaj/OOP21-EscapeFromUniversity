package escapefromuniversity.model.enemy;

public interface Boss extends Enemy{
	
	enum BossState{
		QUIZ,
		FIGHT;
	}
	
	/**
	 * 
	 * @return damage of collision with boss.
	 */
	int getImpactDamage();
	
	/**
	 * 
	 * @return state of Boss.
	 */
	BossState getState();
	
	/**
	 * 
	 * @param state: new state.
	 */
	void setState(BossState state);

}
