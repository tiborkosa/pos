package models;

import java.util.ArrayList;
import java.util.List;

public class MenuCategoryList {

	private static List<MenuCategory> menuCategoryList;
	
	public MenuCategoryList() {
		MenuCategoryList.menuCategoryList = new ArrayList<>();
	}

	public static List<MenuCategory> getMenuCategoryList() {
		return MenuCategoryList.menuCategoryList;
	}
	
	public void addItem(MenuCategory menuCategory) {
		MenuCategoryList.menuCategoryList.add(menuCategory);
	}

	public void setMenuCategoryList(List<MenuCategory> menuCategoryList) {
		MenuCategoryList.menuCategoryList = menuCategoryList;
	}
	
	public static int getMenuCategoryListSize() {
		return MenuCategoryList.menuCategoryList == null ? 0 : MenuCategoryList.menuCategoryList.size();
	}
}
