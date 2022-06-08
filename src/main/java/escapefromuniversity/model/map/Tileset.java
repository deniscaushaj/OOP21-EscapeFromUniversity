package escapefromuniversity.model.map;

public class Tileset {
    private final String fileName;
    private final int tilesCount;
    private final int columns;
    private final int rows;
    private final int firstTileId;

    public Tileset(final String fileName, int tilesCount, int columns, int firstTileId) {
        this.fileName = fileName;
        this.tilesCount = tilesCount;
        this.columns = columns;
        this.rows = tilesCount / columns;
        this.firstTileId = firstTileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getTilesCount() {
        return this.tilesCount;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getRows() {
        return this.rows;
    }

    public int getFirstTileId() {
        return this.firstTileId;
    }

    @Override
    public String toString() {
        return "Tileset{" +
                "fileName='" + fileName + '\'' +
                ", tilesCount=" + tilesCount +
                ", columns=" + columns +
                ", rows=" + rows +
                ", firstTileId=" + firstTileId +
                '}';
    }
}
