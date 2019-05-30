
public class Game extends Display {


	// shows coordinates of all mines
	public void getMineCoor() {

		for (int i = 0; i < Mines.MINES; i++) {
			System.out.println(mineField.get(i).getX() + ", " + mineField.get(i).getY());
		}
	}


	// shows matchfield on console
	public void showMatchfield() {

		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				System.out.print(get(x, y));
			}
			System.out.println();
		}

	}
	public char countMines(int x, int y) {

		char numberMines = '0';

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i >= 0 && i < X && j >= 0 && j < Y) {
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
	

	public void search(int x, int y) {
		if (mineField.isMine(x, y)) {
			set(x, y, MINE);
		} else if (get(x, y) == EMPTY || get(x, y) == MARKED) {
			set(x, y, (char) countMines(x, y));
			if (countMines(x, y) == EMPTY_CLICKED)
				revealEmpty(x, y);

		}
	}


	public void revealEmpty(int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i >= 0 && i < X && j >= 0 && j < Y) {
					search(i, j);
				}
			}
		}
	}
}
