package testString;

import defaults.SavitchIn;

public class WordMethodsDriver
{
	public static void main( String args[] )
	{
		String phrase, target, replacement;
		
		System.out.print("Enter a phrase...");
		phrase = SavitchIn.readLine();
		System.out.print("Enter a target string (to be replaced) and a replacement string...");
		target = SavitchIn.readWord();
		replacement = SavitchIn.readWord();
		WordMethods rover = new WordMethods (phrase);
		System.out.print( "\n" + rover.change(target, replacement) );
		System.out.print("\n----------------------------------\n" +
				"Enter a word...");
		String word = SavitchIn.readLine();
		WordMethods palabra = new WordMethods ();
		String ayWord = palabra.ay(word);
		System.out.printf( "%1s %-10s %3s %12s", "\n", word, "==>", ayWord );
		
		WordMethods palermo = new WordMethods ();
		System.out.println( "\n\nEnter a sentence: " );
		String sentence = SavitchIn.readLine();
		
		System.out.print( "\nEnter a word to count..." );
		String find = SavitchIn.readLine();
		System.out.println( "\nThere are " + palermo.countWord(sentence, find)+
				" instances of " + "\"" + find + "\"" );
	}
}