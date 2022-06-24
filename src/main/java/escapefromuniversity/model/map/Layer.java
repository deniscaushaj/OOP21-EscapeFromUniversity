package escapefromuniversity.model.map;

import java.util.List;

/**
 * A class which models a Layer.
 */
public class Layer {

    private final List<String> properties;
    private final String name;
    private final List<List<Integer>> data;
    private final int width;

    /**
     * A constructor for the layer.
     * @param properties the list of properties of a layer
     * @param name the name of the layer
     * @param data the list of data of a layer
     * @param width the width of the layer
     */
    public Layer(final List<String> properties, final String name, final List<List<Integer>> data, final int width) {
        this.properties = properties;
        this.name = name;
        this.data = List.copyOf(data);
        this.width = width;
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

    @Override
    public String toString() {
        return "Layer{"
                + "properties=" + properties
                + ", name='" + name + '\''
                + ", data=" + data
                + '}';
    }
}
