package bicycleGarageGui;

import java.awt.*;
import javax.swing.*;

public class DisplayPanel extends JPanel {
	
	public DisplayPanel(){
		setLayout(new GridLayout(1,1));
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(400, 300);
	}

}
