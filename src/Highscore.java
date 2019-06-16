import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Properties;

public class Highscore extends ArrayList<Score> {

	private static final long serialVersionUID = 1L;

	private static String FILE = "highscore.cfg";

	private static Highscore instance = null;

	private Highscore() {

	}

	public static Highscore getInstance() {
		if (instance == null) {
			instance = new Highscore();
			instance.load();
		}
		return instance;
	}

	@Override
	public boolean add(Score score) {
		boolean ok = super.add(score);
		// Aufruf der Collection Frame sort-Methode. Diese benoetigt
		// als Parameter einen Comparator, da sich nicht von selbst
		// ergibt, wie ein Score zu sortieren ist.
		this.sort(new Comparator<Score>() {

			// Die Methode compare legt die Reihenfolge fest, indem sie
			// beim Vergleich zweier Scores -1, 0 oder +1 zurueckgibt.
			@Override
			public int compare(Score arg0, Score arg1) {
				int erg = 0;
				// Die Sortierreihenfolge ergibt sich aus den Sekunden
				if (arg0.getSec() < arg1.getSec())
					erg = -1;
				else if (arg0.getSec() > arg1.getSec())
					erg = 1;
				return erg;
			}
		});
		return ok;
	}

	public void store() {
		// Die ArrayList fuellt die Properties
		Properties prop = new Properties();
		for (int i = 0; i < Highscore.getInstance().size(); i++) {
			Score score = Highscore.getInstance().get(i);
			prop.setProperty("" + i, score.toString());
		}
		// ab damit in die Datei
		try {
			prop.store(new FileOutputStream(FILE), "huhu");
		} catch (IOException e) {
			e.printStackTrace(); // gibt eine Fehlermeldung in der Konsole
		}
	}

	public void load() {
		instance.clear(); // Bisherige Tabelle leeren

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(FILE)); // lese Datei
			// Hole alle Elemente über die Schluesselmenge
			for (Object obj : prop.keySet()) {
				// Schlueesel und Wert einlesen
				String key = (String) obj;
				String wert = prop.getProperty(key);
				if (wert != null) {
					Score score = new Score(wert);
					add(score);
				}
			}
		} catch (FileNotFoundException e) {
			// Alles halb so wild. Die Datei gibt es noch nicht.
		} catch (IOException e) {
			e.printStackTrace(); // gibt eine Fehlermeldung in der Konsole
		}
	}
}
