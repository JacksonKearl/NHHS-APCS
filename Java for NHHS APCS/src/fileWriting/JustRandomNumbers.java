package fileWriting;

public class JustRandomNumbers
{
	public static void main( String[] args )
	{
		int k, num;
		int numero;
		String fileName = "numbers.txt";
		defaults.FileOutput outFile = new defaults.FileOutput( fileName );
		//this loop generates 50 random integers between 0 and 100 inclusive
		for( k=0; k<50; k++ )
		{
			num = (int)(Math.random()*41 + 60);
			if( k%10 == 0 && k!=0 ) outFile.writeEndOfLine();
			outFile.writeInt( num );//writes numbers to numbers.txt
			outFile.writeString( " " );
		}
		outFile.close();
		defaults.FileOutput out = new defaults.FileOutput( fileName, true );
		defaults.FileInput inFile = new defaults.FileInput( fileName );
		k = 0;
		int total = 0;
		if( inFile.fileFound() )
		{
			try
			{
				while( !inFile.eof() )
				{
					numero = inFile.readInt();
					if( k%10 == 0 && k!=0 ) System.out.println();
					System.out.print( numero + " " );
					total += numero;
					k++;
				}
			}catch( Exception n ){ System.out.println( "End of file" ); }
			out.writeEndOfLine();
			out.writeString( "\n\n" + "The average of these numbers is " );
			out.writeDouble( ((double)total/k) );
			System.out.print( "\n\n" + "The average of these numbers is " +
					((double)total/k) );
		}
		out.close();
	}
}