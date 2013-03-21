package lab8mdd;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author S401544
 */
public class Lab8MDD {

    public static void main(String[] args) throws FileNotFoundException {
        showMenu();
//		playBeheadments();
//		playAcrostics();
//              playGhosts();
//                playCountdown();
    }
    /*
     * runs the Behadments game
     */

    public static void playBeheadments() throws FileNotFoundException {
        Beheadments beheadmentsPlayer1 = new Beheadments();
        beheadmentsPlayer1.processDictionary("dictionary.txt");
        Jarvis jarvis = new Jarvis();
        Jarvis.createDictionary();
        beheadmentsPlayer1.player1();
        jarvis.beheadmentGame();
    }

    /**
     * Runs Acrostics
     */
    public static void playAcrostics() {
        Acrostics game = new Acrostics();
        game.playAcrostrics();
    }

    /**
	  * 
     * Runs Ghosts
     */
    public static void playGhosts() {
        Ghosts game = new Ghosts();
        game.playGhosts();
    }

    public static void playCountdown() throws FileNotFoundException {
        Countdown countdownPlayer1 = new Countdown();
        countdownPlayer1.processDictionary("dictionary.txt");
        countdownPlayer1.player1();
    }
	 
	 public static void playCenturion() throws FileNotFoundException{
		 Game0 game0player1 = new Game0();
		 game0player1.processDictionary("dictionary.txt");
		 game0player1.player1();
	 }

    /**
     * Create and show the user a menu in which he/she can select a game
     * that they wish to play.  Terminates upon the selection of 5.
     * @throws FileNotFoundException
     */
    public static void showMenu() throws FileNotFoundException {
        Scanner choice = new Scanner(System.in);
        System.out.println("Pick a game, any game: ");
        System.out.println("0. Centurion");
        System.out.println("1. Countdown");
        System.out.println("2. Acrostics");
        System.out.println("3. Beheadments");
        System.out.println("4. Ghosts");
        System.out.println("5. Quit");
        System.out.println();
        System.out.print("Choice: ");
        int selection = choice.nextInt();
        System.out.println();

        switch (selection) {
//            Daniel, this is where your method to initialize your game will go.
           case 0:
                playCenturion();
                showMenu();
                break;
            case 1:
                playCountdown();
                System.out.println();
                showMenu();
                break;
            case 2:
                playAcrostics();
                System.out.println();
                showMenu();
                break;
            case 3:
                playBeheadments();
                System.out.println();
                showMenu();
                break;
            case 4:
                playGhosts();
                System.out.println();
                showMenu();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }


    }
}