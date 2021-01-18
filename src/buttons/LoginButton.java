package buttons;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;

public class LoginButton extends JButton {

	private static final long serialVersionUID = 1L;

	
	public LoginButton(String text) {
		setPreferredSize(new Dimension(85, 29));
		setText(text);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		setBorder(compound);
		setFont(new Font("Verdana", Font.BOLD, 17));
	}

}
