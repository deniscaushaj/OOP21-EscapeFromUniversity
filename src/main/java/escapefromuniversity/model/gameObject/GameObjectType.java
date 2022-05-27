package escapefromuniversity.model.gameObject;

import escapefromuniversity.model.GameCollisionType;

public enum GameObjectType {
	PLAYER(GameCollisionType.ENTITY),
	BOSS1(GameCollisionType.ENTITY),
	BOSS2(GameCollisionType.ENTITY),
	BOSS3(GameCollisionType.ENTITY),
	BOSS4(GameCollisionType.ENTITY),
	BOSS5(GameCollisionType.ENTITY),
	BOSS6(GameCollisionType.ENTITY),
	WALL(GameCollisionType.OBSTACLE),
	DOOR(GameCollisionType.OBSTACLE),
	COIN(GameCollisionType.OBSTACLE),
	BULLET_PROTAGINIST(GameCollisionType.BULLET),
	BULLET_BOSS_1(GameCollisionType.BULLET),
	BULLET_BOSS_2(GameCollisionType.BULLET),
	BULLET_BOSS_3(GameCollisionType.BULLET),
	BULLET_BOSS_4(GameCollisionType.BULLET),
	BULLET_BOSS_5(GameCollisionType.BULLET),
	BULLET_BOSS_6(GameCollisionType.BULLET);
	
	private GameCollisionType collisionType;

	GameObjectType(GameCollisionType collisionType) {
		this.setCollisionType(collisionType);
	}

	public GameCollisionType getCollisionType() {
		return collisionType;
	}

	public void setCollisionType(GameCollisionType collisionType) {
		this.collisionType = collisionType;
	}
}
