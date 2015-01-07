package testRecurssion;

//Jackson Kearl

public class RecursiveMethodsLabTest {

	public String displayLettersBack(String word) {
		if (word.length() == 1) 
			return "" + word.charAt(0);
		char toMoveToEnd = word.charAt(0);
		word = word.substring(1, word.length());
		return displayLettersBack(word) + toMoveToEnd;
	}

	public long mult(int num1, int num2) {
		int sign = (isPositive(num1) == isPositive(num2)) ? 1 : -1;
		return sign * bitwiseMultiply(Math.abs(num1), Math.abs(num2), 31);
	}
	
	private boolean isPositive(int i){
		return i>0;
	}

	private long bitwiseMultiply(long num1, long num2, int pos) {    //bitwise, baby
		long partialMult = shouldMult(num2, pos) ? num1 << pos : 0;
		
		if (pos == 0) {
			return partialMult;
		}
		return partialMult + bitwiseMultiply(num1, num2, pos-1);
	}

	private boolean shouldMult(long num2, int pos) {                //thats what I'm talking about
		long r = num2 & (1 << pos);
		return r != 0;
	}

}

/*Brief explanation:
 * Think of multiplying binary numbers:  100011 * 101
 * Just as 234 * 21 can be broken up into (234 * 20) + (234 * 1),
 * the above binary can be broken up into (100011 * 100) + (100011 * 0) + (100011 * 1).
 * The shouldMult function looks at the specified place value in the second number,
 * and decides if it should be added to the product, based on if it is a 0 or 1.
 * In the above instance, (100011 * 0) would not be added, because shouldMuld would return false
 * for the arguments 101, 1. In the other cases [namely 100011 * 100 and 100011 * 1], multiplication
 * proceeds as it normally would with decimal numbers, in that one may simply add a 0 to the tail
 * end of a number when multiplying by 10 or 00 when by 100, and so on. This is achieved through use
 * of the "<<" operator, which will add "pos" 0's to the end of the partial product each recursion
 */
