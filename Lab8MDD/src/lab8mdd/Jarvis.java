package lab8mdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author s508609
 */
public class Jarvis {
    //Static variable to allow use across classes.

    public static ArrayList<String> dictionary = new ArrayList<>();
    public static ArrayList<String> beheadmentDictionary = new ArrayList<>();
    
    int count = 0;

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

    public void beheadmentGame() {

        //adds all the words of the dictionary substring(1)
        for (int i = 0; i < dictionary.size(); i++) {

//			  if(dictionary.get(i).length()<=1){
//				  String temp = dictionary.get(i);
//				  System.out.println(temp);
//			  }
            beheadmentDictionary.add((i), dictionary.get(i).substring(1));
            System.out.println(beheadmentDictionary.get(i));

        }


        for (int i = 0; i < beheadmentDictionary.size(); i++) {

            for (int n = 0; n < dictionary.size(); n++) {
                if (dictionary.get(n).equals(beheadmentDictionary.get(i))) {

                    count++;
                }
            }
        }

        System.out.println("Jarvis's score is: " + count);
    }
    
    public void countDownGame(){
        
    }


}
