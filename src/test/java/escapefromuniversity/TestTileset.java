package escapefromuniversity;

import escapefromuniversity.model.map.*;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class TestTileset {

    MapProperties mapProp;

    public TestTileset() throws ParserConfigurationException, IOException, SAXException {
        this.mapProp = new TMXMapParser("final-map.tmx").parse();
    }

    @Test
    public void testTilesetName() {
        List<String> tilesetNames = mapProp.getTilesets().stream().map(Tileset::getFileName).collect(Collectors.toList());
        assertTrue(tilesetNames.contains("tilesets/Characters_MV.png"));
        assertTrue(tilesetNames.contains("tilesets/grass.png"));
        assertTrue(tilesetNames.contains("tilesets/Room_Builder_free_48x48.png"));
        assertFalse(tilesetNames.contains("tilesets/grass.tsx"));
        assertFalse(tilesetNames.contains("final-map.tmx"));
        assertFalse(tilesetNames.contains(".png"));
    }

    @Test
    public void testSearchTileset() {
        TileSearcher ts = new TileSearcherImpl(mapProp);
        assertEquals("tilesets/Room_Builder_free_48x48.png", ts.searchTileset(1).getFileName());
        assertEquals("tilesets/Characters_MV.png", ts.searchTileset(2007).getFileName());
        assertNotEquals("tilesets/Characters_MV.png", ts.searchTileset(2008).getFileName());
    }
}
