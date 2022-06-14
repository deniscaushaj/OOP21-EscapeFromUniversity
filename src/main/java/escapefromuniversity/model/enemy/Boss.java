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
	BossState getBossState();
	
	/**
	 * 
	 * @param state: new state.
	 */
	void setBossState(BossState state);

}
