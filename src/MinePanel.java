import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class MinePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Game aGame = new Game();

	private int mX;
	private int mY;
	// 0 = game is running, 1 = can't lose when marking mines, 2 = game has ended
	// state = 1 because there is a bug where you lose when theres a mine at 0,0
	// when the game starts
	private int state = 1;
	
	public MinePanel(Game game) {

		aGame = game;
		this.addMouseListener(this);
		 aGame.getMineCoor();
	}

	public MineTimer setTimer() {
		return MineTimer.getInstance();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		mX = pos(e.getX());
		mY = pos(e.getY());

		aGame.countTiles();
		aGame.countMarked();

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
		setBackground(Color.WHITE);

		aGame.paintGrid(gr);
		aGame.paintElements(gr, aGame);

		if (state != 1 && aGame.isLose(aGame, mX, mY)) {
			
			aGame.paintMines(gr, aGame);
			setBackground(Color.RED);
			state = 2;
		} else if (aGame.isWon(aGame)) {
			setBackground(Color.GREEN);
			state = 2;
		}

		if (state == 2) {
			this.removeMouseListener(this); 
			setTimer().stop();
		}
	}

	public int pos(int x) {
		return Math.floorDiv(x, Display.sideLength);
	}

	public void restart() {
		state = 1;
		this.addMouseListener(this);
		setTimer().restart();
		aGame = new Game();
		repaint();
		setBackground(Color.WHITE);
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
