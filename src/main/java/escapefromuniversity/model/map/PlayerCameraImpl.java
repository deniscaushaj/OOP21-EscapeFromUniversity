package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.player.Player;

/**
 * A class which implements Camera.
 */
public class PlayerCameraImpl implements Camera {

    private static final double RADIUS = 10;
    private final Player player;

    /**
     * A constructor for PlayerCameraImpl.
     * @param player the current player
     */
    public PlayerCameraImpl(final Player player) {
        this.player = player;
    }

    @Override
    public Rectangle calcMapProjection(final double ratio) {
        var hb = this.player.getObjectHitBox();
        var center = hb.getBottomRightCorner().sum(hb.getTopLeftCorner()).multiplication(0.5);

        return new Rectangle(
                center.sum(new Point2D(-RADIUS, -RADIUS / ratio)),
                center.sum(new Point2D(RADIUS, RADIUS / ratio)));
    }


}
