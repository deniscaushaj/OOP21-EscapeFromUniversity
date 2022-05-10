package escapefromuniversity;

import java.util.List;

public class MapProperties {

    private final int width;
    private final int height;
    private final int tilewidth;
    private final int tileheight;
    private final List<Layer> layers;
    private final List<Tileset> tilesets;

    public MapProperties(final int width, final int height, final int tilewidth, final int tileheight,
                         final List<Layer> layers, final List<Tileset> tilesets) {
        this.width = width;
        this.height = height;
        this.tilewidth = tilewidth;
        this.tileheight = tileheight;
        this.layers = layers;
        this.tilesets = tilesets;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTilewidth() {
        return this.tilewidth;
    }

    public int getTileheight() {
        return this.tileheight;
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public List<Tileset> getTilesets() {
        return this.tilesets;
    }

    @Override
    public String toString() {
        return "MapProperties [width=" + width + ", height=" + height + ", tilewidth=" + tilewidth + ", tileheight="
                + tileheight + ", layers=" + layers + ", tilesets=" + tilesets + "]";
    }
}
