package fileWriting;

public class LettersInYourName
{
	public static void main( String[] args )
	{
		defaults.FileInput file = new defaults.FileInput("Name.txt");
		String firstName = file.readWord();
		String lastName = file.readWord();
		coolSet3.LettersInName myName = new coolSet3.LettersInName( firstName, lastName );
		System.out.print("\nHello " + myName.getFullName() + "." +
				" What a nice name you have!!");
		myName.analyzeName();
		
		defaults.FileOutput out = new defaults.FileOutput("Name.txt",true);
		out.writeString("\n" + myName.analyzeName());
		out.close();
		
	}
}