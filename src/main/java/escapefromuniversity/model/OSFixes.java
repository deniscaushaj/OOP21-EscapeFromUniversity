package escapefromuniversity.model;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OSFixes {
	
	public static String os = System.getProperty("os.name").toLowerCase();
	
	public void openUrl(String url) {
		
		if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
			try {
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		} else { 
			Runtime runtime = Runtime.getRuntime();
			if (OSFixes.os.indexOf("win") >= 0) { // Windows
				try {
					runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (OSFixes.os.indexOf("mac") >= 0) { // MacOs
				try {
					runtime.exec("open" + url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (OSFixes.os.indexOf("nix") >= 0 || OSFixes.os.indexOf("nux") >= 0) { // Linux
				try {
					runtime.exec("xdg-open" + url);
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
}
