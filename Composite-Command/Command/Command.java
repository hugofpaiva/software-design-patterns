package exemplo_command;

// Interface que implementa o padrão Command
public interface Command {
	public void execute();

	public void unexecute();
}

// Comando que permite ir para a direita
class GoRightCommand implements Command {
	private MazePanel mp;

	public GoRightCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.setX(mp.getX() + 1);
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.setX(mp.getX() - 1);
		mp.repaint();

	}
}

//Comando que permite ir para a esquerda
class GoLeftCommand implements Command {
	private MazePanel mp;

	public GoLeftCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.setX(mp.getX() - 1);
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.setX(mp.getX() + 1);
		mp.repaint();

	}
}

//Comando que permite ir para cima
class GoUpCommand implements Command {
	private MazePanel mp;


	public GoUpCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.setY(mp.getY() + 1);
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.setY(mp.getY() - 1);
		mp.repaint();

	}
}

//Comando que permite ir para baixo
class GoDownCommand implements Command {
	private MazePanel mp;

	public GoDownCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.setY(mp.getY() - 1);
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.setY(mp.getY() + 1);
		mp.repaint();

	}
}

//Comando que permite resolver o labirinto
class SolveItCommand implements Command {
	private MazePanel mp;

	public SolveItCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.autoSolve();
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.unSolve();
		mp.repaint();
	}
}