package morseCodeConversion;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JOptionPane;

public class MorseDriver {

	static char wordDelimeter;

	public static void toMorse(){
		String alpha = JOptionPane.showInputDialog(null, "What's the sentence?");
		final String returnval = Morse.toMorse(alpha, wordDelimeter);


		Object[] options = { "Cancel", "Play" };
		Object selection = JOptionPane.showOptionDialog(null, returnval, null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[0]);

		char optionSelected = selection.toString().charAt(0);
		if (optionSelected != '1')
			return;
		else {	
			Runnable r = new Runnable() {
				public void run() {
					try {
						final MorsePlayback morse = new MorsePlayback();
						char[] arr = returnval.toCharArray();
						for (char c : arr){
							morse.play(c);
						}
					} 
					catch (MidiUnavailableException e) {
						e.printStackTrace();
					}
					
				}
			};
			
			new Thread(r).start();
			JOptionPane.showMessageDialog(null,
					"Playing: "+ returnval);
		}
	}

	public static void main(String args[]){
		char optionSelected;
		wordDelimeter = '/';
		do {
			try{
				Object[] options = { "Cancel", "Options", "Alpha to Morse", "Morse to Alpha" };
				Object selection = JOptionPane.showOptionDialog(null, "What task would you like to perform?", "Task Selection",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, options, options[0]);

				String returnval;
				optionSelected = selection.toString().charAt(0);

				switch (optionSelected){
				case '0': 
					break;

				case '1':
					//Options
					String defaultVal = "";
					defaultVal += wordDelimeter;
					try{
						wordDelimeter = JOptionPane.showInputDialog(null, 
								"Choose char to sperate words when converting to Morse?", defaultVal).charAt(0);
					} catch (StringIndexOutOfBoundsException e){
						wordDelimeter = ' ';
					}
					break;

				case '2':
					//Alpha to Morse
					toMorse();
					break;

				case '3':                                
					//Morse To Alpha
					String morse = JOptionPane.showInputDialog(null, "What's the morse?");
					morse = Morse.cleanUp(morse, wordDelimeter);
					while (morse == null){
						JOptionPane.showMessageDialog(null,
								"Input must be only dots, dashes, and spaces.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
						morse = JOptionPane.showInputDialog(null, "Try again. What's the morse?");
						morse = Morse.cleanUp(morse, wordDelimeter);
					}
					returnval = Morse.toAlpha(morse, wordDelimeter);
					JOptionPane.showMessageDialog(null,
							returnval);


					break;
				}
			} catch (NullPointerException e) { //Called when user hits top left 'x' button.
				optionSelected = '0';
			}

		}while (optionSelected >= '1');
		System.exit(0);
	}
}
