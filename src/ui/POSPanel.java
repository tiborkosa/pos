package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ui.POSItemsPanel.MenuItemListener;
import ui.POSMenuPanel.ShowCenterPanelsListener;

public class POSPanel extends JPanel implements ShowCenterPanelsListener, MenuItemListener {

	private static final long serialVersionUID = 1L;
	private static POSItemsPanel itemPanel;
	private POSPayPanel payPanel;

	public POSPanel() {
		setLayout(new BorderLayout());

		// set up menu categories panel
		POSMenuPanel menu = new POSMenuPanel();
		menu.setShowCenterPanelsListener(this);
		menu.init();

		itemPanel = new POSItemsPanel();
		itemPanel.setMenuItemListener(this);
		itemPanel.init();

		payPanel = new POSPayPanel();

		add(menu, BorderLayout.WEST);
		add(itemPanel, BorderLayout.CENTER);
		add(payPanel, BorderLayout.EAST);

	}

	@Override
	public void onMenuClicked(String menuName) {
		itemPanel.switchPanel(menuName);
	}

	@Override
	public void onMenuItemClicked(Double price, String desc) {
		payPanel.addItemToCheck(desc, price);
	}

}
