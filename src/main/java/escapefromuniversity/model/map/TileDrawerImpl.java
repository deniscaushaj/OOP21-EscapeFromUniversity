package escapefromuniversity.model.map;

import javafx.util.Pair;

public class TileDrawerImpl implements TileDrawer {

    @Override
    public void drawTileByID(int id, Pair<Integer, Integer> pos) {
        var ts = this.searchTileset(id);
        var tPos = calcTPos(id);
    }

    private Pair<Integer, Integer> calcTPos(int id) {
        int x;
        int y;
        /*
         * Per calcolare la posizione del tile che mi serve devo fare la get delle colonne e delle righe del tileset giusto.
         * In questo modo posso determinare in base all'id la posizione.
         * Es:
         * ID = 50; ROWS = 7; COLS = 25
         * POS = {1, 24}
         * */
        return new Pair<>(0, 0);
    }

    @Override
    public Tileset searchTileset(int id) {
        /*
        * Voglio prendere da MapProperties la lista di Tileset per poter cercare quello che contiene l'id di cui ho bisogno
        * */
        return null;
    }
}
