package thread;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame("test frame");
		JButton jb = new JButton("submit");
		jb.setBounds(130, 100, 100, 40);
		jf.add(jb);
		jf.setSize(400, 500);
		jf.setLayout(null);
		jf.setVisible(true);
	}
}
