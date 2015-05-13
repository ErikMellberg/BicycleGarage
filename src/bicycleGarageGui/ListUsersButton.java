package bicycleGarageGui;

import java.awt.GridLayout;
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
		gui.getDisplayPanel().setLayout(new GridLayout(1,1));
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		gui.getDisplayPanel().add(textArea);
		textArea.setMargin(new Insets(15,15,15,15));
		textArea.setText(gui.getDatabase().listUsers());
		gui.getFrame().pack();
	}
}
