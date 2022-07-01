package escapefromuniversity.model.gameObject.player;

import escapefromuniversity.model.gameObject.Direction;
import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.GameInit;

/**
 * The interface of the player, containing all the methods related to its stats, direction and state.
 */
public interface Player extends DynamicGameObject {

    /**
     * Returns the max life of the player.
     * @return the max life of the player.
     */
    int getMaxLife();

    /**
     * Returns the max damage of the player.
     * @return the max damage of the player.
     */
    int getMaxDamage();

    /**
     * Returns the max armor of the player.
     * @return the max armor of the player.
     */
    int getMaxArmor();

    /**
     * Returns the current life of the player.
     * @return the current life of the Player.
     */
    int getLife();

    /**
     * Returns the current credits of the player.
     * @return the current credits of the Player.
     */
    int getCredits();

    /**
     * Returns the current damage of the player.
     * @return the current damage of the player.
     */
    int getDamage();

    /**
     * Returns the current armor of the player.
     * @return the current armor of the player.
     */
    int getArmor();

    /**
     * Returns the final mark of the player.
     * @return the final mark of the player.
     */
    int getFinalMark();

    /**
     * Sets the life of the player.
     * @param life to set for the Player.
     */
    void setLife(int life);

    /**
     * Add some credits to the player.
     * @param credits to add to the Player.
     */
    void increaseCredits(int credits);

    void decreaseCredits(int credits);

    /**
     * Sets the damage of the player.
     * @param damage to set for the player.
     */
    void setDamage(int damage);

    /**
     * Sets the armor of the player.
     * @param armor to set for the player.
     */
    void setArmor(int armor);

    /**
     * Calculates the final mark based on the previous final mark and a new mark.
     * @param newMark the new mark to add the final mark.
     */
    void setFinalMark(int newMark);

    /**
     * Restores the life of the player to full.
     */
    void resetLife();

    /**
     * Increases the damage of the player based on a damage buff.
     * @param damage the damage buff to add to player's damage.
     */
    void setDamageBuff(int damage);

    /**
     * Increases the armor of the player based on an armor buff.
     * @param armor the armor buff to add to player's armor.
     */
    void setArmorBuff(int armor);

    /**
     * Sets the bonus quiz buff.
     * @param state {@code false} if the buff is being used, {@code true} if it's being bought.
     */
    void setBonusQuiz(boolean state);

    /**
     * Checks if the bonus quiz buff is active.
     * @return {@code true} if the player has the quiz bonus, {@code false} otherwise.
     */
    boolean hasBonusQuiz();

    /**
     * Decreases player's life based on some damage taken.
     * @param damage to inflict to the player's life.
     */
    void takeDamage(int damage);

    /**
     * Checks if the player can shoot (if its shoot delay time has already elapsed).
     * @return {@code true} if the player can shoot, {@code false} otherwise.
     */
    boolean canShoot(double deltaTime);

    /**
     * Sets a shot with its direction.
     * @param shooting {@code true} if the player is shooting.
     * @param direction the direction of the shot.
     */
    void setShoot(boolean shooting, Direction direction);

    /**
     * Makes the player shoot.
     */
    void shoot();

    /**
     * Saves the last direction of the player.
     * @param direction the direction to save.
     */
    void setLastDirection(Direction direction);

    /**
     * Returns the last direction of the player.
     * @return the last direction of the player.
     */
    Direction getLastDirection();

    /**
     * Increments the number of passed exams.
     */
    void passedExam();

    /**
     * @return {@code true} if the player is dead.
     */
    boolean isDead();

    /**
     * @return {@code true} if the player is graduated.
     */
    boolean isGraduated();

    /**
     * 
     * @param map : new map.
     */
    void setMap(GameInit map);


}
