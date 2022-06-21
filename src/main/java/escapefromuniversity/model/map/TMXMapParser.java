package escapefromuniversity.model.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * A class for parsing TMX files.
 */
public class TMXMapParser {
    private final String mapName;

    /**
     * Constructor for TMXMapParser.
     * @param mapName the filename of the map.
     */
    public TMXMapParser(final String mapName) {
        this.mapName = mapName;
    }

    /**
     * Parsing of the TMX file returning the map properties.
     * @return the map properties
     * @throws ParserConfigurationException indicates a serious configuration error.
     * @throws SAXException encapsulate a general SAX error or warning
     * @throws IOException signals that an I/O exception of some sort has occurred
     */
    public MapProperties parse() throws ParserConfigurationException, SAXException, IOException {
        //Building a new document
        final var factory = DocumentBuilderFactory.newInstance();
        final var builder = factory.newDocumentBuilder();
        //Generating a node from a document
        final var doc = builder.parse(ClassLoader.getSystemResourceAsStream(mapName));
        final var mapNode = doc.getElementsByTagName("map").item(0);
        //Getting all the attributes of the map
        final var attributes = mapNode.getAttributes();
        //Getting single attributes
        final var w = Integer.parseInt(attributes.getNamedItem("width").getTextContent());
        final var h = Integer.parseInt(attributes.getNamedItem("height").getTextContent());
        final var tw = Integer.parseInt(attributes.getNamedItem("tilewidth").getTextContent());
        final var th = Integer.parseInt(attributes.getNamedItem("tileheight").getTextContent());
        //Getting a stream from the layers composing the map
        final var layerNodes = doc.getElementsByTagName("layer");
        final var layerStream = nodelistToStreamParse(layerNodes);
        //Getting a stream from the tilesets composing the map
        final var tilesets = doc.getElementsByTagName("tileset");
        final var tilesetsStream = nodelistToStreamParse(tilesets);

        return new MapPropertiesImpl(w, h, tw, th,
                layerStream.map(this::parseLayer).collect(Collectors.toList()),
                tilesetsStream.map(this::parseTileset).collect(Collectors.toList()));
    }

    /**
     * Returns a node containing a tileset.
     * @param tilesetName the filename of the tileset
     * @return a node containing a tileset
     */
    private Node tilesetNodeFromName(final String tilesetName) {
        try {
            final var factory = DocumentBuilderFactory.newInstance();
            final var builder = factory.newDocumentBuilder();
            final var tName = builder.parse(ClassLoader.getSystemResourceAsStream(tilesetName));

            return tName.getElementsByTagName("tileset").item(0);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a tileset.
     * @param tNode the node containing the tileset
     * @return a tileset
     */
    private Tileset parseTileset(final Node tNode) {
        final var tileset = tilesetNodeFromName(tNode.getAttributes().getNamedItem("source").getTextContent());
        final var firstTileId = Integer.parseInt(tNode.getAttributes().getNamedItem("firstgid").getTextContent());
        final var children = nodelistToStreamParse(tileset.getChildNodes());
        final var path = children.filter(p -> "image".equals(p.getNodeName()))
                .findFirst()
                .get()
                .getAttributes()
                .getNamedItem("source")
                .getTextContent();
        final var tilesCount = Integer.parseInt(tileset.getAttributes().getNamedItem("tilecount").getTextContent());
        final var cols = Integer.parseInt(tileset.getAttributes().getNamedItem("columns").getTextContent());

        return new Tileset(path, tilesCount, cols, firstTileId);
    }

    /**
     * Returns a layer.
     * @param lNode the node containing a layer
     * @return a layer
     */
    private Layer parseLayer(final Node lNode) {
        final var children = nodelistToStreamParse(lNode.getChildNodes()).collect(Collectors.toList());
        final var data = children.stream().filter(e -> "data".equals(e.getNodeName())).findFirst().get();
        final var name = lNode.getAttributes().getNamedItem("name").getTextContent();

        List<String> list = new ArrayList<>();
        final var control = children.stream().filter(e -> "properties".equals(e.getNodeName())).findFirst();
        if (control.isPresent()) {
            final var propsNode = control.get();
            list = nodelistToStreamParse(propsNode.getChildNodes())
                    .filter(p -> "property".equals(p.getNodeName()))
                    .filter(e -> "true".equals(e.getAttributes().getNamedItem("value").getTextContent()))
                    .map(e -> e.getAttributes().getNamedItem("name").getTextContent())
                    .collect(Collectors.toList());
        }
        final var rows = data.getTextContent().split("\n");
        final var columns = Arrays.stream(rows)
                .filter(e -> !e.equals(""))
                .map(r -> r.split(","))
                .map(p -> Arrays.stream(p)
                        .map(Integer::parseInt)
                        .collect(Collectors.toUnmodifiableList()))
                .collect(Collectors.toUnmodifiableList());

        return new Layer(list, name, columns);
    }

    /**
     * A method for parsing from a NodeList to a Stream.
     * @param list the nodelist
     * @return a stream of the nodes
     */
    private Stream<Node> nodelistToStreamParse(final NodeList list) {
        return IntStream.range(0, list.getLength())
                .mapToObj(list::item);
    }
}
