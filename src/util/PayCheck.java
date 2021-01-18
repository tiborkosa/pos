package util;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.ListModel;

import models.Check;

public class PayCheck {

	private static  FileWriter myFileWriter = null;

	PayCheck() {
	}


	// this will loop around until the correct price was added
	public static void pay(String subTotal) {
		String money = JOptionPane.showInputDialog("You owe: " + subTotal + "\n\nEnter amount");
		try {
			double parsedMoney = Double.parseDouble(money.trim());
			double remainder = parsedMoney - Double.parseDouble(subTotal);
			if(remainder >= 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, ("Your change is: $" + new DecimalFormat("#####.##").format(remainder)));
			} else {
				JOptionPane.showMessageDialog(null, "Please enter more or even of the amount due");
				pay(subTotal);
			}
		} catch (NumberFormatException e) {
			e.getMessage();
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Please enter more or even of the amount due");
			pay(subTotal);
		}
	}

	public static void printCheck(ListModel<String> list, Check check) {

		File file = CheckFileExistance.getFileOrCreate(ConstantsUtil.CHECK_FILE);    //creates a new file instance  
		
		try {
			myFileWriter = new FileWriter(file);
			for (int i = 0; i < list.getSize(); i++)
				myFileWriter.write(list.getElementAt(i) + "\n");
			myFileWriter.write("------------------------------\n");
			myFileWriter.write("Total: " + check.getTotal() + "\n");
			myFileWriter.write("Tax: " + check.getTax() + "\n");
			myFileWriter.write("Sub Total: " + check.getSubTotal() + "\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				myFileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		JOptionPane.showMessageDialog(null, "Thank You");

	}
}
