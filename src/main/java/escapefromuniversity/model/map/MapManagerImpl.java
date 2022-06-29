package escapefromuniversity.model.map;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.enemy.BossFactory;
import escapefromuniversity.model.gameObject.enemy.BossFactoryImpl;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.gameObject.player.PlayerImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class MapManagerImpl implements MapManager {
    private final GameModel gameModel;
    private final GameInit gameInit;
    private static final Point2D PLAYER_STARTING_POS = new Point2D(83, 147);
    private static final double PLAYER_SPEED = 0.25;
    private static final int PLAYER_SHOOT_DELAY = 500;
    private static final Point2D BOSS1_STARTING_POS = new Point2D(33, 37);
    private static final Point2D BOSS2_STARTING_POS = new Point2D(33, 67);
    private static final Point2D BOSS3_STARTING_POS = new Point2D(33, 97);
    private static final Point2D BOSS4_STARTING_POS = new Point2D(27, 129);
    private static final Point2D BOSS5_STARTING_POS = new Point2D(148, 125);
    private static final Point2D BOSS6_STARTING_POS = new Point2D(147, 32);

    public MapManagerImpl(GameModel gameModel) {
        this.gameModel = gameModel;
        this.gameInit = this.createGameInit();
    }

    @Override
    public void update(final double deltaTime) {
        this.gameInit.update(deltaTime);
    }

    @Override
    public GameInit getGameInit() {
        return this.gameInit;
    }

    @Override
    public Player getPlayer() {
        return this.gameInit.getPlayer();
    }

    public Point2D getStartingPosition() {
        return new Point2D(PLAYER_STARTING_POS);
    }

    private void loadObstacles(final GameInit gameInit) {
        var factory = new ObstaclesFactory(gameInit.getMap());
        List<ObstacleObject> furniture = factory.getFurnitureList();
        List<ObstacleObject> doors = factory.getDoorList();
        List<ObstacleObject> npc = factory.getNPCList();
        List<ObstacleObject> walls = factory.getWallsList();
        var obs = Stream.of(furniture, doors, npc, walls).flatMap(Collection::stream);
        obs.forEach(gameInit::addStaticGameObject);
    }

    private GameInit createGameInit() {
        //TODO: check vector 2D
        var map = new MapImpl(this);
        Player player = new PlayerImpl(GameObjectType.PLAYER, getStartingPosition(), PLAYER_SPEED, new Vector2D(1, 0), PLAYER_SHOOT_DELAY, map);
        map.addDynamicGameObject(player);
        loadObstacles(map);
        BossFactory bossFactory = new BossFactoryImpl();
        map.addDynamicGameObject(bossFactory.createBoss1(BOSS1_STARTING_POS, new Vector2D(1, 0), map));
        map.addDynamicGameObject(bossFactory.createBoss2(BOSS2_STARTING_POS, new Vector2D(1, 0), map));
        map.addDynamicGameObject(bossFactory.createBoss3(BOSS3_STARTING_POS, new Vector2D(1, 0), map));
        map.addDynamicGameObject(bossFactory.createBoss4(BOSS4_STARTING_POS, new Vector2D(1, 0), map));
        map.addDynamicGameObject(bossFactory.createBoss5(BOSS5_STARTING_POS, new Vector2D(1, 0), map));
        map.addDynamicGameObject(bossFactory.createBoss6(BOSS6_STARTING_POS, new Vector2D(1, 0), map));
        return map;
    }

    @Override
    public void setupQuiz(final Boss boss) {
        this.gameModel.setQuiz(boss);
    }

    @Override
    public void setupShop() {
        this.gameModel.setShop();
    }

}
