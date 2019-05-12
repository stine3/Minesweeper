
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MineButton extends JPanel {

	public MineButton() {

		// doesn't work yet
		setLayout(new FlowLayout());
		this.add(new JButton("New Game"));

	}

}
