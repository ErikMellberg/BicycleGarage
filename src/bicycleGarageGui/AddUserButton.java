package bicycleGarageGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class AddUserButton extends JButton implements ActionListener{

	public AddUserButton(){
		super("L�gg till Anv�ndarkonto");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
