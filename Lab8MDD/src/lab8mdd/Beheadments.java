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
	ArrayList<String> player1Array = new ArrayList<String>();
	
	
	public void player1(){
		Scanner input = new Scanner(System.in);
		String player1;
		System.out.println("Enter as many words as you can seperated with a comma starting now: ");
		player1 = input.nextLine();
		
		String[] temp = player1.split(", ");
		for(int i = 0; i < temp.length; i++){
			player1Array.add(temp[i]);
		}
		
		for(int i = 0; i < player1Array.size(); i++){
			System.out.print(player1Array.get(i) + " ");
		}
	}
	
	
	
	
	
	/*
	 * adds all the elements of the file to an arrayList
	 */
	public void processDictionary(String filename)throws FileNotFoundException {
		
		File myFile = new File(filename);
		Scanner fileInput = new Scanner(myFile);
		 
		
		while(fileInput.hasNextLine()){
			String readLine = fileInput.nextLine();
			
				dictionary.add(readLine);
			
		}
		
		for(int i = 0; i < dictionary.size(); i++){
			System.out.println(dictionary.get(i));
		}
		
		
		
	}
	
	
	
	
	
}
