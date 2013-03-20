package lab8mdd;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author S401544
 */
public class Lab8MDD
{

	public static void main(String[] args) throws FileNotFoundException
	{


//		playBehadments();
//		playAcrostics();
//              playGhosts();
                playCountdown();
            
               
	}
	/*
	 * runs the Behadments game
	 */

	public static void playBehadments() throws FileNotFoundException
	{
		Beheadments beheadmentsPlayer1 = new Beheadments();
		beheadmentsPlayer1.processDictionary("dictionary.txt");
		Jarvis jarvis = new Jarvis();
		Jarvis.createDictionary();
		beheadmentsPlayer1.player1();
		jarvis.beheadmentGame();
	}

	public static void playAcrostics() throws FileNotFoundException{
		Acrostics game = new Acrostics();
		game.playAcrostrics();
	}
        
        public static void playGhosts(){
            Ghosts game = new Ghosts();
            game.playGhosts();
        }
        
        
        public static void playCountdown()throws FileNotFoundException {
               Countdown countdownPlayer1 = new Countdown();
               countdownPlayer1.processDictionary("dictionary.txt");
               countdownPlayer1.player1();
        }
}
