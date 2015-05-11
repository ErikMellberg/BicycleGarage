package bicycleGarageGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class DeleteOperatorButton extends JButton implements ActionListener{

	public DeleteOperatorButton(){
		super("Ta bort Operatörskonto");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
