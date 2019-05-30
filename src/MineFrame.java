import java.awt.BorderLayout;

import javax.swing.JFrame;

// still have to put the main in here

public class MineFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	
	
	
	public MineFrame(Game game) {

		MinePanel panel = new MinePanel(game);
		setLayout(new BorderLayout());
		setJMenuBar(new MineMenu());

		this.add(BorderLayout.NORTH, panel.setTimer());
		this.add(BorderLayout.CENTER, panel);
		this.add(BorderLayout.SOUTH, new MineButton(panel));
		this.setSize(Display.frameX + 6, 37 + Display.frameY + 74); // +6 and +58 because of the toolbar, +37 for the
		// button
		this.setTitle("Minesweeper");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void newGame() {
		Game game = new Game();
		new MineFrame(game);
	}

	public static void main(String[] args) {

		// liam is best help
		newGame();
	}

}
