package escapefromuniversity.model.map;

import java.util.List;

/**
 * Class which models a Layer.
 */
public class Layer {

    private final List<String> properties;
    private final String name;
    private final List<List<Integer>> data;

    /**
     * Constructor.
     * @param properties the list of properties of a layer
     * @param name the name of the layer
     * @param data the list of data of a layer
     */
    public Layer(final List<String> properties, final String name, final List<List<Integer>> data) {
        this.properties = properties;
        this.name = name;
        this.data = List.copyOf(data);
    }

    public List<List<Integer>> getData() {
        return List.copyOf(data);
    }

    public List<String> getProperties() {
        return this.properties;
    }

    public String getName() {
        return this.name;
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
