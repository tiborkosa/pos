package models;

public class MenuCategory {
	
	private String desc;
	private int num;

	public MenuCategory(int num, String desc) {
		this.num = num;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public int getNumber() {
		return this.num;
	}
}
