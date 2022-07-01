package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.basics.GameCollisionType;

/**
 * Various types of game objects.
 */
public enum GameObjectType {

    /**
     * This type of game object represents the player main character.
     */
    PLAYER(GameCollisionType.ENTITY),
    /**
     * This type of game object represents an enemy, specifically boss number 1.
     */
    BOSS1(GameCollisionType.ENTITY),
    /**
     * This type of game object represents an enemy, specifically boss number 2.
     */
    BOSS2(GameCollisionType.ENTITY),
    /**
     * This type of game object represents an enemy, specifically boss number 3.
     */
    BOSS3(GameCollisionType.ENTITY),
    /**
     * This type of game object represents an enemy, specifically boss number 4.
     */
    BOSS4(GameCollisionType.ENTITY),
    /**
     * This type of game object represents an enemy, specifically boss number 5.
     */
    BOSS5(GameCollisionType.ENTITY),
    /**
     * This type of game object represents an enemy, specifically boss number 6.
     */
    BOSS6(GameCollisionType.ENTITY),
    /**
     * This type of game object represents a wall.
     */
    WALL(GameCollisionType.OBSTACLE),
    /**
     * This type of game object represents a door.
     */
    DOOR(GameCollisionType.NADA),
    /**
     * This type of game object represents a generic furniture.
     */
    FURNITURE(GameCollisionType.OBSTACLE),
    /**
     * This type of game object represents an NPC.
     */
    NPC(GameCollisionType.OBSTACLE),
    /**
     * This type of game object represents shop.
     */
    SHOP(GameCollisionType.OBSTACLE),
    /**
     * This type of game object represents a bullet, specifically that of the player.
     */
    BULLET_PLAYER(GameCollisionType.BULLET),
    /**
     * This type of game object represents a bullet, specifically that of the boss number 1.
     */
    BULLET_BOSS_1(GameCollisionType.IMMUNE_BULLET),
    /**
     * This type of game object represents a bullet, specifically that of the boss number 2.
     */
    BULLET_BOSS_2(GameCollisionType.BULLET),
    /**
     * This type of game object represents a bullet, specifically that of the boss number 3.
     */
    BULLET_BOSS_3(GameCollisionType.BULLET),
    /**
     * This type of game object represents a bullet, specifically that of the boss number 4.
     */
    BULLET_BOSS_4(GameCollisionType.IMMUNE_BULLET),
    /**
     * This type of game object represents a bullet, specifically that of the boss number 5.
     */
    BULLET_BOSS_5(GameCollisionType.BULLET),
    /**
     * This type of game object represents a bullet, specifically that of the boss number 6.
     */
    BULLET_BOSS_6(GameCollisionType.IMMUNE_BULLET);

    private GameCollisionType collisionType;

    GameObjectType(final GameCollisionType collisionType) {
        this.setCollisionType(collisionType);
    }

    /**
     * Get the type of the collision.
     * @return The type of the collision
     */
    public GameCollisionType getCollisionType() {
        return collisionType;
    }
    /**
     * Set the type of the collision.
     * @param collisionType The type of the collision
     */
    public void setCollisionType(final GameCollisionType collisionType) {
        this.collisionType = collisionType;
    }
}
