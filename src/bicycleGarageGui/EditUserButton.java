package bicycleGarageGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class EditUserButton extends JButton implements ActionListener{

	public EditUserButton(){
		super("Redigera Anv�ndarkonto");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
