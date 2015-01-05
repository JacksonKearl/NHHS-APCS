package fileWriting;

import java.util.*;
class ExternalFileIO
{
	defaults.FileInput in;
	defaults.FileOutput out;
	public ExternalFileIO( String sourceFile, String newFile )
	{
		in = new defaults.FileInput( sourceFile );
		out = new defaults.FileOutput( newFile );
	}
	public ExternalFileIO( String sourceFile, String newFile, boolean same )
	{
		in = new defaults.FileInput( sourceFile );
		out = new defaults.FileOutput( newFile, true );
	}
	public void capLetters()
	{
		System.out.println("Hello, it's: ");
		System.out.println(new Date());
		out.writeEndOfLine();
		String line;
		while ( !in.eof() )
		{
			line = in.readLine();
			System.out.println( line );
			line = line.toUpperCase();
			System.out.println( line );
			out.writeString(line);
			out.writeEndOfLine();
		}
		out.close();
		in.close();
	}
	@SuppressWarnings("unused")
	public int countWords()
	{
		String word;
		int count = 0;
		while ( !in.eof() )
		{
			word = in.readWord();
			count++;
			//System.out.println( "word = " + word + "\t" + "count = " +
			//count );
		}
		out.close();
		in.close();
		return count-1;
	}
	public static void main (String[] args)
	{
		String source = "cities.txt";
		String target = "after.txt";
		ExternalFileIO gumby = new ExternalFileIO( source, target );
		gumby.capLetters();
		ExternalFileIO pluto = new ExternalFileIO( source, target, true );
		System.out.println( "\n\n" + "The file " + "\"" + source + "\"" +
				" contains " + pluto.countWords() + " words." );
	}
}