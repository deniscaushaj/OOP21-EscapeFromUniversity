package escapefromuniversity.model.map;

import escapefromuniversity.model.GameInit;
import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.gameObject.player.PlayerImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapManagerImpl implements MapManager {
    private final Map<Door,Door> doors;
    private final GameModel gameModel;
    private GameInit map;
    private static final Point2D STARTING_POS = new Point2D(83, 147);
    private static final double PLAYER_SPEED = 0.25;
    private static final int PLAYER_SHOOT_DELAY = 500 ;

    public MapManagerImpl(GameModel gameModel) throws ParserConfigurationException, IOException, SAXException {
        this.gameModel = gameModel;
        this.doors = this.createDoors();
        this.map = this.createMap();
    }

    @Override
    public void update(final double deltaTime) {
        this.map.update(deltaTime);
    }

    @Override
    public GameInit getMap() {
        return this.map;
    }

    @Override
    public Player getPlayer() {
        return this.map.getPlayer();
    }

    public Point2D getStartingPosition() {
        return new Point2D(STARTING_POS);
    }

    private void loadObject() throws ParserConfigurationException, IOException, SAXException {
        List<ObstacleObject> furniture = new ObstacleImpl().getFurnitureList();
        List<ObstacleObject> doors = new ObstacleImpl().getDoorList();
        List<ObstacleObject> npc = new ObstacleImpl().getNPCList();
        List<ObstacleObject> walls = new ObstacleImpl().getWallsList();
        var obs = Stream.of(furniture, doors, npc, walls).flatMap(Collection::stream);
        obs.forEach(o -> {
            this.map.addStaticGameObject(o);
        });
    }

    private GameInit createMap() throws ParserConfigurationException, IOException, SAXException {
        Player player = new PlayerImpl(GameObjectType.PLAYER, getStartingPosition(), PLAYER_SPEED, null, PLAYER_SHOOT_DELAY, this.map);
        loadObject();
        return new MapImpl(this);
    }

    private Map<Door, Door> createDoors() {
        return null;
    }

    @Override
    public void setupQuiz(Boss boss) {
        this.gameModel.setQuiz(boss);
    }

    @Override
    public void setCurrentRoom(Door door) {
        //this.map.getPlayer().setMap(door.getMap());
        this.map = doors.get(door).getMap();
        this.map.getPlayer().setPosition(doors.get(door).getPos());
    }

    @Override
    public void setupShop() {
        this.gameModel.setShop();
    }

}
