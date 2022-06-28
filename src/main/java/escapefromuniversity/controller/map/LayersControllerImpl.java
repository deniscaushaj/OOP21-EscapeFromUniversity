package escapefromuniversity.controller.map;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.inGame.GameControllerImpl;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.map.Layer;
import escapefromuniversity.model.map.MapProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LayersControllerImpl {

    private final MapProperties map;
    private final Player player;

    public LayersControllerImpl(MapProperties map, Player player) {
        this.map = map;
        this.player = player;
    }

    private boolean isRoom() {
        return this.getProperties(player.getObjectPosition()).contains("room");
    }

    private boolean isCorridor() {
        return this.getProperties(player.getObjectPosition()).contains("corridor");
    }

    private boolean isShop() {
        return this.getProperties(player.getObjectPosition()).contains("shop");
    }

    private Set<String> getProperties(Point2D position) {
        return this.map.getLayers().stream()
                .filter(l -> l.getTileFromPosition((int)position.getX(), (int)position.getY()).isVisible())
                .reduce((first, second) -> second)
                .map(Layer::getProperties)
                .orElse(Set.of());
    }

    public Stream<Layer> getVisibleLayers() {
        final List<String> allowed = new ArrayList<>();
        if (isCorridor()) {
            allowed.add("corridor");
        }
        if (isRoom()) {
            allowed.add("room");
            if (isShop()) {
                var gameCont = new GameControllerImpl();
                gameCont.setGameState(GameState.SHOP_ROOM);
            }
        }
        return this.map.getLayers().stream().filter(l -> allowed.stream().anyMatch(p -> l.getProperties().contains(p)));
    }
}
