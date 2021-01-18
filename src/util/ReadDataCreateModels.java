package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ReadDataCreateModels {

	public ReadDataCreateModels(){
		
		CreateButtons createButton = new CreateButtons();
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		int num = 0;
		
		try {
			file = new File(ConstantsUtil.INPUT_FILE);    //creates a new file instance  
			fr = new FileReader(file);   //reads the file  
			br = new BufferedReader(fr);  //creates a buffering character input stream 
			
			String line;  
			while((line=br.readLine())!=null)  {
				createButton.create(line.toString(), num);
				num++;
				}  
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred!\n\nThe text file cannot be found!\nLocate the file, then run it again.",
					"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
