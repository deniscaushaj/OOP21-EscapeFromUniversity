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

public class TMXMapParser {
    
    private final String mapName;

    public TMXMapParser(final String mapName) {
        this.mapName = mapName;
    }
    
    public MapPropertiesImpl parse() throws ParserConfigurationException, SAXException, IOException {
        final var factory = DocumentBuilderFactory.newInstance();
        final var builder = factory.newDocumentBuilder();
        
        final var doc = builder.parse(ClassLoader.getSystemResourceAsStream(mapName));
        final var mapNode = doc.getElementsByTagName("map").item(0);
        
        final var attributes = mapNode.getAttributes();
        
        final var w = Integer.parseInt(attributes.getNamedItem("width").getTextContent());
        final var h = Integer.parseInt(attributes.getNamedItem("height").getTextContent());
        final var tw = Integer.parseInt(attributes.getNamedItem("tilewidth").getTextContent());
        final var th = Integer.parseInt(attributes.getNamedItem("tileheight").getTextContent());

        final var layerNodes = doc.getElementsByTagName("layer");
        final var layerStream = streamParse(layerNodes);

        final var tilesets = doc.getElementsByTagName("tileset");
        final var tilesetsStream = streamParse(tilesets);

        return new MapPropertiesImpl(w, h, tw, th,
                layerStream.map(this::parseLayer).collect(Collectors.toList()),
                tilesetsStream.map(this::parseTileset).collect(Collectors.toList()));
    }

    private Node tilesetNodeFromName(String tilesetName) {
        try {
            final var factory = DocumentBuilderFactory.newInstance();
            final var builder = factory.newDocumentBuilder();
            final var tName = builder.parse(ClassLoader.getSystemResourceAsStream(tilesetName));

            return tName.getElementsByTagName("tileset").item(0);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private Tileset parseTileset(final Node t) {
        final var tileset = tilesetNodeFromName(t.getAttributes().getNamedItem("source").getTextContent());
        final var firstTileId = Integer.parseInt(t.getAttributes().getNamedItem("firstgid").getTextContent());
        final var children = streamParse(tileset.getChildNodes());
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

    private Layer parseLayer(final Node node) {
        final var children = streamParse(node.getChildNodes()).collect(Collectors.toList());
        final var data = children.stream().filter(e -> "data".equals(e.getNodeName())).findFirst().get();
        final var name = node.getAttributes().getNamedItem("name").getTextContent();

        List<String> list = new ArrayList<>();
        final var control = children.stream().filter(e -> "properties".equals(e.getNodeName())).findFirst();
        if(control.isPresent()){
            final var propsNode = control.get();
            list = streamParse(propsNode.getChildNodes())
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
    
    private Stream<Node> streamParse(final NodeList list) {
        return IntStream.range(0, list.getLength())
                .mapToObj(list::item);
    }
}
