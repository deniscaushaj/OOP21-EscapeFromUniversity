package escapefromuniversity.utilities;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Implements fields and methods to open web urls and filepaths working on every OS supported.
 *
 * @author marco
 */
public class OSFixes {

    public final static String FS = System.getProperty("file.separator");
    public final static String UD = System.getProperty("user.dir");
    private final static String OS = System.getProperty("os.name").toLowerCase();

    /**
     * Opens the url passed as a string.
     * @param url the web url to open.
     */
    public static void openUrl(String url) {
        if (OS.contains("win")) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else if (OS.contains("mac")) {
            try {
                new ProcessBuilder("open " + url).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (OS.contains("nix") || OS.contains("nux")) {
            try {
                new ProcessBuilder("xdg-open " + url).start();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Getter method to obtain a string which contains the filepath of the file to open from resources folder. 
     * @param folderName the name of the subfolder inside resources folder to look into.
     * @param fileName the name of the file to open.
     * @return a string containing the filepath.
     */
    public static String getLocation(String folderName, String fileName) {
        return UD + FS + "src" + FS + "main" + FS + "resources" + FS + folderName + FS + fileName;
    }

}
