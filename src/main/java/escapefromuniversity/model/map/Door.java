package escapefromuniversity.model.map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.StaticGameObject;

public interface Door extends StaticGameObject {
    Point2D getPos();
}
