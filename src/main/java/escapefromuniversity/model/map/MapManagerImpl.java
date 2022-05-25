package escapefromuniversity.model.map;

public class MapManagerImpl implements MapManager {
    @Override
    public void roomChange() {
        /*
        * Richiamare la getRoom per controllare se bisogna cambiare layer da corridoio a stanza o viceversa (oppure oscurare
        * tutto ciò che sta fuori dalla stanza corrente riuscendo ad identificarla)
        * */
    }

    @Override
    public void getRoom() {
        /*
        * Forse da sostituire con un getZone
        * Forse sarebbe figo creare una map che contenga tutti gli ID delle stanze (KEY) e in modo tale da poter restituire
        * la posizione associata alla stanza (VALUE)
        * */
    }

    @Override
    public boolean gameOver() {
        return false;
    }
}
