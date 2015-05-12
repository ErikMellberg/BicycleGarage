package bicycleGarageGui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddUserButton extends JButton implements ActionListener{	
	private GUI gui;

	public AddUserButton(GUI gui){
		super("Lagg till Anvandarkonto");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		gui.getDisplayPanel().removeAll();
		gui.getDisplayPanel().setSize(0, 0);
		gui.getDisplayPanel().setLayout(new GridBagLayout());
		
		JLabel idNumber = new JLabel("  Personnummer:  ");
		JTextField idField = new JTextField(15);
		idNumber.setLabelFor(idField);
		idField.setMargin(new Insets(2,2,2,2));
		
		JLabel pinCode = new JLabel("  PIN-kod:  ");
		JTextField pinField = new JTextField(15);
		pinCode.setLabelFor(pinField);
		pinField.setMargin(new Insets(2,2,2,2));
		
		gui.getDisplayPanel().add(idNumber);
		gui.getDisplayPanel().add(idField);
		gui.getDisplayPanel().add(pinCode);
		gui.getDisplayPanel().add(pinField);
		gui.getFrame().pack();

	}
}
