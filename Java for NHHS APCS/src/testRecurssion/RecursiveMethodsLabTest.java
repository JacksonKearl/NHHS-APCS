package testRecurssion;

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

	private long bitwiseMultiply(long num1, long num2, int pos) {
		long partialMult = shouldMult(num2, pos) ? num1 << pos : 0;
		
		if (pos == 0) {
			return partialMult;
		}
		return partialMult + bitwiseMultiply(num1, num2, pos-1);
	}

	private boolean shouldMult(long num2, int pos) {
		long r = num2 & (1 << pos);
		return r != 0;
	}

}
