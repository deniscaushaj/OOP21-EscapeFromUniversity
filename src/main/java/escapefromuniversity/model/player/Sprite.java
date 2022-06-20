package escapefromuniversity.model.player;

import java.awt.*;

import escapefromuniversity.model.gameObject.State;

public interface Sprite {

    void setImage();

    Image getImage();
    
    void setState(State state);

}
