package escapefromuniversity.model.bullet;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import escapefromuniversity.model.gameObject.GameObjectType;

public class BulletFactoryImp implements BulletFactory{
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Bullet createProtagonistBullet(Point2D startPosition, Vector2D direction) {
		return new BulletImp(GameObjectType.BULLET_PLAYER, startPosition,BulletConstant.PLAYER_BULLET_SPEED,
				             direction, BulletConstant.PLAYER_BULLET_DAMAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Bullet createBoss1Bullet(Point2D startPosition, Vector2D direction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_1, startPosition,BulletConstant.BOSS_1_BULLET_SPEED,
	                         direction, BulletConstant.BOSS_1_BULLET_DAMAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Bullet createBoss2Bullet(Point2D startPosition, Vector2D direction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_2, startPosition,BulletConstant.BOSS_2_BULLET_SPEED,
                             direction, BulletConstant.BOSS_2_BULLET_DAMAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Bullet createBoss3Bullet(Point2D startPosition, Vector2D direction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_3, startPosition,BulletConstant.BOSS_3_BULLET_SPEED,
                             direction, BulletConstant.BOSS_3_BULLET_DAMAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Bullet createBoss4Bullet(Point2D startPosition, Vector2D direction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_4, startPosition,BulletConstant.BOSS_4_BULLET_SPEED,
                             direction, BulletConstant.BOSS_4_BULLET_DAMAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Bullet createBoss5Bullet(Point2D startPosition, Vector2D direction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_5, startPosition,BulletConstant.BOSS_5_BULLET_SPEED,
                             direction, BulletConstant.BOSS_5_BULLET_DAMAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Bullet createBoss6Bullet(Point2D startPosition, Vector2D direction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_6, startPosition,BulletConstant.BOSS_6_BULLET_SPEED,
                             direction, BulletConstant.BOSS_6_BULLET_DAMAGE);
	}

}
