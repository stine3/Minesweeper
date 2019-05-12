
public class Game extends Display {

	Display display = new Display();

	// shows coordinates of all mines
	public void getCoordinates() {

		for (int i = 0; i < Mines.MINES; i++) {
			System.out.println(mineField.get(i).getX() + ", " + mineField.get(i).getY());
		}
	}

	// shows matchfield on console
	public void showMatchfield() {

		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				System.out.print(display.get(x, y));
			}
			System.out.println();
		}

	}

	public void search(int x, int y) {
		if (mineField.isMine(x, y)) {
			display.set(x, y, MINE);
		} else {
			display.set(x, y, (char) countMines(x, y));

			setNeighbors(x, y);

		}
	}

	public void revealZeros(int x, int y) {

		if (countMines(x, y) == '0' && display.get(x, y) == EMPTY) {
			search(x, y);
			revealZeros(x + 1, y);
			revealZeros(x - 1, y);
			revealZeros(x, y - 1);
			revealZeros(x, y + 1);
		} else {
			return;
		}
	}

	public void setNeighbors(int x, int y) {

		if (display.get(x, y) == EMPTY_CLICKED) {
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
					display.set(i, j, countMines(i, j));
				}
			}
		}
	}
}
