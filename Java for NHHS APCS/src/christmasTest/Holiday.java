package christmasTest;

public class Holiday {

	private final int CONSOLE_WIDTH = 130;

	public Holiday() {}

	public void drawTree(int rows) {
		drawLeaves(rows);
		drawBases(rows/4);
	}

	private void drawLeaves(int currentRow) {
		if (currentRow == 0)
			return;
		else {
			drawLeaves(--currentRow);
			String toPrint = createRow(++currentRow);
			centerPrint(toPrint);
		}
	}

	private String createRow(int currentRow) {
		if (currentRow == 1)
			return "*";
		else
			return createRow(--currentRow) + "^*";
	}

	private void drawBases(int i) {
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
		int offsetFromLeft = centerLine-halfOffset;

		System.out.println(gapOf(offsetFromLeft)+toPrint);
	}

	private String gapOf(int length){
		if (length == 0) 
			return "";
		else
			return " " + gapOf(--length); 
	}

}
