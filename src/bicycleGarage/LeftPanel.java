package bicycleGarage;

import java.awt.*;
import javax.swing.*;

public class LeftPanel extends JPanel {

	public LeftPanel(){
		setLayout(new GridLayout(7,1,0,0));
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new AddUserButton());
		add(new EditUserButton());
		add(new DeleteUserButton());
		add(new AddOperatorButton());
		add(new EditOperatorButton());
		add(new DeleteOperatorButton());
		add(new ListUsersButton());
	}
}
