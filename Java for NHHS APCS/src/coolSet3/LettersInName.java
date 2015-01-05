package coolSet3;

public class LettersInName {
	static int counter[] = new int [26];
	static String val;
	
	public LettersInName(String f,String l){
		//String val = "Jackson Kearl";
		val = f + " " + l;
		val = val.toLowerCase();
		getCount(val);
		//analyzeName();
	}
	public String analyzeName() {
		String s = "" ;
		s += (val+ " contains: ");
		for (int i = 0; i<26; i++){
			if (counter[i] != 0){
				s += (counter[i] + " " + (char)(i+ 'a') + "'s\n");
			}
		}
		return s;
	}
	public String getFullName(){
		return val;
	}
	public void getCount(String string) {
		if (string.length() == 0)
			return;
		else {
			if (isLetter(string.charAt(0)))
				counter[string.charAt(0) - 'a']++;
			getCount(string.substring(1));
		}
	}
	
	private boolean isLetter(char c){
		return ('a' <= c && c <= 'z');
	}
}
