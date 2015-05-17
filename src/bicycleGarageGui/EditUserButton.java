package bicycleGarageGui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EditUserButton extends JButton implements ActionListener{
	GUI gui;

	public EditUserButton(GUI gui){
		super("Redigera Anvandarkonto");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		gui.getDisplayPanel().removeAll();
		gui.getDisplayPanel().updateUI();
		gui.getDisplayPanel().setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.FIRST_LINE_END;
	
		JLabel currentIdNumber = new JLabel("Befintligt Personnummer:  ");
		NumberTextField currentIdField = new NumberTextField(15);
		currentIdNumber.setLabelFor(currentIdField);
		currentIdField.setMargin(new Insets(2,2,2,2));	
		g.gridx = 0;
		g.gridy = 0;
		gui.getDisplayPanel().add(currentIdNumber, g);
		g.gridx = 1;
		g.insets = new Insets(0, 0, 20, -40);
		gui.getDisplayPanel().add(currentIdField, g);
		
		JLabel newIdNumber = new JLabel("Nytt Personnummer:  ");
		NumberTextField newIdField = new NumberTextField(15);
		currentIdNumber.setLabelFor(newIdField);
		newIdField.setMargin(new Insets(2,2,2,2));	
		g.gridx = 0;
		g.gridy = 1;
		g.insets = new Insets(0,0,0,0);
		gui.getDisplayPanel().add(newIdNumber, g);
		g.gridx = 1;
		g.insets = new Insets(0, 0, 2, -40);
		gui.getDisplayPanel().add(newIdField, g);
		
		JLabel newPinCode = new JLabel("Ny PIN-kod:  ");
		NumberTextField newPinField = new NumberTextField(15);
		newPinCode.setLabelFor(newPinField);
		newPinField.setMargin(new Insets(2,2,2,2));
		g.gridx = 0;
		g.gridy = 2;
		g.insets = new Insets(0, 0, 0, 0);
		gui.getDisplayPanel().add(newPinCode, g);
		g.gridx = 1;
		g.insets = new Insets(0, 0, 0, -40);
		gui.getDisplayPanel().add(newPinField, g);
		
			
		JButton updateButton = new JButton("Uppdatera");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(true){
					gui.getDatabase().save();
					currentIdField.setText(" ");
					newPinField.setText(" ");
				}
			}
		});
		g.gridx = 1;
		g.gridy = 3;
		g.insets = new Insets(10, 0, 0, -40);
		gui.getDisplayPanel().add(updateButton, g);
		
		JButton addButton = new JButton("Registrera cykel");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(gui.getDatabase().addUser(currentIdField.getText(), newPinField.getText())){
					gui.getDatabase().save();
					currentIdField.setText(" ");
					newPinField.setText(" ");
				}
			}
		});
		g.gridx = 0;
		g.gridy = 4;
		g.insets = new Insets(20,0,0,-40);
		gui.getDisplayPanel().add(addButton, g);

		
		JButton deleteButton = new JButton("Avregistrera cykel");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(gui.getDatabase().addUser(currentIdField.getText(), newPinField.getText())){
					gui.getDatabase().save();
					currentIdField.setText(" ");
					newPinField.setText(" ");
				}
			}
		});
		g.gridx = 1;
		g.gridy = 4;
		gui.getDisplayPanel().add(deleteButton, g);


		gui.getFrame().pack();
		
	}
}
