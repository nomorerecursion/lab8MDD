package lab8mdd;

import java.util.Scanner;

/**
 * @author Matt Seipel
 */
public class Ghosts {

    private Scanner userInput = new Scanner(System.in);
    private String word;
    private StringBuilder wordInProgress = new StringBuilder();
    private String potentialWord;
    private boolean endGame = false;
    private int turn;

    public void playGhosts() {
        //Initiate the dictionary.
        Jarvis.createDictionary();
        //Print out instructions
        System.out.println("Objective: Do NOT complete a word.  "
                + "Enter one letter per turn.");
        //Allow player 1 to make a move to initialize word and wordInProgress.
        turn = 1;
        System.out.print("Player 1: ");
        word = userInput.next();
        //Append the letter choice to wordInProgress
        wordInProgress.append(word);

        //Continue the game while a word is still possible and has not been completed.
        while (endGame == false) {
            //Player 2's turn
            turn = 2;
            word = addLetterJarvis(word);
            endGame = checkWord(word);

            //Check if the word has been completed or nerfed between turns.
            if (endGame == true) {
                break;
            }

            //Player 1's turn
            turn = 1;
            word = addLetter(word);
            endGame = checkWord(word);
        }

        //Determine which player has won the game.
        if (turn == 1) {
            System.out.println("Game Over! Victor: Player 2");
        } else {
            System.out.println("Game Over! Victor: Player 1");
        }

    }

    /**
     * Checks the current word to see if it is a complete word, or if any
     * possible words can be made using it as a prefix. If so, return false, in
     * order to continue game conditions. If not, return true,
     *
     * @param gameWord
     * @return true if a word is made or does not exist, false if a word is
     * still possible.
     */
    private boolean checkWord(String gameWord) {
        for (String s : Jarvis.dictionary) {
            if (s.equals(gameWord)) {
                return true; //Completed word.
            } else if (s.startsWith(gameWord) && s.length() > gameWord.length()) {
                return false; //Further possibilities
            }
        }
        //Concludes that no further words are possible.
        return true;
    }

    /**
     * User's turn to make a move. Prompt for input and append to
     * wordInProgress.
     *
     * @param gameWord
     * @return updated game word.
     */
    private String addLetter(String gameWord) {
        System.out.print("Player 1: " + gameWord);
        wordInProgress = wordInProgress.append(userInput.next());

        return wordInProgress.toString();

    }

    /**
     * Allow Jarvis to make a move. Checks for potential words and continues to
     * append letters, while not completing a word, unless there is no further
     * possibilities.
     *
     * @param gameWord
     * @return updated game word.
     */
    private String addLetterJarvis(String gameWord) {
        //Boolean variable set up to determine if Jarvis can makes a legal move.
        boolean move = false;

        //Process the dictionary for most recent potential words.
        for (String s : Jarvis.dictionary) {
            //Make sure potential words use the current game word as a prefix.
            //Also, the potential word must be longer than game word.
            if (s.startsWith(gameWord) && s.length() > gameWord.length()) {
                potentialWord = s;
                //Make sure if the next letter is appended it won't complete a word.
                if (!Jarvis.dictionary.contains(
                        potentialWord.substring(0, gameWord.length() + 1))) {
                    wordInProgress = wordInProgress.append(
                            potentialWord.charAt(gameWord.length()));
                    //Jarvis has made a move.
                    move = true;
                    //Kill the loop.
                    break;
                }
            }
        }

        //Jarvis did not find a possible move or potential word.
        //He must complete the word at hand and take the loss.
        if (move == false) {
            wordInProgress = wordInProgress.append(
                    potentialWord.charAt(gameWord.length()));
        }

        //Print Jarvis's move.
        System.out.print("Player 2: " + wordInProgress.toString() + "\n");
        return wordInProgress.toString();

    }
}
