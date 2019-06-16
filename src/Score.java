
public class Score {

	private String player;
	private int sec;
	
	public Score(String name, int sec) {
		this.player = name;
		this.sec= sec;
	}
	
	public Score(String name) {
		String[] str = name.split(":");
		player = str[0];
		try {
		sec = Integer.parseInt(str[1]);
		} catch (NumberFormatException e) {
		}
	}
	
	public String toString() {
		return player + ":" + sec;
	}
	
	public String getName() {
		return player;
	}
	
	public int getSec() {
		return sec;
	}
	
}
