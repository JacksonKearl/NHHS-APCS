package morseCodeConversion;

import javax.swing.JOptionPane;

public class MorseDriver {
	public static void main(String args[]){
		Object[] options = { "Alpha to Morse", "Morse to Alpha" };
		Object selection = JOptionPane.showOptionDialog(null, "What task would you like to perform?", "Task Selection",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[0]);
		
		String returnval;
		if (selection.toString().equals("0")){ 
			//Alpha to Morse
			 String alpha = JOptionPane.showInputDialog(null, "What's the sentence?");

			 returnval = Morse.toMorse(alpha);
		}
		else {                                 
			//Morse To Alpha
			 String morse = JOptionPane.showInputDialog(null, "What's the morse?");
			 morse = Morse.cleanUp(morse);
			 while (morse == null){
				 JOptionPane.showMessageDialog(null,
						    "Input must be only dots, dashes, and spaces.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				 morse = JOptionPane.showInputDialog(null, "Try again. What's the morse?");
			 }
			 returnval = Morse.toAlpha(morse);
		}
		JOptionPane.showMessageDialog(null,
			    returnval);

	}
}
