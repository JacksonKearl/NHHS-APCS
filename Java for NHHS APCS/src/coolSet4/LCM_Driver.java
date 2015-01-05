package coolSet4;

import defaults.SavitchIn;

public class LCM_Driver
{
	public static void main( String[] args )
	{
		int num1, num2;
		System.out.print("\nEnter first integer: ");
		num1 = SavitchIn.readLineInt();
		System.out.print("\nEnter second integer: ");
		num2 = SavitchIn.readLineInt();
		System.out.print("\nThe LCM of " + num1 + " and " +
				num2 + " is " + LCM.findLCM(num1, num2));
	}
}