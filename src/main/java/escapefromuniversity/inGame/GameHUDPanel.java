package escapefromuniversity.inGame;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;

public class GameHUDPanel extends JLayeredPane{
	
	private final JLabel creditsCounter = new JLabel();
	private JProgressBar playerLifeBar;
	
	
	
	public void updateCreditsCounter(final int credits) {
		this.creditsCounter.setText("CREDITS:  " + credits);
	}
	
	public void updateLife(final int life) {
		this.playerLifeBar.setValue(life);
	}

}
