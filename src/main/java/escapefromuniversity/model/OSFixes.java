package escapefromuniversity.model;

import java.io.IOException;

public class OSFixes {
	
	public final static String FS = System.getProperty("file.separator");
	public final static String UD = System.getProperty("user.dir");
	private final static String OS = System.getProperty("os.name").toLowerCase();
	
	public void openUrl(String url) {
		// Windows:
		if (OS.contains("win")) {
			try {
				new ProcessBuilder("rundll32 url.dll,FileProtocolHandler ", url).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		// MacOs:
		} else if (OS.contains("mac")) {
			try {
				new ProcessBuilder("open ", url).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		// Linux:
		} else if (OS.contains("nix") || OS.contains("nux")) {
			try {
				new ProcessBuilder("xdg-open ", url).start();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static String getLocation(String folderName, String fileName) {
		String resLocation = new String(UD + FS + "src" + FS + "main" + FS + "resources" + FS + folderName + FS + fileName);
		return resLocation;
	}
	
}
