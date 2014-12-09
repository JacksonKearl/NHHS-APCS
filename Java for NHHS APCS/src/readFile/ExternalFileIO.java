package readFile;


import java.io.IOException;
import java.util.*;
class ExternalFileIO
{
	FileInput in;
	FileOutput out;
	public ExternalFileIO( String sourceFile, String newFile ) throws IOException
	{
		in = new FileInput( sourceFile );
		out = new FileOutput( newFile );
	}
	public ExternalFileIO( String sourceFile, String newFile, boolean same ) throws IOException
	{
		in = new FileInput( sourceFile );
		out = new FileOutput( newFile, true );
	}
	public void capLetters() throws IOException
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
	public int countWords() throws IOException
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
	public static void main (String[] args) throws IOException
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