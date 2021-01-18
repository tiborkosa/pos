package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class POSButton extends JButton{

	private static final long serialVersionUID = 1L;

	public POSButton(String text){
		super(text);
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setFont(new Font("Verdana", Font.BOLD, 14));
		setPreferredSize(new Dimension(90, 60));
		
		setBackground(new Color(60,215,109));
		setForeground(Color.white);
	}
}
