package relatorio_command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	private Logger log;
	private Command right;
	private Command left;
	private Command up;
	private Command down;
	private Command solve;
	private int keyboard;
	
	public KeyHandler(MazePanel mp) {
		log = new Logger();
		right = CommandFactory.Factory("GoRightCommand",mp);
		left = CommandFactory.Factory("GoLeftCommand",mp);
		up = CommandFactory.Factory("GoUpCommand",mp);
		down = CommandFactory.Factory("GoDownCommand",mp);
		solve = CommandFactory.Factory("SolveItCommand",mp);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65: //Código que correspondente à letra 'a'
		case 37: //Código que corresponde à seta esquerda
			left.execute();
			log.add(left);
			break;
		case 68: //Código correspondente à letra 'd'
		case 39: //Código que corresponde à seta direita
			right.execute();
			log.add(right);
			break;
		case 83: //Código correspondente à letra 'w'
		case 40: //Código que corresponde à seta de cima
			up.execute();
			log.add(up);
			break;
		case 87: //Código correspondente à letra 's'
		case 38: //Código que corresponde à seta de baixo
			down.execute();
			log.add(down);
			break;
		case 32: // Código correspodente ao espaço
			solve.execute();
			log.add(solve);
			break;
		case 157: // Código correspondente ao control
			keyboard+=157;
			break;
		case 16: // Código correspondente ao SHIFT
			keyboard+=16;
			break;
		case 90: //código correspondete ao Z
			if(keyboard == 157)
				log.unExecute();
			else if (keyboard == 173)
				log.execute();
			break;
		default:
			System.out.println(e.getKeyCode());
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 157:
			keyboard-=157;
			break;
		case 16:
			keyboard-=16;
			break;
		default:
			break;
		}

	}

}
