package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.MenuItem;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buttons.MenuButton;
import models.MenuCategory;
import models.MenuCategoryList;
import models.MenuItemList;

public class POSItemsPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CardLayout layers = new CardLayout();
	private MenuItemListener listener;
	
	public POSItemsPanel() {
		
	}

	public void init() {
		int numberOfPanels = MenuCategoryList.getMenuCategoryListSize();
		setLayout(layers);
		if(numberOfPanels > 0) {
			int index = 0;
			for(MenuCategory cat: MenuCategoryList.getMenuCategoryList()) {
				int prev = cat.getNumber();
				JPanel panel = new JPanel();
				panel.setBackground(new Color(0,0,0,200));
				panel.setLayout(new FlowLayout());
				panel.setBorder(new EmptyBorder(40, 40, 40, 40));
				// since the list is ordered by menu
				for(int i = index; i < MenuItemList.getMenuItemsSize(); i++) {
					MenuItem item = MenuItemList.getMenuItemList().get(i);
					if(prev == item.getItemId()) {
						JButton btn = new MenuButton(item.getDesc());
						btn.setPreferredSize(new Dimension(190, 40));
						btn.putClientProperty( "price", item.getPrice() );
						btn.addActionListener(this);
						panel.add(btn);
					} else {
						index = i;
						break;
					}
				}
				add(panel, cat.getDesc());
			}
		}
	}
	
	public void switchPanel(String panelName) {
		layers.show(this, panelName);
	}
	
	public void setMenuItemListener(MenuItemListener listener) {
		this.listener = listener;
	}
	
	public interface MenuItemListener {
		public void onMenuItemClicked(Double price, String desc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listener.onMenuItemClicked(
				(Double) ((JComponent) e.getSource()).getClientProperty("price"), 
				((JButton) e.getSource()).getActionCommand());
	}
	
}
