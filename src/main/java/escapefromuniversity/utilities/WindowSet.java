package escapefromuniversity.utilities;

import java.awt.*;

import static escapefromuniversity.utilities.LauncherResizer.screenHeight;
import static escapefromuniversity.utilities.LauncherResizer.screenWidth;

public class WindowSet {

	public static final Font FONT = new Font("OCR A Extended", Font.PLAIN, 20);
	public static final int NATIVE_WIDTH = 1920;
	public static final int NATIVE_HEIGHT = 1080;
	public static final double RATIO = 0.777;
	private static final double windowRatio = Math.min((float) screenHeight / (float) NATIVE_HEIGHT, (float) screenWidth / (float) NATIVE_WIDTH);

	public static double getWindowRatio() {
		return windowRatio;
	}

}
