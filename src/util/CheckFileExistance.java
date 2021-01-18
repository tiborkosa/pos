package util;

import java.io.File;
import java.io.IOException;

public class CheckFileExistance {

	public CheckFileExistance() {
		
	}
	
	public static File getFileOrCreate(String filePath) {
		
		File file = new File(filePath);    //creates a new file instance  
		boolean exists = file.exists();
		
		if(!exists) {
			file.getParentFile().mkdirs(); // Will create parent directories if not exists
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return file;
		
	}
	
}
