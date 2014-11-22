package morseCodeConversion;

import javax.sound.midi.*;

public class Morse {

	private static String key = "A(.-) B(-...) C(-.-.) D(-..) E(.) F(..-.) G(--.) H(....) I(..) J(.---) K(-.-) L(.-..) M(--) N(-.) O(---) P(.--.) Q(--.-) R(.-.) S(...) T(-) U(..-) V(...-) W(.--) X(-..-) Y(-.--) Z(--..) 1(.----) 2(..---) 3(...--) 4(....-) 5(.....) 6(-....) 7(--...) 8(---..) 9(----.) 0(-----) ";
	private static int numWords;
	private static int numLetters;

	public static String toAlpha(String s, char sep){
		String wordDelimit = (sep == ' ')? "  " : " " + sep + " ";
		String[] wordsArray = tokenizeWithSeparator(s, wordDelimit, sep);

		String alpha = "";

		for (int wordIndex = 0; wordIndex<numWords; wordIndex++){
			String[] lettersArray = tokenizeWithSeparator(wordsArray[wordIndex], " ", sep);

			try{
				for (int letterIndex = 0; letterIndex <numLetters; letterIndex++){
					String morseVal = lettersArray[letterIndex];
					System.out.println(morseVal);
					alpha += key.charAt(((key.indexOf("(" + morseVal + ")"))-1));
				}
			} catch (StringIndexOutOfBoundsException e){
				return "Error: Invalid morse.";
			}
			alpha += " ";
		}
		return alpha;
	}

	public static String cleanUp(String s, char dem) {
		s = s.trim();
		String cleansed = "";
		for (int i = 0; i< s.length(); i++){
			char c = s.charAt(i);
			String validChars = " .-";
			validChars += dem;
			if (validChars.indexOf(c)!=-1){
				cleansed += c;
			}
			else{
				return null;
			}
		}
		return cleansed;
	}

	private static String[] tokenizeWithSeparator(String s, String sep, char wordDem){
		String[] str = new String[s.length()];

		int sepPoint = 0;
		int prePoint = 0;
		int word = 0;

		do {
			sepPoint = s.indexOf(sep, prePoint);
			if (sepPoint == -1)
				sepPoint = s.length();
			str[word] = s.substring(prePoint, sepPoint).toUpperCase();
			word++;
			prePoint = sepPoint+sep.length();
		} while (sepPoint < s.length());

		String wordDelimit = (wordDem == ' ')? "  " : " " + wordDem + " ";
		if  (sep.equals(wordDelimit))
			numWords = word;

		else if (sep.equals(" "));
		numLetters = word;

		return str;
	}

	public static String toMorse(String string, char sep) {
		string = string.toUpperCase();

		String morse = "";

		for (int letterIndex = 0; letterIndex<string.length(); letterIndex++){
			char letter = string.charAt(letterIndex);

			if ((letter >= 'A' && letter <= 'Z') || (letter >='0' && letter <= '9')){
				int startIndexInKey = key.indexOf(letter);
				int endIndex = key.indexOf(')', startIndexInKey);

				String morserep = key.substring(startIndexInKey+2, endIndex);
				morse += morserep;
			}
			else if (letter == ' ' && sep != ' ') morse += sep;

			morse += " ";
		}
		return morse;
	}

	public static void play(String morse){
		char[] notes = morse.toCharArray();
		int unit = 100;
		int mult = 0;
		try {
			Synthesizer synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
			MidiChannel channel = synthesizer.getChannels()[0];
			channel.programChange(0, 80);
			for (char note : notes) {
				switch (note){
				case '.':
					mult = 1;
					break;
				case '-':
					mult = 3;
					break;
				case ' ':
					mult = -3;
					break;
				}
				try{
					if (mult > 0){
						channel.noteOn(60, 30);
						Thread.sleep(mult*unit);
					}
					else 
						Thread.sleep(mult*-1*unit);
					
					channel.allNotesOff();
					Thread.sleep(100);

				} catch (InterruptedException e) {
					break;
				} finally {
					
				}
			}
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
}
