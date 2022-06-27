package escapefromuniversity.input;

/**
 * A class to create an object containing a key and some properties of it.
 * @param <Key>
 * @param <Clicked>
 * @param <Direction>
 */
public class Command<Key, Clicked, Direction> {

    private final Key key;
    private Clicked clicked;
    private final Direction direction;

    /**
     * Instantiates this object.
     * @param key
     * @param clicked
     * @param direction
     */
    public Command(final Key key, final Clicked clicked, final Direction direction) {
        this.key = key;
        this.clicked = clicked;
        this.direction = direction;
    }

    /**
     * Returns the key.
     * @return the key.
     */
    public Key getKey() {
        return this.key;
    }

    /**
     * Returns the clicked.
     * @return the clicked.
     */
    public Clicked getClicked() {
        return this.clicked;
    }

    /**
     * Returns the direction.
     * @return the direction.
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Sets clicked.
     * @param clicked the clicked to set.
     */
    public void setClicked(final Clicked clicked) {
        this.clicked = clicked;
    }

}
