import javax.swing.JTable;

/**
 * Hochschule Flensburg Vorlesung Objektorientierte Programmierung
 * Medieninformatik Sommersemester 2019
 * 
 * @author Arnold Willemer
 */
public class HighJTable extends JTable {

	
	private static final long serialVersionUID = 1L;

	public HighJTable(HighModel highModel) {
		super(highModel);
	}

}
