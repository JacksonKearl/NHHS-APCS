package coolSet4;

public class Time {
	private int mill;
	
	private int hours;
	private int minutes;
	private int seconds;
	private boolean isAM;
	
	public void setWithStandardString(String s) {
		isAM = (s.substring(s.length()-2) == "AM");
		
		String[] subUnits = s.split(":");
	}
	
	private void setWithStandardTime(int h, int m, int s, boolean am) {
		hours = h;
		minutes = m;
		seconds = s;
		isAM = am;
		
		calculateMillTime();
	}
	
	public void setWithMillTime(int millTime){
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
	
	public String toStandardString(Time t){
		return hours + ":" + minutes + ":" + seconds + (isAM ? " AM" : " PM"); 
	}
	
	public String toMillString(){
		return String.format("%04d", mill);
	}
}