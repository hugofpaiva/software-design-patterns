package relatorio_command;

public interface Command {
	public void execute();

	public void unexecute();
}

class GoRightCommand implements Command {
	private MazePanel mp;

	public GoRightCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.setStart(mp.getStart() + 1);
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.setStart(mp.getStart() - 1);
		mp.repaint();

	}
}

class GoLeftCommand implements Command {
	private MazePanel mp;

	public GoLeftCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.setStart(mp.getStart() - 1);
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.setStart(mp.getStart() + 1);
		mp.repaint();

	}
}

class GoUpCommand implements Command {
	private MazePanel mp;


	public GoUpCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.setEnd(mp.getEnd() + 1);
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.setEnd(mp.getEnd() - 1);
		mp.repaint();

	}
}

class GoDownCommand implements Command {
	private MazePanel mp;

	public GoDownCommand(MazePanel mp) {
		this.mp = mp;
	}

	@Override
	public void execute() {
		mp.setEnd(mp.getEnd() - 1);
		mp.repaint();

	}

	@Override
	public void unexecute() {
		mp.setEnd(mp.getEnd() + 1);
		mp.repaint();

	}
}

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