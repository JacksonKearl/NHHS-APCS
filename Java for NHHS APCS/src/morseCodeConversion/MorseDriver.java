package morseCodeConversion;

import javax.swing.JOptionPane;

public class MorseDriver {
	public static void main(String args[]){
		char optionSelected;
		char wordDelimeter = '/';
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
					String alpha = JOptionPane.showInputDialog(null, "What's the sentence?");
					returnval = Morse.toMorse(alpha, wordDelimeter);
					JOptionPane.showMessageDialog(null,
							returnval);
					break;

				case '3':                                
					//Morse To Alpha
					String morse = JOptionPane.showInputDialog(null, "What's the morse?");
					morse = Morse.cleanUp(morse);
					while (morse == null){
						JOptionPane.showMessageDialog(null,
								"Input must be only dots, dashes, and spaces.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
						morse = JOptionPane.showInputDialog(null, "Try again. What's the morse?");
						morse = Morse.cleanUp(morse);
					}
					returnval = Morse.toAlpha(morse);
					JOptionPane.showMessageDialog(null,
							returnval);


					break;
				}
			} catch (NullPointerException e) { //Called when user hits top left 'x' button.
				optionSelected = '0';
			}

		}while (optionSelected >= '1');
	}
}
