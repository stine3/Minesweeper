import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MineTimer extends JLabel implements ActionListener {

	private static final long serialVersionUID = 1L;

	Timer timer = new Timer(1000, this);
	private static MineTimer instance = null;
	private int sec;

	private MineTimer() {
		setSec(0);
		timer.start();
	}

	static public MineTimer getInstance() {
		if (instance == null) {
			instance = new MineTimer();
		}

		return instance;
	}

	public void restart() {
		setSec(0);
		timer.restart();
	}

	public void stop() {
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		setSec(getSec() + 1);

		instance.setText("Time: " +  (int)getSec());
		repaint();

	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

}
