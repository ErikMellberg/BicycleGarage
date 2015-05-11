package bicycleGarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class EditOperatorButton extends JButton implements ActionListener{

	public EditOperatorButton(){
		super("Redigera Operatörskonto");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
