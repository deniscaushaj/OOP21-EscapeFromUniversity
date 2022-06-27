package escapefromuniversity.launcher;
/**
 * The main class from which starts the game.
 */
public final class App {

	private App() { }

	/**
	 * Starts the launcher of the game.
	 * @param args
	 */
	public static void main (final String[] args) {
		LauncherView.createLauncher();
	}

}