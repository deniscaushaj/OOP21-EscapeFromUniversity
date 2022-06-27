package escapefromuniversity.input;

import escapefromuniversity.model.gameObject.Direction;

import java.util.List;
import java.util.Optional;

/**
 * The interface that handles all the keyboard input.
 */
public interface KeyHandler {

    /**
     * Returns the list of all the commands.
     * @return the list of all the commands.
     */
    List<Command<Integer, Boolean, Optional<Direction>>> getKeyList();

    /**
     * Calls the method that executes the command depending on the current game state.
     */
    void executeCommand();

    /**
     * Sets a key to be clicked or not.
     * @param key the keyboard button.
     * @param clicked {@code true} if the key is clicked.
     */
    void setKey(int key, boolean clicked);

    /**
     * Sets all the keys to be inactive.
     */
    void setAllInactive();

}
