package exemplo_command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Visto que este é invocado sempre que uma tecla é premida, estando visivel o Command,
// squi são identificados os pedidos do utilizador ao premir as teclados. 
// Estes pedidos são encapsulados em objetos, utilizando novamente o Command,
// permitindo assim a criaão de um Logger
public class KeyHandler implements KeyListener {
	private Logger log;
	private Command right;
	private Command left;
	private Command up;
	private Command down;
	private Command solve;
	private int keyboard;

	// Na criação do KeyHandler, é utilizado o padrão Factory para facilitar
	// a criação dos comandos necessários
	public KeyHandler(MazePanel mp) {
		log = new Logger();
		right = CommandFactory.Factory("GoRightCommand", mp);
		left = CommandFactory.Factory("GoLeftCommand", mp);
		up = CommandFactory.Factory("GoUpCommand", mp);
		down = CommandFactory.Factory("GoDownCommand", mp);
		solve = CommandFactory.Factory("SolveItCommand", mp);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	// Ao premir uma tecla, é verificado qual a tecla premida,
	// de modo a executar a ação pretendida.
	// Sempre que é executada uma ação, o objeto responsável por
	// executar essas ação no objeto recetor, implementando o Command, é adicionado
	// ao Logger
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65: // Código correspondente à letra 'a'
		case 37: // Código que corresponde à seta esquerda
			left.execute();
			log.add(left);
			break;
		case 68: // Código correspondente à letra 'd'
		case 39: // Código que corresponde à seta direita
			right.execute();
			log.add(right);
			break;
		case 83: // Código correspondente à letra 'w'
		case 40: // Código que corresponde à seta de cima
			up.execute();
			log.add(up);
			break;
		case 87: // Código correspondente à letra 's'
		case 38: // Código que corresponde à seta de baixo
			down.execute();
			log.add(down);
			break;
		case 32: // Código correspodente ao espaço
			solve.execute();
			log.add(solve);
			break;
		case 157: // Código correspondente ao command
			keyboard += 157;
			break;
		case 16: // Código correspondente ao SHIFT
			keyboard += 16;
			break;
		case 90: // código correspondete ao Z
			if (keyboard == 157) // No caso de ser Command+Z
				log.unExecute();
			else if (keyboard == 173) // No caso de ser Command+SHIT+Z
				log.execute();
			break;
		default:
			break;
		}

	}

	// Quando as teclas Command e SHIFT são libertadas, é substraido o seu código ao
	// atributo keyboard que ajuda a verificar que conjunto de teclas está a ser
	// premido
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 157:
			keyboard -= 157;
			break;
		case 16:
			keyboard -= 16;
			break;
		default:
			break;
		}

	}

}
