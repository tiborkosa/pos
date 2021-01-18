package models;

import java.text.DecimalFormat;

public class Check {

	private double total;
	private final double TAX = 0.07;
	private DecimalFormat myDecimalFormat = new DecimalFormat("#####.##");

	public Check() {
		this.total = 0;
	}
	
	public Check(double total) {
		this.total = total;
	}

	public String getTotal() {
		return myDecimalFormat.format(this.total);
	}

	public String getTax() {
		return myDecimalFormat.format(this.total * TAX);
	}
	
	public Double getTaxDouble() {
		return this.total * TAX;
	}
	
	public double getStateTax() {
		return TAX;
	}

	public String getSubTotal() {
		return myDecimalFormat.format(this.total + getTaxDouble());
	}
	
	public void addMore(Double more) {
		this.total += more;
	}
	
	public void deleteItem(double price) {
		this.total -= price;
	}

}
