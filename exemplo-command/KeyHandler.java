package relatorio_command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class KeyHandler implements KeyListener {
	Logger log;
	MazePanel mp;
	
	public KeyHandler(Logger log, MazePanel mp) {
		this.log = log;
		this.mp = mp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65: //Código que correspondente à letra 'a'
		case 37: //Código que corresponde à seta esquerda
			mp.setStart(mp.getStart()-1);
			mp.repaint();
			break;
		case 68: //Código correspondente à letra 'd'
		case 39: //Código que corresponde à seta direita
			mp.setStart(mp.getStart()+1);
			mp.repaint();
			break;
		case 83: //Código correspondente à letra 'w'
		case 40: //Código que corresponde à seta de cima
			mp.setEnd(mp.getEnd()+1);
			mp.repaint();
			break;
		case 87: //Código correspondente à letra 's'
		case 38: //Código que corresponde à seta de baixo
			mp.setEnd(mp.getEnd()-1);
			mp.repaint();
			break;
		case 32:
			mp.autoSolve();
			break;

		default:
			System.out.println(e.getKeyCode());
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
