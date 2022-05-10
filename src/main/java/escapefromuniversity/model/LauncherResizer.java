package escapefromuniversity.model;

import javafx.stage.Screen;

public class LauncherResizer {
	
	public static int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
	public static int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
	
	public static int sceneWidth = 0;
    public static int sceneHeight = 0;
    
	public void setSceneSize(int screenWidth, int screenHeight) {
    	if (screenWidth <= 1280) { //HD 1280 x 720
    		LauncherResizer.sceneWidth = 600;
    		LauncherResizer.sceneHeight = 400;
    		System.out.println("hd");
    	} else if (screenWidth <= 1920) { //FHD 1920 x 1080
    		LauncherResizer.sceneWidth = 600;
    		LauncherResizer.sceneHeight = 400;
    		System.out.println("fhd");
    	} else if (screenWidth <= 2560) { //QHD 2560 x 1440
    		LauncherResizer.sceneWidth = 900;
    		LauncherResizer.sceneHeight = 600;
    		System.out.println("2k");
    	} else if (screenWidth >= 3840) { //UHD 3840 x 2160
    		LauncherResizer.sceneWidth = 1200;
    		LauncherResizer.sceneHeight = 800;
    		System.out.println("4k");
    	}   	
    }
    
}
