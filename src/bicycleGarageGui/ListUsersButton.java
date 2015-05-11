package bicycleGarageGui;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import bicycleGarage.Database;

public class ListUsersButton extends JButton implements ActionListener{
	private GUI gui;

	public ListUsersButton(GUI gui){
		super("Lista Anvandare och Cyklar");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		gui.getDisplayPanel().removeAll();
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		gui.getDisplayPanel().add(textArea);
		textArea.setMargin(new Insets(20,20,20,20));
		textArea.setText(gui.getDatabase().listUsers());
	}
}
