package readFile;

public class CappserDapper {
	public static void main( String args[] ){
		FileInput readFile = new FileInput("paragraph.txt");
		String resultant = "";
		while (true){
			try{
				String readWord = readFile.readWord();
				System.out.println(readWord);
				char firstLetter = readWord.charAt(0);
				firstLetter += ('A'-'a');
				readWord = firstLetter + readWord.substring(1);
				resultant += readWord + " ";
			} catch (StringIndexOutOfBoundsException e){
				System.out.println(e.getMessage());
				break;
			}
		}

		FileOutput outFile = new FileOutput("caps_paragraph.txt");
		outFile.writeString(resultant);
		outFile.close();
	}
}
