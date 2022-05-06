package escapefromuniversity.model.bullect;

import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;

public class BulletFactoryImp implements BulletFactory{
	

	@Override
	public Bullet createProtagonistBullet(Point2D startPosition, Vector2D diraction) {
		return new BulletImp(GameObjectType.BULLET_PROTAGINIST, startPosition,BulletCostant.PROTAGONIST_BULLET_SPEED,
				             diraction, BulletCostant.PROTAGONIST_BULLET_DAMAGE);
	}

	@Override
	public Bullet createBoss1Bullet(Point2D startPosition, Vector2D diraction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_1, startPosition,BulletCostant.BOSS_1_BULLET_SPEED,
	                         diraction, BulletCostant.BOSS_1_BULLET_DAMAGE);
	}

	@Override
	public Bullet createBoss2Bullet(Point2D startPosition, Vector2D diraction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_2, startPosition,BulletCostant.BOSS_2_BULLET_SPEED,
                             diraction, BulletCostant.BOSS_2_BULLET_DAMAGE);
	}

	@Override
	public Bullet createBoss3Bullet(Point2D startPosition, Vector2D diraction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_3, startPosition,BulletCostant.BOSS_3_BULLET_SPEED,
                             diraction, BulletCostant.BOSS_3_BULLET_DAMAGE);
	}

	@Override
	public Bullet createBoss4Bullet(Point2D startPosition, Vector2D diraction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_4, startPosition,BulletCostant.BOSS_4_BULLET_SPEED,
                             diraction, BulletCostant.BOSS_4_BULLET_DAMAGE);
	}

	@Override
	public Bullet createBoss5Bullet(Point2D startPosition, Vector2D diraction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_5, startPosition,BulletCostant.BOSS_5_BULLET_SPEED,
                             diraction, BulletCostant.BOSS_5_BULLET_DAMAGE);
	}

	@Override
	public Bullet createBoss6Bullet(Point2D startPosition, Vector2D diraction) {
		return new BulletImp(GameObjectType.BULLET_BOSS_6, startPosition,BulletCostant.BOSS_6_BULLET_SPEED,
                             diraction, BulletCostant.BOSS_6_BULLET_DAMAGE);
	}

}
