    @Override
    public void checkButtonsAvailability() {
        if(!this.itemType.increaseDamage(this.player) && this.player.getCredits() < increaseDamageCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyDamage());
        }
        if(!this.itemType.increaseArmor(this.player) && this.player.getCredits() < increaseArmorCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyArmor());
        }
        if(!this.itemType.resetHealth(this.player) && this.player.getCredits() < resetHealthCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyLife());
        }
        if(!this.competition.isBonusAvailable() && this.player.getCredits() < doubleChanceCost) {
            this.shopView.setButtonNotClickable(this.shopView.getBuyChance());
        }
    }
