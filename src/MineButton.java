
import java.awt.BorderLayout;

import javax.swing.JButton;

public class MineButton extends MinePanel {

	public MineButton(Game game) {

		super(game);

		setLayout(new BorderLayout());
		this.add(BorderLayout.SOUTH, new JButton("New Game"));
		this.setSize(100, 500);

	}

}
