package escapefromuniversity.utilities;



import static escapefromuniversity.utilities.LauncherResizer.SCREENHEIGHT;
import static escapefromuniversity.utilities.LauncherResizer.SCREENWIDTH;

import java.awt.Font;

/**
 * 
 * class to check window size.
 *
 */
public final class WindowSet {

    private WindowSet() {

    }

    /**
     * font standard.
     */
    public static final Font FONT = new Font("OCR A Extended", Font.PLAIN, 20);
    /**
     * 
     */
    public static final int NATIVE_WIDTH = 1920;
    /**
     * 
     */
    public static final int NATIVE_HEIGHT = 1080;
    /**
     * 
     */
    public static final double RATIO = 0.777;


    private static final double WINDOW_RATIO = Math.min((double) (SCREENHEIGHT) / (double) (NATIVE_HEIGHT), (double) (SCREENWIDTH) / (double) (NATIVE_WIDTH));

    /**
     * 
     * @return ratio of window.
     */
    public static double getWindowRatio() {
        return WINDOW_RATIO;
    }

}
