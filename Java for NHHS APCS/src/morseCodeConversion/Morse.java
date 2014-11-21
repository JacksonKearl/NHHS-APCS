package morseCodeConversion;

public class Morse {

	private static String key = "A(.-) B(-...) C(-.-.) D(-..) E(.) F(..-.) G(--.) H(....) I(..) J(.---) K(-.-) L(.-..) M(--) N(-.) O(---) P(.--.) Q(--.-) R(.-.) S(...) T(-) U(..-) V(...-) W(.--) X(-..-) Y(-.--) Z(--..) 1(.----) 2(..---) 3(...--) 4(....-) 5(.....) 6(-....) 7(--...) 8(---..) 9(----.) 0(-----) ";
	private static int numWords;
	private static int numLetters;

	public static String toAlpha(String s){
		s = cleanUp(s);
		String[] wordsArray = tokenizeWithSeparator(s, "  ");

		String alpha = "";
		for (int wordIndex = 0; wordIndex<numWords; wordIndex++){
			String[] lettersArray = tokenizeWithSeparator(wordsArray[wordIndex], " ");

			for (int letterIndex = 0; letterIndex <numLetters; letterIndex++){
				String morseVal = lettersArray[letterIndex];
				alpha += key.charAt(((key.indexOf("(" + morseVal + ")"))-1));
			}
			alpha += " ";
		}
		//System.out.println(alpha);
		return alpha;
	}

	public static String cleanUp(String s) {
		s = s.trim();
		String cleansed = "";
		for (int i = 0; i< s.length(); i++){
			char c = s.charAt(i);
			String validChars = " .-";
			if (validChars.indexOf(c)!=-1){
				cleansed += c;
			}
			else{
				return null;
			}
		}
		return cleansed;
	}

	private static String[] tokenizeWithSeparator(String s, String sep){
		String[] str = new String[s.length()];

		int sepPoint = 0;
		int prePoint = 0;
		int word = 0;

		do {
			sepPoint = s.indexOf(sep, prePoint);

			if (sepPoint == -1)
				sepPoint = s.length();

			str[word] = s.substring(prePoint, sepPoint).toUpperCase();
			//System.out.println(str[word]);
			word++;

			prePoint = sepPoint+sep.length();
		} while (sepPoint < s.length());

		if  (sep.equals("  "))
			numWords = word;
		else if (sep.equals(" "));
		numLetters = word;

		return str;
	}

	public static String toMorse(String string) {
		string = string.toUpperCase();
		/*
		String[] wordsArray = tokenizeWithSeparator(string, " ");
		String morse = "";

		for (int wordIndex = 0; wordIndex<numWords; wordIndex++){

			for (int letterIndex = 0; letterIndex<wordsArray[wordIndex].length(); letterIndex++){
				char letter = wordsArray[wordIndex].charAt(letterIndex);
				if (letter > 'A' && letter < 'Z'){
					int startIndexInKey = key.indexOf(letter);
					int endIndex = key.indexOf(')', startIndexInKey);
					String morserep = key.substring(startIndexInKey+2, endIndex);
					morse += morserep;
				}
				morse += " ";
			}
			morse += " ";
		}
		*/
		
		String morse = "";
		
		for (int letterIndex = 0; letterIndex<string.length(); letterIndex++){
			char letter = string.charAt(letterIndex);
			if ((letter >= 'A' && letter <= 'Z') || (letter >='0' && letter <= '9')){
				int startIndexInKey = key.indexOf(letter);
				int endIndex = key.indexOf(')', startIndexInKey);
				String morserep = key.substring(startIndexInKey+2, endIndex);
				morse += morserep;
			}
			else if (letter == ' ') morse += '/';
			morse += " ";
		}
		//System.out.println(morse);
		return morse;
	}
}