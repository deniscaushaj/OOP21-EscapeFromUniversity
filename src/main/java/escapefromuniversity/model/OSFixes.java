package escapefromuniversity.model;

import java.io.IOException;

public class OSFixes {
	
	public final static String FS = System.getProperty("file.separator");
	public final static String UD = System.getProperty("user.dir");
	private final static String OS = System.getProperty("os.name").toLowerCase();
	
	public void openUrl(String url) {
		if (OSFixes.OS.contains("win")) { // Windows
			try {
				new ProcessBuilder("rundll32 url.dll,FileProtocolHandler ", url).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (OSFixes.OS.contains("mac")) { // MacOs
			try {
				new ProcessBuilder("open ", url).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (OSFixes.OS.contains("nix") || OSFixes.OS.contains("nux")) { // Linux
			try {
				new ProcessBuilder("xdg-open ", url).start();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
