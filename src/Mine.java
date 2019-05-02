
public class Mine {

	private int x;
	private int y;

	public Mine(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		Mine m = (Mine) o;
		return m.x == x && m.y == y;
	}
}