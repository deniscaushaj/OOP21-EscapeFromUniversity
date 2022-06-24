package escapefromuniversity.inGame;

import java.util.HashMap;
import java.util.Map;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class ControllerViewImpl implements ControllerView{
    private final GameController gameController;
    private final Map<Integer,SpriteAnimation> spriteAnimations = new HashMap<>();

    @FXML
    private Canvas gameCanvas;

    //final var gc = gameCanvas.getGraphicsContext2D();

    public ControllerViewImpl(GameController gameController) {
        this.gameController = gameController;
    }

    private void drawerMap() {

    }

    private void drawerObject() {

    }

    public void updateView() {
        this.drawerMap();
        this.drawerObject();
    }

    public void remuveSpriteAnimation(int id) {
        this.spriteAnimations.remove(id);
    }

    public void updateSpriteAnimation(int id, Point2D position) {
        this.spriteAnimations.get(id).setPosition(position);
        this.spriteAnimations.get(id).getSprite();
    }

    public void addSpriteAnimation(int id, State state, GameObjectType type, int height, int width) {
        final Sprite sprite = new SpriteImpl(state, type);
        final SpriteAnimation animation = new SpriteAnimation(sprite, height, width);
        this.spriteAnimations.put(id, animation);
    }

    public boolean containThisID(int id) {
        return this.spriteAnimations.containsKey(id);
    }
}
