
public class Display {

	public static final int X = 6;
	public static final int Y = 6;
	public static int sideLength = 50;
	public static final int frameX = X * sideLength;
	public static final int frameY = Y * sideLength;

	private static char[][] matchfield = new char[X][Y];

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

		char ergebnis = matchfield[x][y];
		return ergebnis;
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

	public char countMines(int x, int y) {

		char numberMines = '0';

		// prevents that it checks for mines outside of the matchfield array
		// if x, y are at a border, the variables will still stay inside the array
		int xMin = x - 1;
		if (xMin < 0)
			xMin = 0;

		int xMax = x + 1;
		if (xMax > X)
			xMax = X;

		int yMin = y - 1;
		if (yMin < 0)
			yMin = 0;

		int yMax = y + 1;
		if (yMax > Y)
			yMax = Y;

		for (int i = xMin; i <= xMax; i++) {
			for (int j = yMin; j <= yMax; j++) {
				// prevents that you count the x,y field:
				if (x != i || y != j) {
					if (mineField.isMine(i, j))
						numberMines++;
				}
			}
		}
		// if there are no mines nearby, it should stay empty
		if (numberMines == '0') {
			return EMPTY_CLICKED;
		}
		return (char) numberMines;
	}

	// fills in mines or numbers depending on coordinate
	// if field is marked, do not fill in again
//	public void search(int x, int y) {
//		if (mineField.isMine(x, y)) {
//			matchfield[x][y] = MINE;
//		} else {
//			matchfield[x][y] = (char) countMines(x, y);
//		}
//	}
}
