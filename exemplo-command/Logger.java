package relatorio_command;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Logger {
	private ArrayList<Command> actions = new ArrayList<Command>();

	public void add(Command act) {
		actions.add(act);
	}

	// Executa todas as ações guardadas no logger desde a primeira adicionada, atém
	// à última
	public void executeAll() {
		if (actions.size() > 0) {
			ListIterator act = actions.listIterator(actions.size());
			// Iterate in reverse.
			while (act.hasPrevious()) {
				((Command) act.previous()).execute();
			}
		}
	}

	// Desfaz as execuções de todas as ações guardadas no logger desde a última
	// adicionada, até à primeira
	public void unExecuteAll() {
		if (actions.size() > 0) {
			for (Command act : actions) {
				act.unexecute();
			}
		}

	}

}
