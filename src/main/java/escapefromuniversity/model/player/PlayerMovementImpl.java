package escapefromuniversity.model.player;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import escapefromuniversity.utilities.OSFixes;
import escapefromuniversity.model.basics.Vector2D;
import escapefromuniversity.model.gameObject.Direction;

public class PlayerMovementImpl implements PlayerMovement {

    private final Player player;
    private Image image;

    public PlayerMovementImpl(final Player player) {
        this.player = player;
    }

    //TODO move from here image methods

    @Override
    public void setImage () {
        int tileCount = 1;
        String number = null;
        String filename = null;
        File filepath;
        switch (player.getState()) {
            case IDLE:
//            TODO idle
                break;
            case UP:
                filename = "player_back_";
                break;
            case DOWN:
                filename = "player_front_";
                break;
            case RIGHT:
                filename = "player_right_";
                break;
            case LEFT:
                filename = "player_left_";
                break;
            default:
                break;
        }
        if (tileCount == 1) {
            number = "1";
            tileCount++;
        } else if (tileCount == 2) {
            number = "2";
            tileCount++;
        } else if (tileCount == 3) {
            number = "3";
            tileCount = 1;
        }
//        TODO how many updates per second
        filename.concat(number);
        filepath = new File(OSFixes.getLocation("player", filename));
        try {
            this.image = ImageIO.read(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image getImage () {
        return this.image;
    }

    private void moveUp() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), -1));
    }

    private void moveDown() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), 1));
    }

    private void moveRight() {
        this.player.setDirection(new Vector2D(1, this.player.getDirection().getY()));
    }

    private void moveLeft() {
        this.player.setDirection(new Vector2D(-1, this.player.getDirection().getY()));
    }

    public void stopVertical() {
        this.player.setDirection(new Vector2D(this.player.getDirection().getX(), 0));
    }

    public void stopHorizontal() {
        this.player.setDirection(new Vector2D(0, this.player.getDirection().getY()));
    }

    public void move(final Direction direction) {
        switch (direction) {
            case UP -> this.moveUp();
            case DOWN -> this.moveDown();
            case RIGHT -> this.moveRight();
            case LEFT -> this.moveLeft();
            default -> {
            }
        }
    }

}
