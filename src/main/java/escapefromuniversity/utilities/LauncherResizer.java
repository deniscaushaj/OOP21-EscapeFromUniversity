package escapefromuniversity.utilities;

import javafx.stage.Screen;

/**
 * The window resizer based on the resolution.
 */
public class LauncherResizer {
	
	/**
	 * The screen width.
	 */
	public static final int SCREENWIDTH = (int) Screen.getPrimary().getBounds().getWidth();
	/**
	 * The screen height.
	 */
	public static final int SCRENHEIGHT = (int) Screen.getPrimary().getBounds().getHeight();
	/**
	 * The scene width.
	 */
	public static int sceneWidth = 0;
	/**
	 * The scene height.
	 */
	public static int sceneHeight = 0;

	/**
	 * Set the scene size.
	 * @param screenWidth The screen width.
	 * @param screenHeight The screen height.
	 */
	public void setSceneSize(final int screenWidth, final int screenHeight) {
		if (screenWidth <= 1280) { //HD 1280 x 720
			sceneWidth = 480;
			sceneHeight = 320;
		} else if (screenWidth <= 1920) { //FHD 1920 x 1080
			sceneWidth = 600;
			sceneHeight = 400;
		} else if (screenWidth <= 2560) { //QHD 2560 x 1440
			sceneWidth = 900;
			sceneHeight = 600;
		} else if (screenWidth >= 3840) { //UHD 3840 x 2160
			sceneWidth = 1200;
			sceneHeight = 800;
		}
	}

}
