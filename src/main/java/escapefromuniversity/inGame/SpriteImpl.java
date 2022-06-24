package escapefromuniversity.inGame;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.gameObject.State;
import escapefromuniversity.model.map.Rectangle;

public class SpriteImpl implements Sprite {

    private State state;
    private final GameObjectType objType;
    private String filepath;
    private String folder;
    private String filename;
    private int tileCount;
    private int lastUpdate;
    private final Rectangle characterRectangle = new Rectangle(new Point2D(0, 0), new Point2D(50, 70));
    private final Rectangle bulletRectangle = new Rectangle(new Point2D(0, 0), new Point2D(15, 15));

    public SpriteImpl(State state, GameObjectType objType) {
        this.state = state;
        this.objType = objType;
        this.tileCount = 1;
    }

    @Override
    public boolean checkUpdate() {
        final long currentTime = System.currentTimeMillis();
        final int updateDelay = 1200;
        if (currentTime - this.lastUpdate >= updateDelay) {
            this.lastUpdate = (int) currentTime;
            return true;
        }
        return false;
    }

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
            this.folder = "bullet";
            this.filename = "boss_bullet.png";
        } else if(this.objType.equals(GameObjectType.BULLET_PLAYER)) {
            this.folder = "bullet";
            this.filename = "player_bullet.png";
        }
        this.filepath = this.folder + this.filename;
    }

    private void setupSpriteFilepath() {
        this.filename = this.folder;
        this.setSpriteDirection();
        this.setSpriteNumber();
    }

    @Override
    public String getFilepath() {
        return this.filepath;
    }

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

    private void setSpriteNumber() {
        switch(this.tileCount) {
            case 1:
                this.filename = this.filename.concat("_1");
                this.tileCount++;
            case 2:
                this.filename = this.filename.concat("_2");
                this.tileCount++;
            case 3:
                this.filename = this.filename.concat("_3");
                this.tileCount = 1;
            default: {
            }
        }
    }

	@Override
	public void setState(State state) {
		this.state = state;
	}

    @Override
    public Rectangle getCharacterRectangle() {
        return this.characterRectangle;
    }

    @Override
    public Rectangle getBulletRectangle() {
        return this.bulletRectangle;
    }

}
