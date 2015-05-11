package bicycleGarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class AddUserButton extends JButton implements ActionListener{

	public AddUserButton(){
		super("Lägg till Användarkonto");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
