package relatorio_command;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import relatorio_command.MazeWithGraphics.MazePanel;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		frame.add(mp);
		frame.setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mp.setStart(2);
		mp.repaint();
		
	}
}
