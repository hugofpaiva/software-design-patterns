package exemplo_command;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// Criação do frame do Labirinto
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		frame.add(mp);

		// Focus para posteriormente o KeyListener ser invocado
		frame.setFocusable(true);
		frame.requestFocus();

		// Adição da class que é invocada sempre que uma tecla é permida. Aqui também é
		// visível o Command
		frame.addKeyListener(new KeyHandler(mp));
		frame.setVisible(true);

	}
}
