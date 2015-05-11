package bicycleGarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ListUsersButton extends JButton implements ActionListener{

	public ListUsersButton(){
		super("Lista Användare och Cyklar");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
