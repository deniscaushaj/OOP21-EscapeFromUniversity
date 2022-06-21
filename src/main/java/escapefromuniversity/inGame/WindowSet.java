package escapefromuniversity.inGame;

import static escapefromuniversity.utilities.LauncherResizer.screenHeight;
import static escapefromuniversity.utilities.LauncherResizer.screenWidth;

public class WindowSet {
	
	public static final int NATIVE_WIDTH = 1920;
	
	public static final int NATIVE_HEIGHT = 1080;
	
	public static final double RATIO = 0.777;
	
	private static final double windowRatio = Math.min((double) (screenHeight) / (double) (NATIVE_HEIGHT), (double) (screenWidth) / (double) (NATIVE_WIDTH));
	
	public double getWindowRatio() {
		return windowRatio;
	}

}
