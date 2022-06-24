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

