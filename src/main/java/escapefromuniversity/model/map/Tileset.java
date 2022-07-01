package escapefromuniversity.model.map;

/**
 * A class which models a tileset.
 */
public class Tileset {

    private final String fileName;
    private final int tilesCount;
    private final int columns;
    private final int rows;
    private final int firstTileId;

    /**
     * Constructor for Tileset.
     * @param fileName the name of the file containing the tileset
     * @param tilesCount the number of tiles in the tileset
     * @param columns the number of columns in the tileset
     * @param firstTileId the ID of the first tile
     */
    public Tileset(final String fileName, final int tilesCount, final int columns, final int firstTileId) {
        this.fileName = fileName;
        this.tilesCount = tilesCount;
        this.columns = columns;
        this.rows = tilesCount / columns;
        this.firstTileId = firstTileId;
    }

    /**
     * Returns the name of the file containing the tileset.
     * @return the name of the file containing the tileset
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Returns the number of tiles in the tileset.
     * @return the number of tiles in the tileset
     */
    public int getTilesCount() {
        return this.tilesCount;
    }

    /**
     * Returns the number of columns in the tileset.
     * @return the number of columns in the tileset
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * Returns the number of rows in the tileset.
     * @return the number of rows in the tileset
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Returns the ID of the first tileset.
     * @return the ID of the first tileset
     */
    public int getFirstTileId() {
        return this.firstTileId;
    }

    @Override
    public String toString() {
        return "Tileset{"
                + "fileName='" + fileName + '\''
                + ", tilesCount=" + tilesCount
                + ", columns=" + columns
                + ", rows=" + rows
                + ", firstTileId=" + firstTileId
                + '}';
    }
}
