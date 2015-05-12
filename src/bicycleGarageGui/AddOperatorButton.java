package bicycleGarageGui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddOperatorButton extends JButton implements ActionListener{
	private GUI gui;

	public AddOperatorButton(GUI gui){
		super("Lagg till Operatorskonto");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		gui.getDisplayPanel().removeAll();
		gui.getDisplayPanel().updateUI();
		gui.getDisplayPanel().setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();

		
		JLabel idNumber = new JLabel("  Personnummer:  ");
		JTextField idField = new JTextField(15);
		idNumber.setLabelFor(idField);
		idField.setMargin(new Insets(2,2,2,2));
		gui.getDisplayPanel().add(idNumber);
		gui.getDisplayPanel().add(idField);
		
		JLabel pinCode = new JLabel("  PIN-kod:  ");
		JTextField pinField = new JTextField(15);
		pinCode.setLabelFor(pinField);
		pinField.setMargin(new Insets(2,2,2,2));
		gui.getDisplayPanel().add(pinCode);
		gui.getDisplayPanel().add(pinField);
			
		JButton button = new JButton("L�gg till");
		g.anchor = GridBagConstraints.LINE_END;
		g.gridx = 3;
		g.gridy = 1;
		g.insets = new Insets(10,0,0,0);
		gui.getDisplayPanel().add(button, g);
	

		gui.getFrame().pack();
		
	}
}
