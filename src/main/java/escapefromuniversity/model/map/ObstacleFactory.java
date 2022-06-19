package escapefromuniversity.model.map;

/**
 * A class which models an Obstacle.
 */
public interface ObstacleFactory {

    Obstacle createObstacle();

    Obstacle createWall();
}
