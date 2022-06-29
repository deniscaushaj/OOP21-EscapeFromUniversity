import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;

public class Player2 {

    private final GameObjectType objType;

    public Player2(Point2D position, int shootDelay) {
        this.objType = GameObjectType.PLAYER;
    }
}
