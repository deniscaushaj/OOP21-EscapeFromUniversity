package escapefromuniversity.model.map;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A class which models a Layer.
 */
public class Layer {

    private final List<String> properties;
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
    public Layer(final List<String> properties, final String name, final List<List<Integer>> data) {
        this.properties = properties;
        this.name = name;
        this.data = List.copyOf(data);
        this.width = data.get(0).size();
        this.height = data.size();
    }

    /**
     * Returns the list of data of the layer.
     * @return the list of data of the layer.
     */
    public List<List<Integer>> getData() {
        return List.copyOf(data);
    }

    /**
     * Returns the properties of the layer.
     * @return the properties of the layer
     */
    public List<String> getProperties() {
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

    public List<Tile> getTiles() {
        return IntStream.range(0, this.getHeight())
                .mapToObj(y -> IntStream.range(0, this.getWidth())
                        .mapToObj(x -> new Tile(x, y, this.data.get(y).get(x)))
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
