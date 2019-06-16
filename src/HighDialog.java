import javax.swing.JDialog;
import javax.swing.JScrollPane;

/**
 * Hochschule Flensburg
 * Vorlesung Objektorientierte Programmierung
 * Medieninformatik Sommersemester 2019
 * @author Arnold Willemer
 */
public class HighDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	HighDialog() {
		this.setSize(200, 300);
		add(new JScrollPane(new HighJTable(new HighModel())));
		this.setVisible(true);
	}
}