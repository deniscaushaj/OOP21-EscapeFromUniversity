package escapefromuniversity.model.map;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A class which models a Layer.
 */
public class Layer {

    private final Set<String> properties;
    private final String name;
    private final List<List<Integer>> data;
    private final int width;
    private final int height;

    /**
     * A constructor for the layer.
     * @param properties the list of properties of a layer
     * @param name the name of the layer
     * @param data the list of data of a layer
     */
    public Layer(final Set<String> properties, final String name, final List<List<Integer>> data) {
        this.properties = Collections.unmodifiableSet(properties);
        this.name = name;
        this.data = Collections.unmodifiableList(data);
        this.width = data.get(0).size();
        this.height = data.size();
    }

    /**
     * Returns the list of data of the layer.
     * @return the list of data of the layer.
     */
    public List<List<Integer>> getData() {
        return data;
    }

    /**
     * Returns the properties of the layer.
     * @return the properties of the layer
     */
    public Set<String> getProperties() {
        return this.properties;
    }

    /**
     * Returns the name of the layer.
     * @return the name of the layer.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the width of the layer.
     * @return the width of the layer
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Returns the width of the layer.
     * @return the width of the layer
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns the position of a tile in the map.
     * @param x the row in the map
     * @param y the column in the map
     * @return the position of a tile in the map
     */
    public Tile getTileFromPosition(final int x, final int y) {
        return new Tile(x, y, this.data.get(y).get(x));
    }

    /**
     * Returns the list of the current visible tiles.
     * @return the list of the current visible tiles
     */
    public List<Tile> getVisibleTiles() {
        return IntStream.range(0, this.getHeight())
                .mapToObj(y -> IntStream.range(0, this.getWidth())
                        .mapToObj(x -> this.getTileFromPosition(x, y))
                        .filter(Tile::isVisible))
                .flatMap(Function.identity())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Layer{"
                + "properties=" + properties
                + ", name='" + name + '\''
                + ", data=" + data
                + '}';
    }
}
