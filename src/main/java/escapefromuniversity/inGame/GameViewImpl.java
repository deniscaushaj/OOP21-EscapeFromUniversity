package escapefromuniversity.inGame;

import escapefromuniversity.launcher.LauncherView;
import escapefromuniversity.model.GameState;
import escapefromuniversity.utilities.OSFixes;
import escapefromuniversity.utilities.WindowSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static escapefromuniversity.utilities.LauncherResizer.screenHeight;
import static escapefromuniversity.utilities.LauncherResizer.screenWidth;

public class GameViewImpl extends JFrame implements GameView, KeyListener {

	private GameController gameController;
	private final JFrame window;
	private JPanel pause;
	private BufferedImage tempScreen;
	private final GameHUDPanel gameHUD = new GameHUDPanel(WindowSet.getWindowRatio());
	private static final long DELAY_CLOSE = 5000;
	private final Map<Integer,Sprite> animations = new HashMap<>();

	public GameViewImpl(GameController gameController) {
		this.gameController = gameController;
		this.window = new JFrame();
		this.window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.window.setUndecorated(true);
		this.window.setSize(screenWidth, screenHeight);
		this.window.setResizable(false);
		this.window.setTitle("Escape From University");
		String logo = OSFixes.getLocation("images", "logo.png"); // TODO change icon
		this.window.setIconImage(Toolkit.getDefaultToolkit().getImage(logo));
		this.window.setVisible(true);
		//	private final JPanel gamePanel;

		this.window.addKeyListener(this);

		this.pause = new JPanel();
		this.tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = this.tempScreen.createGraphics();
		g2d.setFont(WindowSet.FONT);

		drawToScreen();
		drawToImage();
	}

	public void drawToScreen() {
		Graphics g = this.window.getGraphics();
		g.drawImage(this.tempScreen, 0, 0, screenWidth, screenHeight, null);
		
//		g.dispose();
	}

	public void drawToImage () {
		// camera, hud, dynamic

	}

	@Override
	public void update() {

	}

	@Override
	public void addPauseBG() {
		Color color = new Color(0,0,0,205);
		this.pause.setBackground(color);
		this.window.add(this.pause);
	}

	@Override
	public void removePauseBG() {
		this.window.remove(this.pause);
	}

	@Override
	public void keyTyped(KeyEvent key) {
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if(this.gameController != null) {
			this.gameController.pressKey(key);
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if(this.gameController != null) {
			this.gameController.releaseKey(key);
		}
	}

	@Override
	public void openMenu() {
		this.gameController.setGameState(GameState.MENU);
	}
	
	private void end(GameState gameState) {
		if(gameState == GameState.WIN) {
			//aggiorna con immagine vittoria
		}else if(gameState == GameState.LOST){
			//aggiorna con immagine sconfitta
		}
		try {
			Thread.sleep(DELAY_CLOSE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LauncherView.createLauncher();
//		System.exit(0);
		this.window.setVisible(false);
		this.window.dispose();
	}
	
}
