package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buttons.MenuButton;
import models.MenuCategory;
import models.MenuCategoryList;

public class POSMenuPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ShowCenterPanelsListener listener;
	
	public POSMenuPanel(){
		this.listener = null;
		setLayout(new GridBagLayout());
		setBackground(new Color(0,0,0,220));
		setBorder(new EmptyBorder(5,25,5,25));
	}
	
	public void init() {
		if(this.listener == null) throw new IllegalStateException("Listener is not set for POSMenuPanel!");
		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        int n = 0;
        gbc.insets = new Insets(8, 8, 8, 8);
		for(MenuCategory cat: MenuCategoryList.getMenuCategoryList()) {
			JButton btn = new MenuButton(cat.getDesc());
			gbc.gridy = n++;
			btn.putClientProperty( "menu", cat.getDesc() );
			btn.addActionListener(this);
			add(btn, gbc);
		}
	}
	
	
	public void setShowCenterPanelsListener(ShowCenterPanelsListener listener) {
		this.listener = listener;
	}
	
	public interface ShowCenterPanelsListener {
		public void onMenuClicked(String menuName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listener.onMenuClicked((String) ((JComponent) e.getSource()).getClientProperty("menu"));
	}

}
