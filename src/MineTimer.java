import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MineTimer extends JLabel implements ActionListener {

	private static final long serialVersionUID = 1L;

	Timer timer = new Timer(100, this);
	private static MineTimer instance = null;
	private double sec;
	private int min;

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
		setMin(0);
		timer.restart();
	}

	public void stop() {
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		setSec(getSec() + 0.1);

		if (getSec() > 60) {
			setSec(0);
			setMin(getMin() + 1);
		}
		instance.setText("Time: " + getMin() + ":" + (int)getSec());
		repaint();

	}

	public double getSec() {
		return sec;
	}

	public void setSec(double sec) {
		this.sec = sec;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
}
