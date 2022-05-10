package escapefromuniversity;

public class Tileset {
    private final String fileName;
    private final int tilesCount;
    private final int columns;
    private final int rows;

    public Tileset(final String fileName, int tilesCount, int columns) {
        this.fileName = fileName;
        this.tilesCount = tilesCount;
        this.columns = columns;
        this.rows = tilesCount / columns;
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
}
