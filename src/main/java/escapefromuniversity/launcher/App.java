package escapefromuniversity.launcher;

/**
 * The main class from which starts the game.
 */
public final class App {

	private App() { }

	/**
	 * Starts the launcher of the game.
	 * @param args contains the supplied command-line arguments as an array of String objects
	 */
	public static void main(final String[] args) {
		LauncherView.createLauncher();
	}

}