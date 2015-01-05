package christmasTest;                                //Jackson Kearl
public class Holiday {
	private final int CONSOLE_WIDTH = 80;

	public Holiday() {}

	public void drawTree(int rows) {
		drawLeaves(rows);
		drawBases(rows/4);
	}

	private void drawLeaves(int currentRow) {        //Look! Recursion!
		if (currentRow == 0)
			return;
		else {
			drawLeaves(--currentRow);
			String toPrint = createRow(++currentRow);
			centerPrint(toPrint);
		}
	}

	private String createRow(int currentRow) {        //Recursive.
		if (currentRow == 1)
			return "*";
		else
			return createRow(--currentRow) + "^*";
	}

	private void drawBases(int i) {                   //What??? Even more recursion??
		if (i == 0) 
			return;
		else {
			String toPrint = "MERRY_XMAS";
			centerPrint(toPrint);
			drawBases(--i);
		}

	}

	private void centerPrint(String toPrint) {
		int centerLine = CONSOLE_WIDTH/2;
		int halfOffset = toPrint.length()/2;
		int offset = centerLine-halfOffset;
		
		System.out.println(gapOf(offset)+toPrint);
	}
	
	private String gapOf(int length){                 //This is recursive too??   
		if (length == 0) 
			return "";
		else
			return " " + gapOf(--length); 
	}
}                                                     //Not a single loop.