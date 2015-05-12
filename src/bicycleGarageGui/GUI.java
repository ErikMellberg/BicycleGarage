package bicycleGarageGui;

import java.awt.*;
import java.util.Locale;
import javax.swing.*;
import bicycleGarage.Database;

public class GUI {	
	
	private ButtonPanel buttonPanel;
	private DisplayPanel displayPanel;
	private Database database;
	private JFrame frame;
	
	public GUI(Database database) {	
		
		frame = new JFrame("Garage Manager");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Locale.setDefault(new Locale("en"));
		
		buttonPanel = new ButtonPanel(this);
		displayPanel = new DisplayPanel();
		
		frame.add(buttonPanel, BorderLayout.WEST);
		frame.add(displayPanel, BorderLayout.EAST);
		
		frame.pack();
		frame.setVisible(true);
		this.database = database;		
	}
	
	public DisplayPanel getDisplayPanel(){
		return displayPanel;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public Database getDatabase(){
		return database;
	}
}
