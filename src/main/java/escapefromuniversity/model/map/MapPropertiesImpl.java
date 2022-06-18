package escapefromuniversity.model.map;

import java.util.List;

/**
 * Implementation of interface MapProperties.
 */
public class MapPropertiesImpl implements MapProperties {

    private final int width;
    private final int height;
    private final int tileWidth;
    private final int tileHeight;
    private final List<Layer> layers;
    private final List<Tileset> tilesets;

    /**
     * Constructor of MapPropertiesImpl.
     * @param width the width of the map
     * @param height the height of the map
     * @param tileWidth the width of a tile
     * @param tileHeight the height of a tile
     * @param layers the list of layers
     * @param tilesets the list of tilesets
     */
    public MapPropertiesImpl(final int width, final int height, final int tileWidth, final int tileHeight,
                             final List<Layer> layers, final List<Tileset> tilesets) {
        this.width = width;
        this.height = height;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.layers = layers;
        this.tilesets = tilesets;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTileWidth() {
        return this.tileWidth;
    }

    public int getTileHeight() {
        return this.tileHeight;
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public List<Tileset> getTilesets() {
        return this.tilesets;
    }

    @Override
    public String toString() {
        return "MapProperties [width=" + width + ", height=" + height + ", tileWidth=" + tileWidth + ", tileHeight="
                + tileHeight + ", layers=" + layers + ", tilesets=" + tilesets + "]";
    }
}
