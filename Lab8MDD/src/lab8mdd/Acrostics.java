package lab8mdd;

/**
 * @author Matt Seipel
 */
public class Acrostics 
{
	
	private String wordIn;
	/**
	 * Create the Acrostics game board (in progess)
	 * @param wordIn 
	 */
	public Acrostics(String wordIn){
		this.wordIn = wordIn.toUpperCase();
		createGameBoard();
		Jarvis.createDictionary();
	}
			
	/**
	 * Creates and prints the game board
	 */
	private void createGameBoard(){
		for(int i=1; i<wordIn.length()+1; i++){
			System.out.println(wordIn.charAt(i-1) + "-----" 
				+ wordIn.charAt(wordIn.length()-i));
		}
	}
	
	/**
	 * Split string of Player 1's words into an array for processing.
	 * @param userWords
	 * @return 
	 */
	private String[] splitWords(String userWords){
		String[] words = userWords.split(" ");
		return words;
	}
	
//	private int scoreWords(String[] words){
//		int score = 0;
//		
//		for(int i=0; i<words.length; i++){
//			if(!Jarvis.dictionary.contains(words[i])){
//				System.out.println(words[i] + "is not a valid word.");
//			}
//			else{
//				
//			}
//		}
//	}
	

}
