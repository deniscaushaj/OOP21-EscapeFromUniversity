package escapefromuniversity.model.gameObject.enemy;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.map.Mapp;

/**
 * 
 * interface Factory boss.
 *
 */
public interface BossFactory {

    /**
     * 
     * @param position
     * @param direction
     * @param map
     * @return Boss of type required
     */
    Boss createBoss1(Point2D position, Vector2D direction, Mapp map);

    /**
     * 
     * @param position
     * @param direction
     * @param map
     * @return Boss of type required
     */
    Boss createBoss2(Point2D position, Vector2D direction, Mapp map);

    /**
     * 
     * @param position
     * @param direction
     * @param map
     * @return Boss of type required
     */
    Boss createBoss3(Point2D position, Vector2D direction, Mapp map);

    /**
     * 
     * @param position
     * @param direction
     * @param map
     * @return Boss of type required
     */
    Boss createBoss4(Point2D position, Vector2D direction, Mapp map);

    /**
     * 
     * @param position
     * @param direction
     * @param map
     * @return Boss of type required
     */
    Boss createBoss5(Point2D position, Vector2D direction, Mapp map);

    /**
     * 
     * @param position
     * @param direction
     * @param map
     * @return Boss of type required
     */
    Boss createBoss6(Point2D position, Vector2D direction, Mapp map);
}
