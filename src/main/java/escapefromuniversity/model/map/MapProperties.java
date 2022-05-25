package escapefromuniversity.model.map;

import java.util.List;

public interface MapProperties {
    public int getWidth();
    public int getHeight();
    public int getTilewidth();
    public int getTileheight();
    public List<Layer> getLayers();
    public List<Tileset> getTilesets();
    @Override
    public String toString();
}
