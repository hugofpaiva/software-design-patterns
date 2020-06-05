package exemplo_command;

// Factory que devolve os objetos que implementam o Command, 
// para serem utilizados ao longo do programa
public class CommandFactory {

	public static Command Factory(String pedido, MazePanel mp) {
		if (pedido.equalsIgnoreCase("GoRightCommand")) {
			return new GoRightCommand(mp);
		} else if (pedido.equalsIgnoreCase("GoLeftCommand")) {
			return new GoLeftCommand(mp);
		} else if (pedido.equalsIgnoreCase("GoUpCommand")) {
			return new GoUpCommand(mp);
		} else if (pedido.equalsIgnoreCase("GoDownCommand")) {
			return new GoDownCommand(mp);
		} else if (pedido.equalsIgnoreCase("SolveItCommand")) {
			return new SolveItCommand(mp);
		} else
			throw new IllegalArgumentException(pedido + " não existente!");
	}

}
