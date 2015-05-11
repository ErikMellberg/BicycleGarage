package bicycleGarageGui;

import java.awt.*;
import javax.swing.*;

public class RightPanel extends JPanel {
	
	public RightPanel(){
		setLayout(new GridLayout(1,1,0,0));
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(400, 300);
	}

}
