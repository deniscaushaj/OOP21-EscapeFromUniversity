package escapefromuniversity.map;

import escapefromuniversity.model.map.Layer;

import java.util.stream.Stream;

public interface LayersController {

    boolean isRoom();

    boolean isCorridor();

    Stream<Layer> getVisibleLayers();
}
