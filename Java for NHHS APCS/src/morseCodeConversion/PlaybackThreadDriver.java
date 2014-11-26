package morseCodeConversion;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;

public class PlaybackThreadDriver implements Runnable {

	private volatile boolean isRunning = true;
	private volatile String text;
	private volatile JButton button;
	
	public void setText(String t){
		text = t;
	}
	
	public void setButton(JButton b){
		button = b;
	}
	
	public void run() {
		isRunning = true;


		try {
			final MorsePlayback morse = new MorsePlayback();
			char[] arr = text.toCharArray();
			for (char c : arr){
				if (!isRunning) {
					break;
				}
				else {
					morse.play(c);
				}
			}
			isRunning = true;
			button.setText("Play");
		} 
		catch (MidiUnavailableException e) {
			e.printStackTrace();
		}

	}

	public void kill() {
		isRunning = false;
	}

}