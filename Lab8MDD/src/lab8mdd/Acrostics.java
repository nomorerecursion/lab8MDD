package lab8mdd;

import java.util.Scanner;

/**
 * @author Matt Seipel
 */
public class Acrostics {

    private String wordIn;
    private String wordsEntered;
    private Scanner playerInput = new Scanner(System.in);
    private long start, stop;
    int score = 0;

    /**
     * Primary game launching method. Runs the game in its entirety.
     */
    public void playAcrostrics() {
        //Create dictionary and game board.
        Jarvis.createDictionary();
        createGameBoard(wordForBoard());

        //Print the instructions
        System.out.println("You have 5 minutes to enter the longest possible "
                + "words that start/end with the indicated letters.");
        System.out.println("Enter all words on one line, separated by spaces.");

        //Set up a nanoTime timer and get input
        start = System.nanoTime();
        wordsEntered = getInput();
        stop = System.nanoTime();

        //Check if time was exceeded, if not print score.
        if (checkTimeOfInput(start, stop) >= 300000000000L) {
            System.out.println("Player 1 score: 0 - Time Exceeded!");
        } else {
            System.out.println("Player 1 score: "
                    + scoreWords(splitWords(wordsEntered)));
        }
        
        //Jarvis wins.
        selectWordsForJarvis();
    }

    /**
     * Gather the word for the game board from the user.
     *
     * @return wordIn
     */
    private String wordForBoard() {
        System.out.print("Please enter a word to generate acrostics: ");
        wordIn = playerInput.nextLine();
        return wordIn.toUpperCase();
    }

    /**
     * Creates and prints the game board
     */
    private void createGameBoard(String word) {
        for (int i = 1; i < word.length() + 1; i++) {
            System.out.println(word.charAt(i - 1) + "-----"
                    + word.charAt(word.length() - i));
        }
    }

    /**
     * Collect data from the user using the Scanner class. Store all the words
     * entered into a single string.
     *
     * @return String wordIn (contains all input)
     */
    private String getInput() {
        System.out.print("Player 1: ");
        wordsEntered = playerInput.nextLine();
        return wordsEntered;
    }

    /**
     * Split string of entered words into an array for processing.
     *
     * @param userWords
     * @return
     */
    private String[] splitWords(String userWords) {
        String[] words = userWords.split(" ");
        return words;
    }

    /**
     * Check entered words to see if they are in the dictionary, if not, print
     * the word followed by "is not valid". If the dictionary does contain the
     * entered word, score the word based off of length and add the total score.
     *
     * @param words
     * @return total score of valid words.
     */
    private int scoreWords(String[] words) {
        //Reset score to 0.
        score = 0;
        
        //Tally the score
        for (int i = 0; i < words.length; i++) {
            //Validate the words
            if (!Jarvis.dictionary.contains(words[i])) {
                System.out.println("   '" + words[i] + "'"
                        + " is not a valid word.");
            } else {
                //Score valid words.
                score += words[i].length();
            }
        }
        //Return total score
        return score;
    }

    /**
     * Determine the amount of time the user took to input words.
     *
     * @param begin
     * @param finish
     * @return Difference between finish and begin.
     */
    private long checkTimeOfInput(long begin, long finish) {
        return finish - begin;
    }

    /**
     * Allow Jarvis to navigate the dictionary and select words.  Basing his 
     * intelligence off of the base case of the length of the word used for the
     * playing board.  If there is not a word of said length, use any word 
     * meeting the first and last letter requirement.  The longer the base word,
     * the easier it will be for Jarvis to win, and the more time the user 
     * may use to think of longer words, possibly timing out.
     */
    private void selectWordsForJarvis() {
        StringBuilder wordsForJarvis = new StringBuilder();
        
        //Find words starting and ending with the required letters of wordIn
        for (int i = 1; i <= wordIn.length(); i++) {
            //Navigate the dictionary to find matching words.
            for (String s : Jarvis.dictionary) {
                //Base Jarvis's intelligence off of the length of wordIn.
                //Losing will be much easier with a shorter word.
                if (s.startsWith(String.valueOf(wordIn.charAt(i - 1)))
                        && s.endsWith(String.valueOf(wordIn.charAt(wordIn.length() - i)))
                        && s.length() > wordIn.length()){
                    wordsForJarvis.append(s + " ");
                    break;
                }
                //If there is not a word with the length of wordIn, use any word.
                else if (s.startsWith(String.valueOf(wordIn.charAt(i - 1)))
                        && s.endsWith(String.valueOf(wordIn.charAt(wordIn.length() - i)))){
                    //Append the matching words to a large string
                    wordsForJarvis.append(s + " ");
                    break;
                }
            }
        }
        
        //Print out Jarvis's word selection
        System.out.println("Player 2: " + wordsForJarvis.toString());
        //Send words to be scored.
        score = scoreWords(splitWords(wordsForJarvis.toString()));
        //Print out the score.
        System.out.println("Player 2 score: " + score);

    }
}
