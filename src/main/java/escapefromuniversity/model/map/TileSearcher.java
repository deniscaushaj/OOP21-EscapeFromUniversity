package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;

/**
 * An interface for searching a tile.
 */
public interface TileSearcher {

    /**
     * Search the tileset containing the tile with the specified id.
     * @param id the id of the tile
     * @return the tileset containing the tile with the specified id
     */
    Tileset searchTileset(int id);

    /**
     * Calculate the position of a tile in the tileset.
     * @param id the tile ID
     * @param ts the tileset
     * @return the position of the tile in the tileset
     */
    Point2D calcTPos(int id, Tileset ts);
}
