package lab8mdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * @author s508609
 */
public class Jarvis {
    //Static variable to allow use across classes.

    public static ArrayList<String> dictionary = new ArrayList<>();
    public static ArrayList<String> beheadmentDictionary = new ArrayList<>();
    public static ArrayList<String> beheadmentJarvis = new ArrayList<>();
    
    private int jarviscount = 0;
    Beheadments game3 = new Beheadments();
    int playercount = game3.getPlayercount();

    /**
     * Reads in the dictionary and creates it in a static variable
     */
    public static void createDictionary() {
        try {
            Scanner readDictionary =
                    new Scanner(new File("dictionary.txt"));
            dictionary = new ArrayList<>();
            while (readDictionary.hasNext()) {
                dictionary.add(readDictionary.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("404: File Not Found");
        }
    }
    /*
     * Sets up the beheadment dictionary for Jarvis
     * finds random number of beheament words
     * declares a winner
     */
    public void beheadmentGame() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(6) + 3;
        //adds all the words of the dictionary substring(1)
        for (int i = 0; i < dictionary.size(); i++) {

//			  if(dictionary.get(i).length()<=1){
//				  String temp = dictionary.get(i);
//				  System.out.println(temp);
//			  }
            beheadmentDictionary.add((i), dictionary.get(i).substring(1));
            //System.out.println(beheadmentDictionary.get(i));

        }


        for (int i = 0; i < beheadmentDictionary.size()/randomInt; i++){

            for (int n = 0; n < dictionary.size(); n++) {
                if (dictionary.get(n).equals(beheadmentDictionary.get(i))) {
                    beheadmentJarvis.add(beheadmentDictionary.get(i));
                    jarviscount++;
                    System.out.print(dictionary.get(n) + ", ");
                }
            }
        }
        
        

        
        System.out.println();
        System.out.println("Player 2 score: " + jarviscount);
        
        
       
        if(playercount > jarviscount){
        System.out.println("Player 1 wins!");
        }
        else if(jarviscount > playercount){
            System.out.println("Player 2 wins!");
        }
        
        
    }
    
    


}
