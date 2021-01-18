package buttons;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class MenuButton extends JButton{
	
	private static final long serialVersionUID = 1L;

	public MenuButton(String text) {
		super(text);
		setPreferredSize(new Dimension(130, 60));
		setFont(new Font("Verdana", Font.BOLD, 14));

		setOpaque(true);
	}
}
