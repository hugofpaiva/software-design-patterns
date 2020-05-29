package relatorio_command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;



public abstract class Command {
	protected ArrayList<KeyPressed> keysCommands = new ArrayList<KeyPressed>(); 
	
	public abstract void execute();
	
	public abstract void unexecute();
}

public class KeyPressed implements KeyListener {
	
	
    @Override
    public void keyPressed(KeyEvent e){
    	
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

public class  implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
