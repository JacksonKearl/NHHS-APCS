package morseCodeConversion;

public class MorseDriver {
	public static void main(String args[]){
		Morse.toAlpha(".... . .-.. .-.. ---  .-- --- .-. .-.. -..");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		Morse.toMorse("Hello World");
	}
}
