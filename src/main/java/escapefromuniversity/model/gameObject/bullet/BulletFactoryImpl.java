package escapefromuniversity.model.gameObject.bullet;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.map.Room;

/**
 * 
 * class BulletFactoryImpl implement interface BulletFactory.
 *
 */
public class BulletFactoryImpl implements BulletFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Bullet createPlayerBullet(final Point2D startPosition, final Vector2D direction, final int damage, final Room room) {
        return new BulletImpl(GameObjectType.BULLET_PLAYER, startPosition, BulletConstant.PLAYER_BULLET_SPEED,
                              direction, damage, room);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bullet createBoss1Bullet(final Point2D startPosition, final Vector2D direction, final Room room) {
        return new BulletImpl(GameObjectType.BULLET_BOSS_1, startPosition, BulletConstant.BOSS_1_BULLET_SPEED,
                             direction, BulletConstant.BOSS_1_BULLET_DAMAGE, room);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bullet createBoss2Bullet(final Point2D startPosition, final Vector2D direction, final Room room) {
        return new BulletImpl(GameObjectType.BULLET_BOSS_2, startPosition, BulletConstant.BOSS_2_BULLET_SPEED,
                             direction, BulletConstant.BOSS_2_BULLET_DAMAGE, room);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bullet createBoss3Bullet(final Point2D startPosition, final Vector2D direction, final Room room) {
        return new BulletImpl(GameObjectType.BULLET_BOSS_3, startPosition, BulletConstant.BOSS_3_BULLET_SPEED,
                             direction, BulletConstant.BOSS_3_BULLET_DAMAGE, room);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bullet createBoss4Bullet(final Point2D startPosition, final Vector2D direction, final Room room) {
        return new BulletImpl(GameObjectType.BULLET_BOSS_4, startPosition, BulletConstant.BOSS_4_BULLET_SPEED,
                             direction, BulletConstant.BOSS_4_BULLET_DAMAGE, room);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bullet createBoss5Bullet(final Point2D startPosition, final Vector2D direction, final Room room) {
        return new BulletImpl(GameObjectType.BULLET_BOSS_5, startPosition, BulletConstant.BOSS_5_BULLET_SPEED,
                             direction, BulletConstant.BOSS_5_BULLET_DAMAGE, room);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bullet createBoss6Bullet(final Point2D startPosition, final Vector2D direction, final Room room) {
        return new BulletImpl(GameObjectType.BULLET_BOSS_6, startPosition, BulletConstant.BOSS_6_BULLET_SPEED,
                             direction, BulletConstant.BOSS_6_BULLET_DAMAGE, room);
    }

}
