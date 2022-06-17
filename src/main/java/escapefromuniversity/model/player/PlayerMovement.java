package escapefromuniversity.model.player;

import escapefromuniversity.model.gameObject.Direction;

import java.awt.Image;

public interface PlayerMovement {

    void setImage();

    Image getImage();

    void stopVertical();

    void stopHorizontal();

    void move(Direction direction);

}
