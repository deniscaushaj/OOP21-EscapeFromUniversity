import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.enemy.BossFactory;
import escapefromuniversity.model.gameObject.enemy.BossFactoryImpl;
import escapefromuniversity.model.map.MapProperties;
import escapefromuniversity.model.map.TMXMapParser;

public class GameModel2 {

    private static final String MAP_NAME = "final-map.tmx";
    private static final Point2D STARTING_PLAYER_POS = new Point2D(0, 0);
    private static final int PLAYER_SHOOT_DELAY = 500;
    private final MapProperties map;
    private final GameState2 gameState;     //VA NEL GAMECONTROLLER E QUA VA INIZIALIZZATO IL CONTROLLER
    private final Player2 player;
    private final BossFactory bossFactory;

    public GameModel2() {
        this.map = new TMXMapParser(MAP_NAME).parse();
        this.gameState = GameState2.CHILL;
        this.player = new Player2(STARTING_PLAYER_POS, PLAYER_SHOOT_DELAY);
        this.bossFactory = new BossFactoryImpl();
    }

    public MapProperties getMap() {
        return this.map;
    }

    public GameState2 getGameState() {
        return this.gameState;
    }

    public Player2 getPlayer() {
        return this.player;
    }

    public BossFactory getBossFactory() {
        return this.bossFactory;
    }
}
