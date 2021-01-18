package ui;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class StartPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public StartPanel(ActionListener listener) {
		LogInPanel logInPanel = new LogInPanel(listener);
	    this.setLayout(new GridBagLayout());
	    add(logInPanel);
	    setOpaque(false);
	}
}
