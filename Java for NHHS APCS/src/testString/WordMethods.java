/**
 *Jackson Kearl
 */

package testString;

public class WordMethods {

	private String s;
	
	public WordMethods(String phrase) {
		s = phrase;
	}

	public WordMethods() {
		s = null;
	}

	public String change(String target, String replacement) {
		int beginIndex = 0;
		while (true){
			int k = s.indexOf(target, beginIndex);
			if (k != -1){
				String firstPart = s.substring(beginIndex, k);
				String lastPart = s.substring(k+target.length());
				s = firstPart + replacement + lastPart;
			}
			else 
				break;
		}
		return s;
	}

	public String ay(String word) {
		String lastLetter = word.substring(0,1);
		String minusFirstLetter = word.substring(1);
		String ay = "ay";
		
		return minusFirstLetter + lastLetter + ay;
	}

	public int countWord(String sentence, String find) {
		sentence = sentence.toLowerCase();
		int possibleIndex = sentence.indexOf(find);
		
		if (possibleIndex == -1) {
			return 0;
		}
		
		else {
			boolean seperateAtFront;
			boolean seperateAtBack;
			
			try {
				int start = possibleIndex-1;
				int end = possibleIndex;
				String letterBefore = sentence.substring(start, end);
				seperateAtFront = (letterBefore.equals(" "));
			} catch (StringIndexOutOfBoundsException e) {
				seperateAtFront = true;
			}
			
			try {
				int start = possibleIndex+find.length();
				int end   = possibleIndex+find.length()+1;	
				String letterAfter = sentence.substring(start , end);
				seperateAtBack  = (letterAfter.equals(" "));
			} catch (StringIndexOutOfBoundsException e) {
				seperateAtBack = true;
			}
			int start = sentence.indexOf(find)+find.length();
			String recursePart = sentence.substring(start);
			
			if (seperateAtFront && seperateAtBack){
				return 1+countWord(recursePart,find);
			}
			return countWord(recursePart,find);
		}
	}

}

