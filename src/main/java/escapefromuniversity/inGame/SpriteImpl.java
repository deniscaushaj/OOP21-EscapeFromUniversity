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
    public void setImage() {
        if(this.objType.equals(GameObjectType.BOSS1) || this.objType.equals(GameObjectType.BOSS2)
                || this.objType.equals(GameObjectType.BOSS3) || this.objType.equals(GameObjectType.BOSS4)
                || this.objType.equals(GameObjectType.BOSS5) || this.objType.equals(GameObjectType.BOSS6)) {
            this.setFolder("boss");
            this.setupSpriteFilepath();
        } else if(this.objType.equals(GameObjectType.PLAYER)) {
            this.setFolder("player");
            this.setupSpriteFilepath();
        } else if(this.objType.equals(GameObjectType.BULLET_BOSS_1) || this.objType.equals(GameObjectType.BULLET_BOSS_2)
                || this.objType.equals(GameObjectType.BULLET_BOSS_3) || this.objType.equals(GameObjectType.BULLET_BOSS_4)
                || this.objType.equals(GameObjectType.BULLET_BOSS_5) || this.objType.equals(GameObjectType.BULLET_BOSS_6)) {
            this.setFolder("bullet");
            this.setFilename("boss_bullet.png");
        } else if(this.objType.equals(GameObjectType.BULLET_PLAYER)) {
            this.setFolder("bullet");
            this.setFilename("player_bullet.png");
        }
        this.setFilepath();
        try {
            this.image = ImageIO.read(this.getFilepath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setupSpriteFilepath() {
        this.setFilename(this.getFolder());
        this.setSpriteDirection();
        this.setSpriteNumber();
        this.setPrevFilepath(this.getFilepath());
    }
