package escapefromuniversity.model.enemy;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.bullet.Bullet;
import escapefromuniversity.model.bullet.BulletFactory;
import escapefromuniversity.model.bullet.BulletFactoryImpl;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.map.Room;

public class BossFactoryImpl implements BossFactory{
	private final BulletFactory bulletCreate = new BulletFactoryImpl();

    
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss1(Point2D position, Vector2D direction, Room room) {
		return new AbstractBoss(BossConstant.boss1_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS1, BossConstant.boss1_life, BossConstant.boss1_shootDelay, BossConstant.boss1_damage, room) {

			@Override
			void shoot() {
				final Point2D startPosition = new Point2D(this.getObjectPosition().getX(), this.getObjectPosition().getY() + this.getObjectHitBox().getHeight());
				final Bullet bullet = bulletCreate.createBoss1Bullet(startPosition, this.getDirection(), room);
				this.getRoom().addDynamicGameObject(bullet);
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss2(Point2D position, Vector2D direction, Room room) {
		return new AbstractBoss(BossConstant.boss2_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS2, BossConstant.boss2_life, BossConstant.boss2_shootDelay, BossConstant.boss2_damage, room) {

			@Override
			void shoot() {
				final List<Bullet> bullets = new LinkedList<>();
				final Point2D startPosition = new Point2D(this.getObjectPosition().getX(), this.getObjectPosition().getY() + this.getObjectHitBox().getHeight());
				bullets.add(bulletCreate.createBoss2Bullet(this.getObjectPosition(), this.getDirection(), room));
				bullets.add(bulletCreate.createBoss2Bullet(startPosition.sum(new Vector2D(10, 10)), this.getDirection(), room));
				bullets.add(bulletCreate.createBoss2Bullet(startPosition.sum(new Vector2D(-10, -10)), this.getDirection(), room));
				bullets.forEach(bul -> {
					this.getRoom().addDynamicGameObject(bul);
				});
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss3(Point2D position, Vector2D direction, Room room) {
		return new AbstractBoss(BossConstant.boss3_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS3, BossConstant.boss3_life, BossConstant.boss3_shootDelay, BossConstant.boss3_damage, room) {

			@Override
			void shoot() {
				final List<Bullet> bullets = new LinkedList<>();
				final Point2D startPosition = new Point2D(this.getObjectPosition().getX(), this.getObjectPosition().getY() + this.getObjectHitBox().getHeight());
				bullets.add(bulletCreate.createBoss3Bullet(startPosition, new Vector2D(0, 1), room));
				bullets.add(bulletCreate.createBoss3Bullet(startPosition, new Vector2D(0, -1), room));
				bullets.add(bulletCreate.createBoss3Bullet(startPosition, new Vector2D(1, 1), room));
				bullets.add(bulletCreate.createBoss3Bullet(startPosition, new Vector2D(-1, 1), room));
				bullets.add(bulletCreate.createBoss3Bullet(startPosition, new Vector2D(1, -1), room));
				bullets.add(bulletCreate.createBoss3Bullet(startPosition, new Vector2D(-1, -1), room));
				bullets.add(bulletCreate.createBoss3Bullet(startPosition, new Vector2D(1, 0), room));
				bullets.add(bulletCreate.createBoss3Bullet(startPosition, new Vector2D(1, 0), room));
				bullets.forEach(bul -> {
					this.getRoom().addDynamicGameObject(bul);
				});
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss4(Point2D position, Vector2D direction, Room room) {
		return new AbstractBoss(BossConstant.boss4_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS4, BossConstant.boss4_life, BossConstant.boss4_shootDelay, BossConstant.boss4_damage, room) {

			@Override
			void shoot() {
				final Point2D startPosition = new Point2D(this.getObjectPosition().getX(), this.getObjectPosition().getY() + this.getObjectHitBox().getHeight());
				final Bullet bullet = bulletCreate.createBoss4Bullet(startPosition, this.getDirection(), room);
				this.getRoom().addDynamicGameObject(bullet);
				
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss5(Point2D position, Vector2D direction, Room room) {
		return new AbstractBoss(BossConstant.boss5_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS5, BossConstant.boss5_life, BossConstant.boss5_shootDelay, BossConstant.boss5_damage, room) {

			@Override
			void shoot() {
				final Point2D startPosition = new Point2D(this.getObjectPosition().getX(), this.getObjectPosition().getY() + this.getObjectHitBox().getHeight());
				final Bullet bullet = bulletCreate.createBoss5Bullet(startPosition, this.getDirection(), room);
				this.getRoom().addDynamicGameObject(bullet);
				
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss6(Point2D position, Vector2D direction, Room room) {
		return new AbstractBoss(BossConstant.boss6_speed, position, BossConstant.BOSS_BOX_SIZE, direction, GameObjectType.BOSS6, BossConstant.boss6_life, BossConstant.boss6_shootDelay, BossConstant.boss6_damage, room) {

			@Override
			void shoot() {
				final Point2D startPosition = new Point2D(this.getObjectPosition().getX(), this.getObjectPosition().getY() + this.getObjectHitBox().getHeight());
				final Bullet bullet = bulletCreate.createBoss6Bullet(startPosition, this.getDirection(), room);
				this.getRoom().addDynamicGameObject(bullet);
				
			}
			
		};
	}

}
