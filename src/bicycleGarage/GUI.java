package bicycleGarage;

import java.awt.*;
import java.util.Locale;
import javax.swing.*;

public class GUI {	
  
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	
	public GUI() {	
		
		JFrame frame = new JFrame("Garage Manager");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Locale.setDefault(new Locale("en"));
		
		leftPanel = new LeftPanel();
		rightPanel = new RightPanel();
		
		frame.add(leftPanel, BorderLayout.WEST);
		frame.add(rightPanel, BorderLayout.EAST);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
