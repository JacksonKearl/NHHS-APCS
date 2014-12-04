package coolSet3;

public class DigitsInNum {
	public static void main(String args[]){
		int numToTest = 5454545;
		int numToCount = 5;
		int count = countDigits(numToTest, numToCount);
		System.out.println(count);
	}

	private static int countDigits(int numToTest, int numToCount) {

		int numero = numToTest;
		int digit = numero%10;
		numero = numero/10;
		
		if (numero == 0){
			if (digit == numToCount)
				return 1;
			else
				return 0;
		}
		
		else {
			if (digit == numToCount)
				return 1+countDigits(numero, numToCount);
			else
				return countDigits(numero, numToCount);


		}
		


	}
}
