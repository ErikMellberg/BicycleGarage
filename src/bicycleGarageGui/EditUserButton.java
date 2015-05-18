package bicycleGarageGui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EditUserButton extends JButton implements ActionListener {
	GUI gui;

	public EditUserButton(GUI gui) {
		super("Redigera Anvandarkonto");
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		gui.getDisplayPanel().removeAll();
		gui.getDisplayPanel().updateUI();
		gui.getDisplayPanel().setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.FIRST_LINE_END;

		JLabel currentIdNumber = new JLabel("Befintligt Personnummer:  ");
		NumberTextField currentIdField = new NumberTextField(15);
		currentIdNumber.setLabelFor(currentIdField);
		currentIdField.setMargin(new Insets(2, 2, 2, 2));
		g.gridx = 1;
		g.gridy = 0;
		gui.getDisplayPanel().add(currentIdNumber, g);
		g.gridx = 2;
		g.insets = new Insets(0, 0, 30, -40);
		gui.getDisplayPanel().add(currentIdField, g);

		JLabel newIdNumber = new JLabel("Nytt Personnummer:  ");
		NumberTextField newIdField = new NumberTextField(15);
		currentIdNumber.setLabelFor(newIdField);
		newIdField.setMargin(new Insets(2, 2, 2, 2));
		g.gridx = 1;
		g.gridy = 1;
		g.insets = new Insets(0, 0, 0, 0);
		gui.getDisplayPanel().add(newIdNumber, g);
		g.gridx = 2;
		g.insets = new Insets(0, 0, 2, -40);
		gui.getDisplayPanel().add(newIdField, g);

		JLabel newPinCode = new JLabel("Ny PIN-kod:  ");
		NumberTextField newPinField = new NumberTextField(15);
		newPinCode.setLabelFor(newPinField);
		newPinField.setMargin(new Insets(2, 2, 2, 2));
		g.gridx = 1;
		g.gridy = 2;
		g.insets = new Insets(0, 0, 0, 0);
		gui.getDisplayPanel().add(newPinCode, g);
		g.gridx = 2;
		g.insets = new Insets(0, 0, 10, -40);
		gui.getDisplayPanel().add(newPinField, g);

		JButton updateButton = new JButton("Uppdatera");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!currentIdField.getText().equals("")) {

					if (!newIdField.getText().equals("")) {
						if (gui.getDatabase().changeUserId(
								currentIdField.getText(), newIdField.getText())) {
							if (!newPinField.getText().equals("")) {
								gui.getDatabase().changeUserPin(
										newIdField.getText(),
										newPinField.getText());
							}
							gui.getDatabase().save();
							currentIdField.setText(" ");
							newIdField.setText(" ");
							newPinField.setText(" ");
							updateButton.setText("Klart!");
						}
					} else {				
						if (!newPinField.getText().equals("")) {
							gui.getDatabase().changeUserPin(
									currentIdField.getText(),
									newPinField.getText());
							
							gui.getDatabase().save();
							currentIdField.setText(" ");
							newPinField.setText(" ");
							updateButton.setText("Klart!");
						}
					}
				}
			}
		});
		g.gridx = 2;
		g.gridy = 3;
		g.insets = new Insets(0, 0, 30, -40);
		gui.getDisplayPanel().add(updateButton, g);
		
		JLabel bicycleNumber = new JLabel("Antal:");
		NumberTextField bicycleField = new NumberTextField(10);
		bicycleNumber.setLabelFor(bicycleField);
		bicycleField.setMargin(new Insets(2, 2, 2, 2));
		g.gridx = 0;
		g.gridy = 4;
		g.insets = new Insets(3, 0, 0, -52);
		gui.getDisplayPanel().add(bicycleNumber, g);
		g.gridx = 1;
		g.insets = new Insets(2, 0, 0, -25);
		gui.getDisplayPanel().add(bicycleField, g);

		JButton addButton = new JButton("  Registrera cykel  ");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!bicycleField.getText().equals("") && !currentIdField.getText().equals("")){
					long num = (long) bicycleField.getValue();
					boolean trueId = false;
					for(long i = 0; i < num; i++){
						if (gui.getDatabase().addBicycle(currentIdField.getText())){
							trueId = true;
						}
					}
					if (trueId){
					gui.getDatabase().save();
					currentIdField.setText(" ");
					bicycleField.setText(" ");
					addButton.setText("Klart!");
					}
				}

			}
		});
		g.gridx = 2;
		g.gridy = 4;
		g.insets = new Insets(0, 0, 5, -40);
		gui.getDisplayPanel().add(addButton, g);

		JLabel bicycleBarCode = new JLabel("Streckkod:");
		NumberTextField barCodeField = new NumberTextField(10);
		bicycleBarCode.setLabelFor(barCodeField);
		barCodeField.setMargin(new Insets(2, 2, 2, 2));
		g.gridx = 0;
		g.gridy = 5;
		g.insets = new Insets(3, 0, 0, -52);
		gui.getDisplayPanel().add(bicycleBarCode, g);
		g.gridx = 1;
		g.insets = new Insets(2, 0, 0, -25);
		gui.getDisplayPanel().add(barCodeField, g);

		JButton deleteButton = new JButton("Avregistrera cykel");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!barCodeField.getText().equals("") && !currentIdField.getText().equals("")){
						if (gui.getDatabase().removeBicycle(currentIdField.getText(), barCodeField.getText())){
							gui.getDatabase().save();
							currentIdField.setText(" ");
							barCodeField.setText(" ");
							deleteButton.setText("Klart!");							
					}
				}
				
			}
		});
		g.gridx = 2;
		g.gridy = 5;
		g.insets = new Insets(0, 0, 0, -40);
		gui.getDisplayPanel().add(deleteButton, g);

		gui.getFrame().pack();

	}
}
