package bicycleGarageGui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
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
		gui.getDisplayPanel().updateUI();
		gui.getDisplayPanel().setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.FIRST_LINE_END;
	
		JLabel idNumber = new JLabel("Personnummer:  ");
		JTextField idField = new JTextField(15);
		idNumber.setLabelFor(idField);
		idField.setMargin(new Insets(2,2,2,2));	
		g.gridx = 0;
		g.gridy = 0;
		gui.getDisplayPanel().add(idNumber, g);
		g.gridx = 1;
		g.insets = new Insets(0, 0, 2, -40);
		gui.getDisplayPanel().add(idField, g);
		
		JLabel pinCode = new JLabel("PIN-kod:  ");
		JTextField pinField = new JTextField(15);
		pinCode.setLabelFor(pinField);
		pinField.setMargin(new Insets(2,2,2,2));
		g.gridx = 0;
		g.gridy = 1;
		g.insets = new Insets(0, 0, 0, 0);
		gui.getDisplayPanel().add(pinCode, g);
		g.gridx = 1;
		g.insets = new Insets(0, 0, 0, -40);
		gui.getDisplayPanel().add(pinField, g);
			
		JButton button = new JButton("Lägg till");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(gui.getDatabase().addUser(idField.getText(), pinField.getText())){
					gui.getDatabase().save();
					button.setLabel("Klart!");
					idField.setText(" ");
					pinField.setText(" ");
				}
			}
		});
		g.gridx = 1;
		g.gridy = 2;
		g.insets = new Insets(10, 0, 0, -40);
		gui.getDisplayPanel().add(button, g);

		gui.getFrame().pack();
	}
}
