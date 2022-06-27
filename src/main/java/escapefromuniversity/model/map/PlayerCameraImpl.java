package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.player.Player;

public class PlayerCameraImpl implements Camera {

    private static final double RADIUS = 10;
    private final Player player;

    public PlayerCameraImpl(Player player){
        this.player = player;
    }

    @Override
    public Rectangle calcMapProjection(double ratio) {
        var hb = this.player.getObjectHitBox();
        var center = hb.getBottomLeftCorner().sum(hb.getUpperRightCorner()).multiplication(0.5);

        return new Rectangle(
                center.sum(new Point2D(-RADIUS, -RADIUS / ratio)),
                center.sum(new Point2D(RADIUS, RADIUS / ratio)));
    }


}
