
public class Mines {

	private java.util.Random random = new java.util.Random();
	public static final int MINES = 4;
	private Mine[] mineAr = new Mine[MINES];

	// creates an array of mines with random coordinates
	// 15-17 prevents multiple mines on the same coordinate
	public Mines() {
		for (int i = 0; i < MINES; i++) {
			int x = random.nextInt(Display.X);
			int y = random.nextInt(Display.Y);
			mineAr[i] = new Mine(x, y);
			for (int j = 0; j < i; j++) {
				if (mineAr[i].equals(mineAr[j])) {
					i--;
				} 
			}
		}
	}

	public Mine get(int index) {
		return mineAr[index];
	}

	// checks if there is a mine at x, y
	public boolean isMine(int x, int y) {

		boolean result = false;
		for (int i = 0; i < MINES; i++) {
			if (mineAr[i].getX() == x && mineAr[i].getY() == y)
				result = true;
		}

		return result;
	}

}
