package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.player.Player;

public class CameraImpl implements Camera {

    //TODO: capire come calcolare le coordinate del rettangolo da considerare. Forse basta usare lo slider e settare un valore fisso.
    @Override
    public Rectangle zoom(Player player) {
        var pos = player.getObjectPosition();
        return new Rectangle(new Point2D(0,0), new Point2D(0,0)); //TODO
    }
}
