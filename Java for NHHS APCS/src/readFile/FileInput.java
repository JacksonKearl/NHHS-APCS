package readFile;

import java.io.FileReader;
import java.io.IOException;

public class FileInput extends FileReader {

	public FileInput(String sourceFile) throws IOException{
		super(sourceFile);
	}

	public boolean eof() throws IOException{
		boolean isEndOfFile = (super.read() == -1);
		return isEndOfFile;
	}

	public String readLine() throws IOException {
		return readUntil('\n');
	}

	public String readWord() throws IOException {
		return readUntil(' ');
	}
	private String readUntil(char c) throws IOException{
		String line = "";
		int val = super.read();
		while (val != c && val != -1) {
			line += (char)val;
			val = super.read();
		}
		return line;
	}
}
