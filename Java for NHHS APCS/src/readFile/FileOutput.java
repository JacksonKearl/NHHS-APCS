package readFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput extends FileWriter{

	public FileOutput(File file) throws IOException {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public FileOutput(String newFile) throws IOException {
		super(newFile);
		// TODO Auto-generated constructor stub
	}


}
