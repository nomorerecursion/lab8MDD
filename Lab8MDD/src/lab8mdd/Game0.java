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
	ArrayList<String> wordsUsed = new ArrayList<String>();

	public void initiateDictionary() throws FileNotFoundException
	{
		Jarvis.createDictionary();
	}

	public void player1() throws FileNotFoundException
	{

		processDictionary("dictionary.txt");
		System.out.println("Player 1 choose your word:");

		Scanner kb = new Scanner(System.in);
		String playerword;

		int computerCount = 0;

		while (score1 < 100 && score2 < 100)
		{
			p1 = true;
			while (p1)
			{
				playerword = kb.nextLine();

				//checks if word is already used in game.
				if (!(wordsUsed.contains(playerword)))
				{
					//count the value of the string characters entered and total
					score1 += (playerword.charAt(0) - 96) +
						(playerword.charAt(1) - 96) +
						(playerword.charAt(2) - 96);

					wordsUsed.add(playerword);
					System.out.println(score1);
					p1 = false;
				} else
				{
					System.out.println("You have already used that word");
				}


			}
			p1 = true;



			//player 2 here
			while (p2)
			{
				playerword = dictionary.get(computerCount); //get a word from the dictionary
				computerCount++;
				//checks if word is already used in game.
				if (!(wordsUsed.contains(playerword)))
				{
					//count the value of the string characters entered and total
					score2 += (playerword.charAt(0) - 96) +
						(playerword.charAt(1) - 96) +
						(playerword.charAt(2) - 96);

					System.out.println(score2);
					wordsUsed.add(playerword);
					System.out.println("Player word is: " + playerword);
					p2 = false;
				} else
				{
					System.out.println("You have already used that word");
				}

			}
			p2 = true;

		}

		if (score1 >= 100)
		{
			System.out.println("Player 2 is the winner!!");
		} else
		{
			System.out.println("Player 1 is the winner!!");
		}
	}

	public void processDictionary(String filename) throws
		FileNotFoundException
	{

		File myFile = new File(filename);
		Scanner fileInput = new Scanner(myFile);


		while (fileInput.hasNextLine())
		{

			String readLine = fileInput.nextLine();
			if (readLine.length() == 3)
			{
				dictionary.add(readLine);

			}

//		for(int i = 0; i < dictionary.size(); i++){
//			System.out.println(dictionary.get(i));
//		}

		}
	}
}
