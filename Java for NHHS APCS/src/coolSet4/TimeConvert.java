package coolSet4;

public class TimeConvert {
	
	public static void main(String args []) {
		Time first = new Time("12:45:56 PM");
		Time second = new Time(343);
		
		System.out.println(first.toMillString());
		System.out.println(second.toStandardString());
	}
}
