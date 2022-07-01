package escapefromuniversity.controller.map;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.inGame.GameControllerImpl;
import escapefromuniversity.model.GameState;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.player.Player;
import escapefromuniversity.model.map.Layer;
import escapefromuniversity.model.map.MapProperties;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class which implements LayersController.
 */
public class LayersControllerImpl implements LayersController {

    private final MapProperties map;
    private final Player player;

    /**
     * A constructor for LayersControllerImpl.
     * @param map the map properties.
     * @param player the player.
     */
    public LayersControllerImpl(final MapProperties map, final Player player) {
        this.map = map;
        this.player = player;
    }

    private boolean isRoom() {
        return this.getProperties(player.getObjectPosition()).contains("room");
    }

    private boolean isCorridor() {
        return this.getProperties(player.getObjectPosition()).contains("corridor");
    }

    /**
     * Returns true if the player is standing over a tile of the shop, false otherwise.
     * @return true if the player is standing over a tile of the shop, false otherwise.
     */
    public boolean isShop() {
        return this.getProperties(player.getObjectPosition()).contains("shop");
    }

    private Set<String> getProperties(final Point2D position) {
        return this.map.getLayers().stream()
                .filter(l -> l.getTileFromPosition((int) position.getX(), (int) position.getY()).isVisible())
                .reduce((first, second) -> second)
                .map(Layer::getProperties)
                .orElse(Set.of());
    }

    @Override
    public Stream<Layer> getVisibleLayers() {
        final List<String> allowed = new ArrayList<>();
        if (isCorridor()) {
            allowed.add("corridor");
        }
        if (isRoom()) {
            allowed.add("room");
        }
        return this.map.getLayers().stream().filter(l -> allowed.stream().anyMatch(p -> l.getProperties().contains(p)));
    }
}
