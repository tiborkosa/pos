package ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import buttons.LoginButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JTextField textField;
	
	public LogInPanel(ActionListener listener) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(new Color(0,0,0,0));
		setLayout(new GridBagLayout());
		setOpaque( false );
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.ipady =1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(8, 0, 8, 0);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setColumns(10);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("Verdana", Font.BOLD, 17));
        add(textField,gbc);
        
        gbc.ipady =0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        
        JPanel p = new JPanel(new GridLayout(3, 3, 2, 2));
        p.setBackground(new Color(0,0,0,0));
		for(int i = 1; i < 10; i++) {
			JButton btn = new LoginButton(Integer.toString(i));
			
			btn.setSize(new Dimension(175, 120));
			btn.addActionListener(actionListener);
			p.add(btn);
		}
		
		add(p,gbc);
		
		gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weighty = 0.5;
        gbc.insets = new Insets(2, 0, 2, 2);
        
        JButton btn_zero = new LoginButton("0");
		btn_zero.addActionListener(actionListener);
		add(btn_zero,gbc);
		
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
        gbc.gridy = 2;
        
        JButton btn_enter = new LoginButton("Enter");
		try {
			btn_enter.addActionListener( listener);
		} catch (Exception e) {
			System.out.println("Listener was not set for log in");
		}
		add(btn_enter,gbc);
	}


	ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = textField.getText();
			// only allow to input 4 digits
			if(s.length() < 4) {
				StringBuilder sb = new StringBuilder(s);
				sb.append(e.getActionCommand());
				textField.setText(sb.toString());
			}
		}
	};
	
	public interface LogInListener extends ActionListener {
		//use built in action performed method
	}
}
