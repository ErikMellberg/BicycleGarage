package bicycleGarageGui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class DeleteOperatorButton extends JButton implements ActionListener{
	private GUI gui;

	public DeleteOperatorButton(GUI gui){
		super("Ta bort Operatorskonto");
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
		NumberTextField idField = new NumberTextField(15);
		idNumber.setLabelFor(idField);
		idField.setMargin(new Insets(2,2,2,2));	
		g.gridx = 0;
		g.gridy = 0;
		gui.getDisplayPanel().add(idNumber, g);
		g.gridx = 1;
		g.insets = new Insets(0, 0, 2, -40);
		gui.getDisplayPanel().add(idField, g);
			
		JButton button = new JButton("Ta bort");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(gui.getDatabase().removeAdmin(idField.getText())){
					gui.getDatabase().save();
					button.setLabel("Klart!");
					idField.setText(" ");
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
