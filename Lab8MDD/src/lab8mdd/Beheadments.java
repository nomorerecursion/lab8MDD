package lab8mdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author S401544
 */
public class Beheadments {

    ArrayList<String> dictionary = new ArrayList<String>();
    ArrayList<String> player1Array = new ArrayList<String>();
    ArrayList<String> player1answer = new ArrayList<String>();
    private int playercount = 0;
    int count = 0;
    private long start, stop;

    /*
     * stores player1's answers and adds up there points
     */
    public void player1() {
        Scanner input = new Scanner(System.in);
        String player1;


        start = System.nanoTime();
        System.out.print("Enter as many beheadment words as you can seperated with a comma within a minute starting now: ");
        player1 = input.nextLine();
        stop = System.nanoTime();

        String[] temp = player1.split(", ");
        //stores player1's submission into player1Array
        for (int i = 0; i < temp.length; i++) {
            player1Array.add(temp[i]);
        }

        for (int i = 0; i < player1Array.size(); i++) {
            int counter1 = 0;
            for (int n = 0; n < dictionary.size(); n++) {
                if (dictionary.get(n).equals(player1Array.get(i))) {
                    counter1++;
                }

            }
            if (counter1 != 1) {
                System.out.println(player1Array.get(i) + " is not a word");
                System.out.println("Player 1 score: 0 - Cheated");
                System.exit(0);
            }
        }

        for (int i = 0; i < player1Array.size(); i++) {
            for (int j = i + 1; j < player1Array.size(); j++) {
                if (player1Array.get(i).equals(player1Array.get(j))) {
                    System.out.println("You cannont use the same word more than once.");
                    System.out.println("Player 1 score: 0 - Cheated");
                    System.exit(0);
                }
            }
        }



        //Adds the substring(1) to the array player1answer    
        for (int i = 0; i < player1Array.size(); i++) {

            player1answer.add((i), player1Array.get(i).substring(1));

        }



        //Checks to see if element n in the dictionary is equal to element i in player1answers
        for (int i = 0; i < player1answer.size(); i++) {

            for (int n = 0; n < dictionary.size(); n++) {
                if (dictionary.get(n).equals(player1answer.get(i))) {

                    setPlayercount(getPlayercount() + 1);
                }

            }
        }



//		//for loop to print out there results
//		for(int i = 0; i < player1Array.size(); i++){
//			System.out.print(player1Array.get(i) + " ");
//		}
//                System.out.println("");
//                //prints the substring(1) answer
//                for(int i = 0; i < player1answer.size(); i++){
//			System.out.println(player1answer.get(i) + " ");
//		}

        System.out.println(player1);


        //checks to see if the timer went over 1 minute
        if (checkTimeOfInput(start, stop) >= 60000000000L) {
            System.out.println("Player 1 score: 0 - Time Exceeded!");
        } else {
            System.out.println("Player 1 score: " + getPlayercount());
        }




    }
    /*
     * makes a timer
     */
    private long checkTimeOfInput(long begin, long finish) {
        return finish - begin;
    }
    /*
     * adds all the elements of the file to an arrayList
     */
    /*
     * reads in file and stores in an arraylist
     */
    public void processDictionary(String filename) throws FileNotFoundException {

        File myFile = new File(filename);
        Scanner fileInput = new Scanner(myFile);


        while (fileInput.hasNextLine()) {
            String readLine = fileInput.nextLine();

            dictionary.add(readLine);

        }

//		for(int i = 0; i < dictionary.size(); i++){
//			System.out.println(dictionary.get(i));
//		}

    }

    /**
     * @return the playercount
     */
    public int getPlayercount() {
        return playercount;
    }

    /**
     * @param playercount the playercount to set
     */
    public void setPlayercount(int playercount) {
        this.playercount = playercount;
    }
}
