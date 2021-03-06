package bicycleGarageGui;

import java.awt.*;
import javax.swing.*;
import bicycleGarage.Database;

public class ButtonPanel extends JPanel {

	public ButtonPanel(GUI gui){
		setLayout(new GridLayout(7,1,0,0));

		add(new AddUserButton(gui));
		add(new EditUserButton(gui));
		add(new DeleteUserButton(gui));
		add(new AddOperatorButton(gui));
		add(new EditOperatorButton(gui));
		add(new DeleteOperatorButton(gui));
		add(new ListUsersButton(gui));
	}
}
