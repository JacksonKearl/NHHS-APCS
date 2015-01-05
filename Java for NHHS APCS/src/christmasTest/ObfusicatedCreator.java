package christmasTest;

public class ObfusicatedCreator {
	
	private String s = "package christmasTest; public class Obfusicated { public static void main ( String args[]){ Obfusicated christmas = new Obfusicated(); int rows; rows = (int) (Math.random()*11+20); System.out.println(\"Rows = \" + rows); christmas.drawTree(rows); } private final int CONSOLE_WIDTH = 130; public Obfusicated() {} public void drawTree(int rows) { drawLeaves(rows); drawBases(rows/4); } private void drawLeaves(int currentRow) { if (currentRow == 0) return; else { drawLeaves(--currentRow); String toPrint = createRow(++currentRow); centerPrint(toPrint); } } private String createRow(int currentRow) { if (currentRow == 1) return \"*\"; else return createRow(--currentRow) + \"^*\"; } private void drawBases(int i) { if (i == 0) return; else { String toPrint = \"MERRY_XMAS\"; centerPrint(toPrint); drawBases(--i); } } private void centerPrint(String toPrint) { int centerLine = CONSOLE_WIDTH/2; int halfOffset = toPrint.length()/2; int offsetFromLeft = centerLine-halfOffset; System.out.println(gapOf(offsetFromLeft)+toPrint); } private String gapOf(int length){ if (length == 0) return \"\"; else return \" \" + gapOf(--length); } } ";
	private int index = 0;
	
	public static void main ( String args[]){
		ObfusicatedCreator christmas = new ObfusicatedCreator();
		int rows;
		rows = 33;
		System.out.println("Rows = " + rows);
		christmas.drawTree(rows);
	}
	
	private final int CONSOLE_WIDTH = 80;

	public ObfusicatedCreator() {}

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
			return ""+s.charAt(index++);
		else
			return createRow(--currentRow) + "" + s.charAt(index++) + s.charAt(index++);
	}

	private void drawBases(int i) {
		if (i == 0) 
			return;
		else {
			String toPrint = s.substring(index, index+=10);
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
