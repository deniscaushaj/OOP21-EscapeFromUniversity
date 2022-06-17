package escapefromuniversity.input;

public class Command<Key, Clicked, Direction> {

    private final Key key;
    private Clicked clicked;
    private final Direction direction;

    public Command(final Key key, final Clicked clicked, final Direction direction) {
        this.key = key;
        this.clicked = clicked;
        this.direction = direction;
    }

    public Key getKey() {
        return this.key;
    }

    public Clicked getClicked() {
        return this.clicked;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setClicked(final Clicked clicked) {
        this.clicked = clicked;
    }

}
