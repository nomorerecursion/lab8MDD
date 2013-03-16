package lab8mdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author S401544
 */
public class Beheadments 
{

	ArrayList<String> dictionary = new ArrayList<String>();
	ArrayList<String> player1Array = new ArrayList<String>();
        ArrayList<String> player1answer = new ArrayList<String>();
	
        

        
        
	/*
	 * stores player1's answers and adds up there points
	 */
	public void player1(){
		Scanner input = new Scanner(System.in);
		String player1;
		System.out.print("Enter as many words as you can seperated with a comma starting now: ");
		player1 = input.nextLine();
                int count = 0;
		
		String[] temp = player1.split(", ");
		
                
                //stores player1's submission into player1Array
                for(int i = 0; i < temp.length; i++){
			player1Array.add(temp[i]);   
		}
                
                
                //Adds the substring(1) to the array player1answer    
                for(int i = 0; i < player1Array.size(); i++){
                    
                    player1answer.add((i), player1Array.get(i).substring(1));
                   
                }
                
                 //Checks to see if element n in the dictionary is equal to element i in player1answers
                for(int i = 0; i < player1answer.size(); i++){
                    
                    for(int n = 0; n < dictionary.size(); n++){
                        if(dictionary.get(n).equals(player1answer.get(i))){
                        
                        count++;
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
                
                
                System.out.println("Your score is: " + count);
                
   
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
