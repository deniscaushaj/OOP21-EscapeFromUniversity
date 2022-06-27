package escapefromuniversity.model.gameObject.enemy;

/**
 * 
 * interface Boss.
 *
 */
public interface Boss extends Enemy {

    /**
     * 
     * enum BossState.
     *
     */
    enum BossState {
        /**
         * 
         */
        QUIZ,
        /**
         * 
         */
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
     * @param state : new state.
     */
    void setBossState(BossState state);

    /**
     * 
     * @param result : result of quiz.
     */
    void setQuizResult(int result);

    /**
     * delete this object.
     */
    void kill();

    /**
     * 
     * @param credits
     */
    void setQuizCredit(int credits);

}
