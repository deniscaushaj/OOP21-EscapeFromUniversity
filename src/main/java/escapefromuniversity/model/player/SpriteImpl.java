package escapefromuniversity.model.player;

import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.utilities.OSFixes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SpriteImpl implements Sprite {

    private State state;
    private final GameObjectType objType;
    private Image image;
    private File filepath;
    private File prevFilepath;
    private String folder;
    private String filename;
    private int tileCount;

    public SpriteImpl(State state, GameObjectType objType) {
        this.state = state;
        this.objType = objType;
        this.tileCount = 1;
    }

    @Override
    public void setImage() {
        // TODO add update check
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
        switch (this.state) {
            case UP:
                this.setFilename(this.getFilename().concat("_back"));
                break;
            case DOWN:
                this.setFilename(this.getFilename().concat("_front"));
                break;
            case RIGHT:
                this.setFilename(this.getFilename().concat("_right"));
                break;
            case LEFT:
                this.setFilename(this.getFilename().concat("_left"));
                break;
            default:
                break;
        }
    }

    private void setSpriteNumber() {
        switch(this.tileCount) {
            case 1:
                this.setFilename(this.getFilename().concat("_1"));
                this.tileCount++;
            case 2:
                this.setFilename(this.getFilename().concat("_2"));
                this.tileCount++;
            case 3:
                this.setFilename(this.getFilename().concat("_3"));
                this.tileCount = 1;
            default: {
            }
        }
    }

	@Override
	public void setState(State state) {
		this.state = state;
	}

}
