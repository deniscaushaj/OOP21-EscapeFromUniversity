package escapefromuniversity.model.enemy;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.map.Room;

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
     * @param room
     * @return Boss of type required
     */
    Boss createBoss1(Point2D position, Vector2D direction, Room room);

    /**
     * 
     * @param position
     * @param direction
     * @param room
     * @return Boss of type required
     */
    Boss createBoss2(Point2D position, Vector2D direction, Room room);

    /**
     * 
     * @param position
     * @param direction
     * @param room
     * @return Boss of type required
     */
    Boss createBoss3(Point2D position, Vector2D direction, Room room);

    /**
     * 
     * @param position
     * @param direction
     * @param room
     * @return Boss of type required
     */
    Boss createBoss4(Point2D position, Vector2D direction, Room room);

    /**
     * 
     * @param position
     * @param direction
     * @param room
     * @return Boss of type required
     */
    Boss createBoss5(Point2D position, Vector2D direction, Room room);

    /**
     * 
     * @param position
     * @param direction
     * @param room
     * @return Boss of type required
     */
    Boss createBoss6(Point2D position, Vector2D direction, Room room);
}
