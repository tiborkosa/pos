package models;

public class MenuItem extends MenuCategory {
	
	private int itemId;
	private double price;

	public MenuItem(int id, String desc, double price) {
		super(id,desc);
		this.itemId = id;
		this.price = price;
	}

	public int getItemId() {
		return this.itemId;
	}

	public double getPrice() {
		return this.price;
	}
}