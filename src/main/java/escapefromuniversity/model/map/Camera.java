package escapefromuniversity.model.map;

import escapefromuniversity.model.gameObject.player.Player;

/**
 * An interface for the camera of the game.
 */
public interface Camera {

    /*
    Faccio la get della posizione del player cosicché la camera si possa muovere in relazione alla sua posizione.
    Ciò significa che mi serve scegliere un livello di zoom della mappa e far disegnare la parte in cui si trova
    il player (con lui in mezzo).
     */

    /**
     * .
     * @param player the current player
     * @return the screened rectangle
     */
    Rectangle zoom(Player player);
}
