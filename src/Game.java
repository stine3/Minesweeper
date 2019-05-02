
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
				System.out.print(matchfield[x][y]);
			}
			System.out.println();
		}
	}

}