package coolSet4;

public class Time {
	private int mill;
	
	private int hours;
	private int minutes;
	private int seconds;
	private boolean isAM;
	
	public Time(String s) {
		isAM = (s.substring(s.length()-2).equals("AM"));
		s = s.substring(0, s.length()-3);
		String[] subUnits = s.split(":");
		
		setWithStandardTime(Integer.parseInt(subUnits[0]), Integer.parseInt(subUnits[1]), Integer.parseInt(subUnits[2]), isAM);
	}
	
	private void setWithStandardTime(int h, int m, int s, boolean am) {
		hours = h;
		minutes = m;
		seconds = s;
		isAM = am;
		
		calculateMillTime();
	}
	
	public Time(int millTime){
		mill = millTime;
		
		calculateStandardTime();
	}
	
	private void calculateStandardTime() {
		int tempMill = mill;
		isAM = (tempMill>=1200) ? false : true;
		if (!isAM) tempMill -= 1200;
		
		hours = tempMill/100;
		hours = (hours == 0) ? 12 : hours;
		
		minutes = tempMill % 100;
		
		seconds = 0;
	}
	
	private void calculateMillTime() {
		mill = 0;
		mill = isAM ? 0 : 1200;
		
		mill += ((hours == 12) ? 0 : hours*100);
		
		mill += minutes;
	}
	
	public String toStandardString(){
		return String.format("%02d:%02d:%02d%s", hours, minutes, seconds, (isAM ? " AM" : " PM"));
	}
	
	public String toMillString(){
		return String.format("%04d", mill);
	}
}