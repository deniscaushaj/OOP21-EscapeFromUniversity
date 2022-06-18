package escapefromuniversity.model.map;

import java.util.List;

/**
 * An interface which models the map's properties.
 */
public interface MapProperties {

    /**
     * Returns the width of the map.
     * @return the width
     */
    int getWidth();
    /**
     * Returns the height of the map.
     * @return the height
     */
    int getHeight();
    /**
     * Returns the width of a tile.
     * @return the tile width
     */
    int getTileWidth();
    /**
     * Returns the height of a tile.
     * @return the tile height
     */
    int getTileHeight();
    /**
     * Returns the list of layers of the map.
     * @return a list of layers
     */
    List<Layer> getLayers();
    /**
     * Returns the list of tilesets used to create the map.
     * @return the list of tilesets
     */
    List<Tileset> getTilesets();
    @Override
    String toString();
}
