package escapefromuniversity;

public enum GameState {
    
    /**
     * Identifies the menu state.
     */    
    MENU,
    /**
     * Identifies the play state.
     */   
    PLAY,
    /**
     * Identifies the quiz state.
     */   
    QUIZ,
    /**
     * Identifies the fight state.
     */   
    FIGHT,
    /**
     * Identifies the dialogue state.
     */   
    DIALOGUE,
    /**
     * Identifies the character state.
     */   
    CHARACTER,
    /**
     * Identifies the shop state.
     */   
    SHOP,
    /**
     * Identifies the win state.
     */   
    WIN;
    
    private GameState gameState;
    
    /**
     * @return the current game state.
     */
    public GameState getGameState () {
        return gameState;
    }
    
    /**
     * Sets the current game state.
     * @param gameState : the game state to set.
     */
    public void setGameState (GameState gameState) {
        this.gameState = gameState;
    }
    
}
