package lab8mdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author s508609
 */
public class Jarvis 
{
	public static ArrayList<String> dictionary= new ArrayList<>();
	
	/**
	 * Reads in the dictionary and creates it in a static variable 
	 */
	public static void createDictionary(){
		try{
			Scanner readDictionary = 
				new Scanner(new File("dictionary.txt"));
			dictionary = new ArrayList<>();
			while(readDictionary.hasNext()){
				dictionary.add(readDictionary.nextLine());
			}
		}
		catch(FileNotFoundException e){
			System.out.println("404: File Not Found");
		}
	}
}
