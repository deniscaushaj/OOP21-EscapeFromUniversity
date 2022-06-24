package escapefromuniversity.inGame;

import java.awt.*;

import escapefromuniversity.model.gameObject.State;

public interface Sprite {

    boolean checkUpdate();

    void setImage();

    Image getImage();
    
    void setState(State state);

}
