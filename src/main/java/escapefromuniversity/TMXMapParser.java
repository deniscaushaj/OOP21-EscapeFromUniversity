package escapefromuniversity;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TMXMapParser {
    
    private final InputStream mapFile;
    
    public TMXMapParser(final InputStream mapFile) {
        this.mapFile = mapFile;
    }
    
    public MapProperties parse() throws ParserConfigurationException, SAXException, IOException {
        final var factory = DocumentBuilderFactory.newInstance();
        final var builder = factory.newDocumentBuilder();
        
        final var doc = builder.parse(this.mapFile);
        final var mapNode = doc.getElementsByTagName("map").item(0);
        
        final var attributes = mapNode.getAttributes();
        
        final var w = Integer.parseInt(attributes.getNamedItem("width").getTextContent());
        final var h = Integer.parseInt(attributes.getNamedItem("height").getTextContent());
        final var tw = Integer.parseInt(attributes.getNamedItem("tilewidth").getTextContent());
        final var th = Integer.parseInt(attributes.getNamedItem("tileheight").getTextContent());
        final var layerNodes = doc.getElementsByTagName("layer");
        final var layerStream = streamParse(layerNodes);

        final var tilesets = doc.getElementsByTagName("tileset");

        return new MapProperties(w, h, tw, th, null, null);
    }
    
    private Layer parseLayer(final Node node) {
        final var children = streamParse(node.getChildNodes());
        final var propsNode = children.filter(e -> "properties".equals(e.getNodeName())).findFirst().get();
        final var data = children.filter(e -> "data".equals(e.getNodeName())).findFirst().get();
        final var name = node.getAttributes().getNamedItem("name").getTextContent();
        //All the layers have the same width and weight of the map, so I don't need to get their sizes
        final var list = streamParse(propsNode.getChildNodes())
                .filter(e -> "true".equals(e.getAttributes().getNamedItem("value").getTextContent()))
                .map(e -> e.getAttributes().getNamedItem("name").getTextContent())
                .collect(Collectors.toList());
        final var rows = data.getTextContent().split("\n");
        final var columns = Arrays.stream(rows)
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
