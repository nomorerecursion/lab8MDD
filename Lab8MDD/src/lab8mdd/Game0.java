package lab8mdd;
import java.util.*;
import java.io.*;
/**
 * @author s505027
 */
public class Game0  
{
	int score1 = 0;
	int score2 = 0;
	boolean p1;
	boolean p2;
	String userInput1 = "";
	String userInput2 = "";
	String s = " abcdefghijklmnopqrstuvwxyz";
	
	
	Scanner kb = new Scanner(System.in);
	ArrayList<String> dictionary = new ArrayList<String>();
	
	
	public Game0(){
	Jarvis.createDictionary();
	}
	
	
	public Character[] toCharacterArray(String s){
		if (s==null){
			return null;
		}
		
		Character[] array = new Character[s.length()];
		for (int i=1;i<s.length(); i++)
		{
			array[i] = new Character(s.charAt(i));
		}
		return array;
	}
	
	public void player1(){
		
		Scanner kb = new Scanner(System.in);
		String player1;
		String temp;
		player1 = kb.next();	
			
		
		//temp = userInput1.toCharacterArray(player1);
		p2 = true;
		p1 = false;
	}
	
	//if player 1 goes, switch so it is player 2's turn, visa-versa
	//check dictionary if word is in there
	//ues toCharacter array with player 1 and player 2
	//
	
	
}

