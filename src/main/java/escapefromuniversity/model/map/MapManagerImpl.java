package escapefromuniversity.model.map;

import escapefromuniversity.model.GameModel;
import escapefromuniversity.model.gameObject.enemy.Boss;
import escapefromuniversity.model.gameObject.player.Player;

import java.util.Map;

public class MapManagerImpl implements MapManager {
    private final Map<Door,Door> doors;
    private final GameModel gameModel;
    private final Mapp map;

    public MapManagerImpl(GameModel gameModel) {
        this.gameModel = gameModel;
        this.doors = this.createDoors();
        this.map = this.createMap();
    }

    @Override
    public void update(final double deltaTime) {
        this.map.update(deltaTime);
    }

    @Override
    public Mapp getMap() {
        return this.map;
    }

    @Override
    public Player getPlayer() {
        return this.map.getPlayer();
    }

    private Mapp createMap() {
        return null;

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
