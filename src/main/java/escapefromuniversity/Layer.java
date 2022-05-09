package escapefromuniversity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer {

    private final List<String> properties;
    private final String name;
    private final List<List<Integer>> data;

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
    
}
