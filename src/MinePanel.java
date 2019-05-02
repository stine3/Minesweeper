import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class MinePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	Game aGame = new Game();

	public MinePanel(Game game) {
		aGame = game;
		this.addMouseListener(this);
		aGame.getCoordinates();
	}

	private int mX;
	private int mY;
	// 0 = game is running, 1 = can't lose when marking mines
	private int state = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		mX = pos(e.getX());
		mY = pos(e.getY());

		aGame.countTiles();
		aGame.countMarked();
		//System.out.println(aGame.countTiles());
		//System.out.println(aGame.countMarked());

		if (e.getButton() == MouseEvent.BUTTON3) {
			aGame.markField(mX, mY);
			state = 1;
		} else {
			aGame.search(mX, mY);
			state = 0;
		}

		repaint();
	}

	@Override
	public void paint(Graphics gr) {

		super.paint(gr);

		// horizontal lines
		for (int i = 0; i <= this.getHeight() / Display.sideLength; i++) {
			int x = (this.getHeight() / Display.Y) * i;
			gr.drawLine(0, x, this.getWidth(), x);

		}

		// vertical lines
		for (int i = 0; i <= this.getWidth() / Display.sideLength; i++) {
			int y = (this.getWidth() / Display.X) * i;
			gr.drawLine(y, 0, y, this.getHeight());
		}

		// fills in the numbers and mines and marks
		for (int x = 0; x < Display.X; x++) {
			for (int y = 0; y < Display.Y; y++) {
				gr.drawString(Character.toString(aGame.get(x, y)), x * Display.sideLength + 20,
						y * Display.sideLength + 25);
			}
		}

		// fills in all mines when you click one, you lose
		if (state != 1) {
			if (aGame.mineField.isMine(mX, mY)) {
				for (int i = 0; i < aGame.mineField.MINES; i++) {
					gr.drawString(Character.toString(aGame.MINE),
							aGame.mineField.get(i).getX() * Display.sideLength + 20,
							aGame.mineField.get(i).getY() * Display.sideLength + 25);
					setBackground(Color.RED);
					// if you lose, the MouseListener gets removed so you can't keep playing
					this.removeMouseListener(this);
				}
			}
		}

		// checks if the number of tiles you clicked equals the number of total tiles
		// minus the number of mines plus the number of marked to match
//		if (aGame.countMarked() != 0) {

			if (Display.X * Display.Y - aGame.mineField.MINES + aGame.countMarked() == aGame.countTiles()) {
				setBackground(Color.GREEN);
				this.removeMouseListener(this);
			}

	}

	public int pos(int x) {
		return Math.floorDiv(x, Display.sideLength);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
