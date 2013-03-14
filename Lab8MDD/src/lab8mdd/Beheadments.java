package lab8mdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author S401544
 */
public class Beheadments 
{

	ArrayList<String> dictionary = new ArrayList<String>();
	
	
	
	
	public void processDictionary(String filename)throws FileNotFoundException {
		
		File myFile = new File(filename);
		Scanner fileInput = new Scanner(myFile);
		 
		
		while(fileInput.hasNextLine()){
			String readLine = fileInput.nextLine();
			
				dictionary.add(readLine);
			
		}
		
		
		
	}
	
	
	
	
	
}
