package escapefromuniversity.model.enemy;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import escapefromuniversity.model.bullet.BulletFactory;
import escapefromuniversity.model.bullet.BulletFactoryImpl;
import escapefromuniversity.model.gameObject.GameObjectType;

public class BossFactoryImpl implements BossFactory{
	private final BulletFactory bulletCreate = new BulletFactoryImpl();


	@Override
	public Enemy createBoss1(Point2D position, Vector2D direction) {
		return new BossImpl(BossConstant.boss1_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS1, BossConstant.boss1_life, BossConstant.boss1_shootDelay, BossConstant.boss1_damage) {

			@Override
			void shoot() {
				
				
			}
			
		};
	}

	@Override
	public Enemy createBoss2(Point2D position, Vector2D direction) {
		return new BossImpl(BossConstant.boss2_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS2, BossConstant.boss2_life, BossConstant.boss2_shootDelay, BossConstant.boss2_damage) {

			@Override
			void shoot() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

	@Override
	public Enemy createBoss3(Point2D position, Vector2D direction) {
		return new BossImpl(BossConstant.boss3_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS3, BossConstant.boss3_life, BossConstant.boss3_shootDelay, BossConstant.boss3_damage) {

			@Override
			void shoot() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

	@Override
	public Enemy createBoss4(Point2D position, Vector2D direction) {
		return new BossImpl(BossConstant.boss4_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS4, BossConstant.boss4_life, BossConstant.boss4_shootDelay, BossConstant.boss4_damage) {

			@Override
			void shoot() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

	@Override
	public Enemy createBoss5(Point2D position, Vector2D direction) {
		return new BossImpl(BossConstant.boss5_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS5, BossConstant.boss5_life, BossConstant.boss5_shootDelay, BossConstant.boss5_damage) {

			@Override
			void shoot() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

	@Override
	public Enemy createBoss6(Point2D position, Vector2D direction) {
		return new BossImpl(BossConstant.boss6_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS6, BossConstant.boss6_life, BossConstant.boss6_shootDelay, BossConstant.boss6_damage) {

			@Override
			void shoot() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

}