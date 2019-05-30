import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MineMenu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem name;
	private JMenuItem quit;

	private JMenuItem help;
	private JMenuItem about;

	private String input;

	public MineMenu() {
		super();
		JMenu main = new JMenu("Minesweeper");
		this.add(main);
		this.open = new JMenuItem("Open...");
		this.save = new JMenuItem("Save As...");
		this.name = new JMenuItem("Name...");
		this.quit = new JMenuItem("Quit");

		main.add(open);
		this.open.addActionListener(this);
		main.add(save);
		this.save.addActionListener(this);
		main.add(name);
		this.name.addActionListener(this);
		main.add(quit);
		this.quit.addActionListener(this);

		this.help = new JMenu("Help");
		this.about = new JMenuItem("About Minesweeper...");
		this.add(help);
		help.add(about);
		this.about.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		if (ev.getSource() == save) {
			JFileChooser files = new JFileChooser();
			if (files.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = files.getSelectedFile();
			}
		}

		if (ev.getSource() == name) {
			String setName = JOptionPane.showInputDialog(null, "Name");
			input = setName;
		}
		if (ev.getSource() == quit) {
			int answer = JOptionPane.showOptionDialog(null, "Are you sure?", "Quit Minesweeper",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if(answer == 0) {
				System.exit(0);
			}
			
		}

	}

}
