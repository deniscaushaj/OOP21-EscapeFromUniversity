package escapefromuniversity.inGame;

import java.awt.*;

import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.map.Rectangle;

public interface Sprite {

    boolean checkUpdate();

    void setFilepath();

    String getFilepath();
    
    void setState(State state);

    Rectangle getRectangle();
}
