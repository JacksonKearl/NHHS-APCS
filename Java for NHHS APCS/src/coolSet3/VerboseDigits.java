package coolSet3;

import defaults.SavitchIn;

public class VerboseDigits {
	public static void main( String args[] )
	{
		do
		{
			System.out.print( "\n" + "Enter an integer..." );
			inWords( SavitchIn.readLineInt() );
			System.out.print( "\n" + "again? y/n..." );
		}while( SavitchIn.readLineNonwhiteChar() == 'y' );
	}
	//Precondition: numero >= 0
	public static void inWords( int numero )
	{ 
		int digit = numero%10;
		numero = numero/10;
		if (numero == 0){
			System.out.print(digitWord(digit) + " ");
			return;
		}
		else {
			inWords(numero);
			System.out.print(digitWord(digit) + " ");
		}
	}
	//method used by inWords
	private static String digitWord( int digit )
	{
		String result = null;
		switch( digit )
		{
		case 0: result = "zero"; break;
		case 1: result = "one"; break;
		case 2: result = "two"; break;
		case 3: result = "three"; break;
		case 4: result = "four"; break;
		case 5: result = "five"; break;
		case 6: result = "six"; break;
		case 7: result = "seven"; break;
		case 8: result = "eight"; break;
		case 9: result = "nine"; break;
		default: System.out.println( "Fatal Error" ); break;
		}
		return result;
	}
}
