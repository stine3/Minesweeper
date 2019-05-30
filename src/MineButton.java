
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MineButton extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private MinePanel panel;

	public MineButton(MinePanel panel) {
		this.panel = panel;
		setLayout(new FlowLayout());
		JButton restart = new JButton("New Game");
		add(restart);
		restart.addActionListener(this); 

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		panel.restart();
	}

}
