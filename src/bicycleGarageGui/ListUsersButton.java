package bicycleGarageGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ListUsersButton extends JButton implements ActionListener{

	public ListUsersButton(){
		super("Lista Anv�ndare och Cyklar");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
