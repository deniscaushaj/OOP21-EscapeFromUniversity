package escapefromuniversity.model.player;

import escapefromuniversity.model.gameObject.Direction;

import java.awt.Image;

public interface PlayerMovement {

    void stopVertical();

    void stopHorizontal();

    void move(Direction direction);

}
