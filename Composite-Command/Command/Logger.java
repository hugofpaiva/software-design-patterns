package exemplo_command;

import java.util.ArrayList;

// Logger vai permitir guardas as ações, em forma de objeto visto que estamos a usar o padrão command, 
// para posteriormente ser possível desfazer ou refazer uma determinada ação
public class Logger {
	private ArrayList<Command> actions = new ArrayList<Command>();
	private int index;

	public void add(Command act) {
		actions.add(act);
		index = actions.size() - 1;
	}

	// Executa a ação do comando seguinte da lista
	public void execute() {
		if (actions.size() > 0 && index < actions.size() - 1) {
			actions.get(++index).execute();
		}
	}

	// Reverte a ação do comando atual da lista
	public void unExecute() {
		if (actions.size() > 0 && index >= 0) {
			actions.get(index--).unexecute();
		}

	}

}
