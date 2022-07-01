package escapefromuniversity.controller.map;

import escapefromuniversity.model.map.Layer;

import java.util.stream.Stream;

/**
 * An interface which controls the layers.
 */
public interface LayersController {

    /**
     * Returns a Stream of the visible layers.
     * @return a Stream of the visible layers
     */
    Stream<Layer> getVisibleLayers();
}
