package lab8mdd;

import java.util.Scanner;

/**
 * @author Matt Seipel
 */
public class Ghosts {

    private Scanner userInput = new Scanner(System.in);
    private String word;
    private StringBuilder wordInProgress;
    private String potentialWord;

    public void playGhosts() {
        Jarvis.createDictionary();

        System.out.print("Player 1: ");
        word = userInput.next();

        while (checkWord(word) == false) {
            word = addLetterJarvis(word);

            word = addLetter(word);
        }


    }

    private boolean checkWord(String gameWord) {
        for (String s : Jarvis.dictionary) {
            if (s.startsWith(gameWord)) {
                return false;
            } else if (Jarvis.dictionary.contains(gameWord)) {
                return true;
            }
        }
        /*
         * No condition is met.
         * The word is neither part of a word, nor an actual word.
         * Ends game, player loses.
         */
        return true;
    }

    private String addLetter(String gameWord) {
        wordInProgress = new StringBuilder(gameWord);
        System.out.print("Player 1: " + gameWord);
        wordInProgress = wordInProgress.append(userInput.next());

        //Check if adding the letter creates a valid word and ends game.
        if (checkWord(wordInProgress.toString()) == true) {
            return "Game Over!  Victor: Player 2";
        } else {
            return wordInProgress.toString();
        }
    }

    private String addLetterJarvis(String gameWord) {
        wordInProgress = new StringBuilder(gameWord);
        System.out.print("Player 2: ");
        
        for (String s : Jarvis.dictionary) {
            if (s.startsWith(gameWord) && s.length() > gameWord.length()) {
                potentialWord = s;
                if (!Jarvis.dictionary.contains(
                        potentialWord.substring(0, gameWord.length() + 1))) {
                    wordInProgress = wordInProgress.append(s.charAt(gameWord.length()));
                    break;
                }
            }
        }
        //Check if adding the letter creates a valid word and ends game.
        if (checkWord(wordInProgress.toString()) == true) {
            return "Game Over!  Victor: Player 1";
        } else {
            System.out.print(wordInProgress.toString() + "\n");
            return wordInProgress.toString();
        }
    }
}
