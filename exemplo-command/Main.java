package relatorio_command;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Logger actionLogger = new Logger();
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		frame.add(mp);
		
		// Focus para posteriormente o KeyListener ser invocado
		frame.setFocusable(true);
	    frame.requestFocus();
	    frame.addKeyListener(new KeyHandler(actionLogger, mp));
		frame.setVisible(true);

	}
}
