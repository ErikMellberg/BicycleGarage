package bicycleGarageGui;

import java.awt.*;
import javax.swing.*;
import bicycleGarage.Database;

public class ButtonPanel extends JPanel {

	public ButtonPanel(GUI gui){
		setLayout(new GridLayout(7,1,0,0));
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new AddUserButton(gui));
		add(new EditUserButton());
		add(new DeleteUserButton());
		add(new AddOperatorButton());
		add(new EditOperatorButton());
		add(new DeleteOperatorButton());
		add(new ListUsersButton(gui));
	}
}
