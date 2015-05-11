package bicycleGarageGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class DeleteUserButton extends JButton implements ActionListener{

	public DeleteUserButton(){
		super("Ta bort Användarkonto");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
