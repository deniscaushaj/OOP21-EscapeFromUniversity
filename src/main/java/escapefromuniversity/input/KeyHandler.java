package escapefromuniversity.input;

import escapefromuniversity.model.gameObject.Direction;

import java.util.List;
import java.util.Optional;

public interface KeyHandler {

    List<Command<Integer, Boolean, Optional<Direction>>> getKeyList();

    void executeCommand();

    void setKey(int key, boolean clicked);

    void setAllInactive();

}
