package morseCodeConversion;

import javax.sound.midi.MidiUnavailableException;

public class PlaybackThreadDriver implements Runnable {

	private volatile boolean isRunning = true;

	public void run() {
		isRunning = true;


		try {
			final MorsePlayback morse = new MorsePlayback();
			char[] arr = MainMenu.morseText.getText().toCharArray();
			for (char c : arr){
				if (!isRunning) {
					break;
				}
				else {
					morse.play(c);
				}
			}
			isRunning = true;
			MainMenu.playButton.setText("Play Morse");
		} 
		catch (MidiUnavailableException e) {
			e.printStackTrace();
		}

	}

	public void kill() {
		isRunning = false;
	}

}