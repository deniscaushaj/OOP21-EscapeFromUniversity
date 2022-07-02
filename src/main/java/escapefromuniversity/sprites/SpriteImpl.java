package escapefromuniversity.sprites;

import escapefromuniversity.model.basics.GameCollisionType;
import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.map.Rectangle;

/**
 * Implements the interface {@link Sprite}.
 */
public class SpriteImpl implements Sprite {

    private State state;
    private final GameObjectType objType;
    private String filepath;
    private String folder;
    private String filename;
    private int tileCount;
    private int lastUpdate;
    private final Rectangle characterRectangle = new Rectangle(new Point2D(0, 0), new Point2D(1, 1.4));
    private final Rectangle bulletRectangle = new Rectangle(new Point2D(0, 0), new Point2D(0.3, 0.3));

    /**
     * Instantiates the sprite.
     * @param state the current state of the sprite.
     * @param objType the dynamic game object of which it's willing to get the sprite.
     */
    public SpriteImpl(State state, GameObjectType objType) {
        this.state = state;
        this.objType = objType;
        this.tileCount = 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkUpdate() {
        int updateDelay = 0;
        switch (this.objType) {
            case PLAYER:
                updateDelay = 1200;
                break;
            case BOSS1:
                updateDelay = 4000;
                break;
            case BOSS2:
                updateDelay = 3500;
                break;
            case BOSS3:
                updateDelay = 5000;
                break;
            case BOSS4:
                updateDelay = 4500;
                break;
            case BOSS5:
                updateDelay = 4500;
                break;
            case BOSS6:
                updateDelay = 5000;
                break;
            case BULLET_PLAYER:
                updateDelay = 3000;
                break;
            case BULLET_BOSS_1:
                updateDelay = 3000;
                break;
            case BULLET_BOSS_2:
                updateDelay = 3500;
                break;
            case BULLET_BOSS_3:
                updateDelay = 3500;
                break;
            case BULLET_BOSS_4:
                updateDelay = 3000;
                break;
            case BULLET_BOSS_5:
                updateDelay = 2500;
                break;
            case BULLET_BOSS_6:
                updateDelay = 2000;
                break;
            default: {}
        }
        final long currentTime = System.currentTimeMillis();
        if (currentTime - this.lastUpdate >= updateDelay) {
            this.lastUpdate = (int) currentTime;
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFilepath() {
        if(this.objType.equals(GameObjectType.BOSS1) || this.objType.equals(GameObjectType.BOSS2)
                || this.objType.equals(GameObjectType.BOSS3) || this.objType.equals(GameObjectType.BOSS4)
                || this.objType.equals(GameObjectType.BOSS5) || this.objType.equals(GameObjectType.BOSS6)) {
            this.folder = "boss";
            this.setupSpriteFilepath();
        } else if(this.objType.equals(GameObjectType.PLAYER)) {
            this.folder = "player";
            this.setupSpriteFilepath();
        } else if(this.objType.equals(GameObjectType.BULLET_BOSS_1) || this.objType.equals(GameObjectType.BULLET_BOSS_2)
                || this.objType.equals(GameObjectType.BULLET_BOSS_3) || this.objType.equals(GameObjectType.BULLET_BOSS_4)
                || this.objType.equals(GameObjectType.BULLET_BOSS_5) || this.objType.equals(GameObjectType.BULLET_BOSS_6)) {
            this.folder = "bullets";
            this.filename = "boss_bullet.png";
        } else if(this.objType.equals(GameObjectType.BULLET_PLAYER)) {
            this.folder = "bullets";
            this.filename = "player_bullet.png";
        }
        this.filepath = this.folder + "/" + this.filename;
    }

    /* Completes the filepath with all the parts of the filename. */
    private void setupSpriteFilepath() {
        this.filename = this.folder;
        this.setSpriteDirection();
        this.setSpriteNumber();
        this.filename = this.filename.concat(".png");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilepath() {
        return this.filepath;
    }

    /* Sets the sprite state to complete its filepath. */
    private void setSpriteDirection() {
        switch (this.state) {
            case UP:
                this.filename = this.filename.concat("_back");
                break;
            case DOWN:
                this.filename = this.filename.concat("_front");
                break;
            case RIGHT:
                this.filename = this.filename.concat("_right");
                break;
            case LEFT:
                this.filename = this.filename.concat("_left");
                break;
            default:
                break;
        }
    }

    /* Sets the sprite number to complete its filepath. */
    private void setSpriteNumber() {
        switch(this.tileCount) {
            case 1:
                this.filename = this.filename.concat("_1");
                this.tileCount++;
                break;
            case 2:
                this.filename = this.filename.concat("_2");
                this.tileCount++;
                break;
            case 3:
                this.filename = this.filename.concat("_3");
                this.tileCount = 1;
                break;
            default: {
            }
        }
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public void setState(State state) {
		this.state = state;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getRectangle() {
        if (this.objType.getCollisionType().equals(GameCollisionType.ENTITY)) {
            return this.characterRectangle;
        } else if (this.objType.getCollisionType().equals(GameCollisionType.BULLET)) {
            return this.bulletRectangle;
        }
        return null;
    }


}
