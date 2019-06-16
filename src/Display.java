import java.awt.Graphics;

public class Display {

	public static final int X = 6;
	public static final int Y = 6;
	public static int sideLength = 50;
	public static final int frameX = X * sideLength;
	public static final int frameY = Y * sideLength;

	private char[][] matchfield = new char[X][Y];

	public static final char EMPTY = ' ';
	public static final char MINE = '#';
	public static final char EMPTY_CLICKED = '-';
	public static final char MARKED = '!';

	Mines mineField = new Mines();

	public Display() {
		for (int x = 0; x < X; x++) {
			for (int y = 0; y < Y; y++) {
				matchfield[x][y] = EMPTY;
			}
		}
	}

	public int countTiles() {
		int amount = X * Y;
		for (int x = 0; x < X; x++) {
			for (int y = 0; y < Y; y++) {
				if (matchfield[x][y] == EMPTY) {
					amount--;
				}
			}
		}
		return amount;
	}

	public int countMarked() {
		int result = 0;
		for (int x = 0; x < X; x++) {
			for (int y = 0; y < Y; y++) {
				if (matchfield[x][y] == MARKED) {
					result++;
				}
			}
		}
		return result;
	}

	public char get(int x, int y) {
		return matchfield[x][y];
	}

	public void set(int x, int y, char z) {
		matchfield[x][y] = z;
	}

	// marks field with a ! but only possible if it's empty
	public void markField(int x, int y) {
		if (matchfield[x][y] == EMPTY) {
			matchfield[x][y] = MARKED;
		}
	}



	public void paintGrid(Graphics gr) {
		// horizontal lines
		for (int i = 0; i <= Display.frameY / Display.sideLength; i++) {
			int x = (Display.frameY / Display.Y) * i;
			gr.drawLine(0, x, Display.frameX, x);

		}

		// vertical lines
		for (int i = 0; i <= Display.frameX / Display.sideLength; i++) {
			int y = (Display.frameX / Display.X) * i;
			gr.drawLine(y, 0, y, Display.frameY);
		}
	}

	// fills in the numbers and mines and marks
	public void paintElements(Graphics gr, Game game) {
		for (int x = 0; x < Display.X; x++) {
			for (int y = 0; y < Display.Y; y++) {
				gr.drawString(Character.toString(game.get(x, y)), x * Display.sideLength + 20,
						y * Display.sideLength + 25);
			}
		}
	}

	// checks if the number of tiles you clicked equals the number of total tiles
	// minus the number of mines plus the number of marked to match
	public boolean isWon(Game game) {
		return Display.X * Display.Y - Mines.MINES + game.countMarked() == game.countTiles();
	}

	public boolean isLose(Game game, int x, int y) {
		return game.mineField.isMine(x, y);
	}

	// shows all mines when you lose
	public void paintMines(Graphics gr, Game game) {

		for (int i = 0; i < Mines.MINES; i++) {
			gr.drawString(Character.toString(Display.MINE), game.mineField.get(i).getX() * Display.sideLength + 20,
					game.mineField.get(i).getY() * Display.sideLength + 25);

		}

	}

}
