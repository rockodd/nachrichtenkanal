package nachrichtenkanal;

import java.awt.Container;
import java.awt.List;
import javax.swing.JFrame;

/**
 * @author Ilse Schmiedecke 2004
 *
 * Simple GUI for showing a list of Strings in a
 * scrolling window.
 * To be used wit Informatik 1, Lab Message Channel
 */

public class TextGUI extends JFrame {
	List display = new List(25);

	public TextGUI() {
		Container frame = getContentPane();
		setTitle("String Consumer");
		frame.setSize(80, 200);
		frame.add(display);
		pack();
		setAlwaysOnTop(true);
		setVisible(true);
	}
	public void write(String s) {
		display.add(s);
	}
	// Testmethode:
	public static void main(String[] args) {
		TextGUI window = new TextGUI();
		window.write("first day");
		window.write("second day");
		window.write("third day");
		window.write("forth day");
		window.write("fifth day");
		window.write("sixth day");
		window.write("Sunday!");
	}

}
