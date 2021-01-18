package models;

import java.util.ArrayList;
import java.util.List;

public class MenuItemList {

	private static List<MenuItem> menuItemList;

	public MenuItemList() {
		MenuItemList.menuItemList = new ArrayList<>();
	}

	public void addItem(MenuItem menuItem) {
		MenuItemList.menuItemList.add(menuItem);
	}

	public static List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		MenuItemList.menuItemList = menuItemList;
	}

	public static int getMenuItemsSize() {
		return MenuItemList.menuItemList == null ? 0 : MenuItemList.menuItemList.size();
	}
}
