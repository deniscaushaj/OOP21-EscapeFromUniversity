package escapefromuniversity.inGame;

import java.awt.*;

import escapefromuniversity.model.gameObject.State;

public interface Sprite {

    boolean checkUpdate();

    void setFilepath();

    String getFilepath();
    
    void setState(State state);

}
