package christmasTest;

public class HolidayDemo {
	public static void main ( String args[]){
		Holiday christmas = new Holiday();
		int rows;
		rows = (int) (Math.random()*11+20);
		christmas.drawTree(rows);
	}
}
