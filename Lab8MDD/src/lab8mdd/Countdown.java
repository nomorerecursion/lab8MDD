/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8mdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Drew
 */
public class Countdown {
    
    
            ArrayList<String> dictionary = new ArrayList<String>();
            Random randomGenerator = new Random();
            ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
            public static ArrayList<String> countDownWords = new ArrayList<>();

            char[] randomChar = new char[9];
            ArrayList<String> possibleWords = new ArrayList<String>();
            ArrayList<String> finalWords = new ArrayList<String>();
            String help;
    

       /*
        * starts the game Countdown
        */
       public void player1(){
            Scanner input = new Scanner(System.in);
	    String player1;
            int count = 0;
                 
            
            System.out.print("Letters: ");
            //adds 9 random characters from alphabet to randomChar
            for(int i = 0; i < 9; i++){
            int randomInt = randomGenerator.nextInt(10);
            randomChar[i] = alphabet.get(randomInt);
            alphabet.remove(randomInt);
            }
            
            
            for(int i = 0; i < randomChar.length; i ++){
                System.out.print(randomChar[i] + "-");
            }
            System.out.println();
            System.out.println("Please enter the letters without the dash's and no spaces");
            help = input.nextLine();
            System.out.println("You have 30 seconds to enter the longest possible word you can think of comprised of those letters. ");
            player1 = input.nextLine();
            
            for(int i = 0; i < dictionary.size(); i++){
                if(dictionary.get(i).equals(player1)){
                    System.out.println("Player 1: " + player1);
                    count++;
                }

            }
            if(count < 1){
            System.out.println("That is not a word");
            }
            

            
            combinations(help,5);
            //checks to see if any words in countDownWords are in the dictionary and if so adds them to possibleWords
            for(int i = 0; i < countDownWords.size(); i++){
                    
                    for(int n = 0; n < dictionary.size(); n++){
                        if(dictionary.get(n).equals(countDownWords.get(i))){
                        
                        possibleWords.add(countDownWords.get(i));
			//finalWords.add(countDownWords.get(i));
                        
                    }
                    }
                }
            
//            for(int i = 0; i < possibleWords.size(); i++){
//                System.out.println(possibleWords.get(i));
//            }
//            System.out.println();
//            System.out.println();
            
            //checks to see if any characters are repeated and if they are they are removed from possibleWords
            for(int i = 0; i < possibleWords.size(); i++){
                int counter = 0;
                for(int j = 0; j < possibleWords.get(i).length(); j++){
                
                for(int n = j+1; n < possibleWords.get(i).length(); n++){
                    if(possibleWords.get(i).charAt(j)==(possibleWords.get(i).charAt(n)))
                           break;
                       
                    if(possibleWords.get(i).charAt(j)!=(possibleWords.get(i).charAt(n))){
                       counter++;
                       
                       if(counter == 10){
//			   
                       finalWords.add(possibleWords.get(i));
                       break;

                    }

                    }
                }
                
            }
            }
            
                System.out.println("Player 2: " + finalWords.get(0));
                System.out.print("Player");
                
                if(finalWords.get(0).length() == player1.length()){
                    System.out.print(" 1 and Player 2 tied");
                }
                else if(finalWords.get(0).length() > player1.length()){
                    System.out.print(" 2 wins");
                }
                else if(player1.length() > finalWords.get(0).length()){
                    System.out.print(" 1 wins");
                }
                System.out.println();
                
            
            
            
            
       }
    
    /*
     * runs the method combinations
     */
    public static void combinations(String s, int n) {
        combinations(s, "", n);
    }

    /*
     * adds all the letter combinations to arraylist countDownWords
     */
    protected static void combinations(String s, String prfx, int n) {
        if (n == 0) {
            countDownWords.add(prfx);
        } else {
            for (int i = 0; i < s.length(); i++) {
                combinations(s, prfx + s.charAt(i), n - 1);

            }
        }
    }
    
    
    /*
	 * adds all the elements of the file to an arrayList
	 */
	public void processDictionary(String filename)throws FileNotFoundException {
		
		File myFile = new File(filename);
		Scanner fileInput = new Scanner(myFile);
		 
		
		while(fileInput.hasNextLine()){
			String readLine = fileInput.nextLine();
			
				dictionary.add(readLine);
			
		}
		
//		for(int i = 0; i < dictionary.size(); i++){
//			System.out.println(dictionary.get(i));
//		}

	}
    
    
    
    
    
}
