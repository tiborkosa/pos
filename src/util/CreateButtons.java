package util;

import models.MenuItem;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import models.MenuCategory;
import models.MenuCategoryList;
import models.MenuItemList;

public class CreateButtons {
	
	private static MenuItemList menuItemList = new MenuItemList();
	private static MenuCategoryList menuCategoryList = new MenuCategoryList();
	
	private static String delimiter = ","; // delimiter
	
	public CreateButtons() {
	}
	
	public void create(String s, int row) {
		
		try {
			
			String[] array = s.strip().split(delimiter);
			if (array.length == 3) {
				// converting to objects
				int num = Integer.parseInt(array[0]);
				String desc = array[1];
				Double dobObj = Double.parseDouble(array[2]);
				// creating item objects(id, desc, price)
				menuItemList.addItem(new MenuItem(num, desc, dobObj));
			} else {
				int num = Integer.parseInt(array[0]);
				String desc = array[1];
				menuCategoryList.addItem(new MenuCategory(num, desc)); // creating an object for the left buttons
				//leftPaneItems.add(x); // capturing button number
				//centerP.add(new JPanel()); // creating a new panel that will change if we click LeftItems
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException error) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane
					.showMessageDialog(null,
							"An unexpected error has occurred!\nCheck your text file in row: " + (row + 1) + "\n\n"
									+ "Posible issue:\nMissing 2x(,) within lines.",
							"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}
