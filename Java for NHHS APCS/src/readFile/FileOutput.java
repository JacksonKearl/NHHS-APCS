package readFile;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput extends FileWriter{

	public FileOutput(String newFile) throws IOException {
		super(newFile);
	}

	public FileOutput(String newFile, boolean b) throws IOException {
		super(newFile, b);
	}

	public void writeEndOfLine() throws IOException {
		super.write(-1);
		
	}

	public void writeString(String line) throws IOException {
		super.write(line);		
	}

}
