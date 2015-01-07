package testRecurssion;

import defaults.SavitchIn;

/**
 * Dominguez
 */
public class RecursionLabTestDriver
{
	public static void main( String args[] ) {
		int choice;
		String word;
		int num1, num2;
		String yes = new String("y");
		String again = new String( yes );
		while( again.equals( yes ) )
		{
			do {
				showMenu();
				choice = SavitchIn.readLineInt();
				if( choice != 1 && choice != 2 )
					System.out.print( "\n" + "C'mon now, all you have" +
							" to do is enter 1 or 2. Try again." );
			} while( choice != 1 && choice != 2 );

			switch( choice ) {
			case 1:
				RecursiveMethodsLabTest monkey;
				monkey = new RecursiveMethodsLabTest();
				System.out.print("\n" + "Enter a word..." );
				word = SavitchIn.readLine();
				System.out.println( "\n\t" + "\"" + word + "\"" +
				" spelled backwards is " + "\"" +
				monkey.displayLettersBack( word ) + "\"" );
				break;
			case 2:
				RecursiveMethodsLabTest chimp;
				chimp = new RecursiveMethodsLabTest();
				System.out.print("\n" + "Enter the numbers you want " +
						"to multiply..." );
						num1 = SavitchIn.readInt();
				num2 = SavitchIn.readInt();
				System.out.println( "\n\t" + num1 + " * " + num2 +
				" = " + chimp.mult( num1, num2 ) );
				break;
			}

		}
	}

	private static void showMenu() {
		System.out.print("\n\t" + "1 ==> spell word backwards" +
						   "\n\t" + "2 ==> recursive multiplication" +
						   "\n\t" + "...and your choice is..." );
		
	}

}