import java.awt.BorderLayout;

import javax.swing.JFrame;


// still have to put the main in here

public class MineFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MineFrame(Game game) {

		setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, new MinePanel(game));
		this.add(BorderLayout.SOUTH, new MineButton());
		this.setSize(Display.frameX + 6, 37 + Display.frameY + 35); // +6 and +35 because of the toolbar
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
