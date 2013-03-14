package lab8mdd;

/**
 * @author Matt Seipel
 */
public class Ghosts 
{
	/**
	 * Not for actual game, just tested Jarvis.
	 * @param g 
	 */
	public Ghosts(String g){
		Jarvis.createDictionary();
		for(String string:Jarvis.dictionary)
		{
			if(string.equals(g))
				System.out.print(string);
		}
	}
}
