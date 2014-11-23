package morseCodeConversion;

import javax.sound.midi.*;

public class MorsePlayback {
 
    private static final int UNIT_DURATION_IN_MS = 100;
 
    private final Synthesizer synthesizer;
    private final MidiChannel channel;
 
    public MorsePlayback() throws MidiUnavailableException {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        channel = synthesizer.getChannels()[0];
        channel.programChange(0, 80);
 
        // Send a note after opening as a workaround for a sound glitch during the first few ms.
        channel.noteOn(80, 0);
        sleep(500);
        channel.noteOff(80, 0);
    }
 
    public void play(final String morse) {
        for (final char element : morse.toCharArray())
            play(element);
    }
 
    private static final int getDurationInTimeUnits(final char element) {
        switch (element) {
        case '.': return 1;
        case '-': return 3;
        case ' ': return 3;
        default: return 0;
        }
    }
 
    private static final boolean isNoisy(final char element) {
        return element == '.' || element == '-';
    }
 
    public void play(final char element) {
        if (isNoisy(element))
            channel.noteOn(80, 50);
        sleep(getDurationInTimeUnits(element) * UNIT_DURATION_IN_MS);
        //channel.allNotesOff();
        channel.noteOff(80, 50);
        sleep(UNIT_DURATION_IN_MS);
    }
 
    public void close() {
        sleep(1000); // Allow decay of sounds with decay.
        synthesizer.close();
    }
 
    public void sleep(final int durationInMs) {
        try {
            Thread.sleep(durationInMs);
        } catch (final InterruptedException e) {
            //e.printStackTrace();
        }
    }
 
    public static void main(final String... args) throws MidiUnavailableException {
        final MorsePlayback morse = new MorsePlayback();
        try {
            //for (final String arg : args)
                morse.play("-----------------");
        } finally {
             morse.close();
        }
    }
}