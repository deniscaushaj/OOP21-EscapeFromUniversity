package escapefromuniversity.inGame.end;

import escapefromuniversity.model.GameState;

/**
 * 
 * class end controller.
 *
 */
public class EndControllerImpl implements EndController {
    private static final long END_DELTA_TIME = 5000;

    /**
     * 
     * @param state
     */
    public EndControllerImpl(final GameState state) {
        EndView view = EndViewImpl(state);
        Thread.sleep(END_DELTA_TIME);
    }

}
