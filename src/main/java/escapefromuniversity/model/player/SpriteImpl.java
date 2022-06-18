package escapefromuniversity.model.player;

import escapefromuniversity.model.gameObject.DynamicGameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.utilities.OSFixes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SpriteImpl implements Sprite {

    private final DynamicGameObject gameObject;
    private final GameObjectType objType;
    private Image image;
    private File filepath;
    private File prevFilepath;
    private String folder;
    private String filename;

    public SpriteImpl(DynamicGameObject gameObject, GameObjectType objType) {
        this.gameObject = gameObject;
        this.objType = objType;
    }

    @Override
    public void setImage() {
        if(this.objType.equals(GameObjectType.BOSS1) || this.objType.equals(GameObjectType.BOSS2)
                || this.objType.equals(GameObjectType.BOSS3) || this.objType.equals(GameObjectType.BOSS4)
                || this.objType.equals(GameObjectType.BOSS5) || this.objType.equals(GameObjectType.BOSS6)) {
            this.setFolder("boss");
        } else if(this.objType.equals(GameObjectType.PLAYER)) {
            this.setFolder("player");
        }
        this.setFilename(this.getFolder());
        this.setSpriteDirection();
        this.setSpriteNumber();
        this.setPrevFilepath(this.getFilepath());
        this.setFilepath();
        try {
            this.image = ImageIO.read(this.getFilepath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    private void setFilepath() {
        this.filepath = new File(OSFixes.getLocation(this.getFolder(), this.getFilename()));
    }

    private File getFilepath() {
        return this.filepath;
    }

    private void setPrevFilepath(File prevFilepath) {
        this.prevFilepath = prevFilepath;
    }

    private File getPrevFilepath() {
        return this.prevFilepath;
    }

    private void setFolder(String folder) {
        this.folder = folder;
    }

    private String getFolder() {
        return this.folder;
    }

    private void setFilename(String filename) {
        this.filename = filename;
    }

    private String getFilename() {
        return this.filename;
    }

    private void setSpriteDirection() {
        switch (this.gameObject.getState()) {
            case UP:
                this.getFilename().concat("_back");
                break;
            case DOWN:
                this.getFilename().concat("_front");
                break;
            case RIGHT:
                this.getFilename().concat("_right");
                break;
            case LEFT:
                this.getFilename().concat("_left");
                break;
            default:
                break;
        }
    }

    private void setSpriteNumber() {
        int tileCount = 1;
        if (tileCount == 1) {
            this.getFilename().concat("_1");
            tileCount++;
        } else if (tileCount == 2) {
            this.getFilename().concat("_2");
            tileCount++;
        } else if (tileCount == 3) {
            this.getFilename().concat("_3");
            tileCount = 1;
        }
    }

}
