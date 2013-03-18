package lab8mdd;

import java.io.FileNotFoundException;

/**
 * @author S401544
 */
public class Lab8MDD
{

	public static void main(String[] args) throws FileNotFoundException
	{


		playBehadments();


	}
	/*
	 * runs the Behadments game
	 */

	public static void playBehadments() throws FileNotFoundException
	{
		Beheadments beheadmentsPlayer1 = new Beheadments();
		beheadmentsPlayer1.processDictionary("dictionary.txt");
		Jarvis jarvis = new Jarvis();
		jarvis.createDictionary();
		beheadmentsPlayer1.player1();
		jarvis.beheadmentGame();
	}
}
