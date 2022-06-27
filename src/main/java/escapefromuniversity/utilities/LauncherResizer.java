package escapefromuniversity.utilities;

import javafx.stage.Screen;

/**
 * The window resizer based on the resolution.
 */
public class LauncherResizer {

	public static final int SCREENWIDTH = (int) Screen.getPrimary().getBounds().getWidth();
	public static final int SCREENHEIGHT = (int) Screen.getPrimary().getBounds().getHeight();
	public static int sceneWidth = 0;
	public static int sceneHeight = 0;

	/**
	 * Sets the scene size.
	 * @param screenWidth the screen width.
	 * @param screenHeight the screen height.
	 */
	public void setSceneSize(final int screenWidth, final int screenHeight) {
		if (screenWidth <= 1280) {
			sceneWidth = 480;
			sceneHeight = 320;
		} else if (screenWidth <= 1920) {
			sceneWidth = 600;
			sceneHeight = 400;
		} else if (screenWidth <= 2560) {
			sceneWidth = 900;
			sceneHeight = 600;
		} else if (screenWidth >= 3840) {
			sceneWidth = 1200;
			sceneHeight = 800;
		}
	}

}
