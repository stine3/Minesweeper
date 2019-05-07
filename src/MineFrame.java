import javax.swing.JFrame;

public class MineFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MineFrame(Game game) {
		//BORDERLAYOUT
		
		this.add(new MinePanel(game));
		this.add(new MineButton(game));
		this.setSize(Display.frameX + 6,  25+Display.frameY + 35); // +6 and +35 because of the toolbar
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		

	}

}
