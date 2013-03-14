package lab8mdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Matt Seipel
 */
public class Acrostics 
{
	
	private String wordIn;
	/**
	 * Create the Acrostics game board (in progess)
	 * @param wordIn 
	 */
	public Acrostics(String wordIn){
		this.wordIn = wordIn.toUpperCase();
		createGameBoard();
		Jarvis.createDictionary();
	}
	
	/**
	 * Default 
	 */
	public Acrostics(){
		super();
	}
			
	private void createGameBoard(){
		for(int i=1; i<wordIn.length()+1; i++){
			System.out.println(wordIn.charAt(i-1) + "-----" 
				+ wordIn.charAt(wordIn.length()-i));
		}
	}
}
