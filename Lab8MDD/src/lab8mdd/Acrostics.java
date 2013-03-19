package lab8mdd;

import java.util.Scanner;

/**
 * @author Matt Seipel
 */
public class Acrostics {

    private String wordIn;
    private String wordsEntered;
    private Scanner playerInput = new Scanner(System.in);
    long start, stop;

    /**
     * Primary game launching method. Runs the game in its entirety.
     */
    public void playAcrostrics() {
        //Create dictionary and game board.
        Jarvis.createDictionary();
        createGameBoard(wordForBoard());
        
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
    }

    /**
     * Gather the word for the game board from the user.
     *
     * @return wordIn
     */
    private String wordForBoard() {
        System.out.print("Please enter a word to generate acrostics: ");
        wordIn = playerInput.nextLine();
        wordIn = wordIn.toUpperCase();
        return wordIn;
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
        int score = 0;

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

    private long checkTimeOfInput(long begin, long finish) {
        return finish - begin;
    }
}
