package relatorio_command;

abstract class Command{
	private MazePanel maze;
	
	public Command (MazePanel maz) {
		this.maze=maze;
	}

	public abstract void execute();
	
	public abstract void unexecute();
}

public class goRightCommand extends Command {
	
}
