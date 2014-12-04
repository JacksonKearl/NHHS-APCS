package coolSet3;

public class LettersInName {
	static int counter[] = new int [26];
	
	public static void main(String args[]){
		String val = "Jackson Kearl";
		val = val.toLowerCase();
		getCount(val);
		System.out.println(val+ " contains: ");
		for (int i = 0; i<26; i++){
			if (counter[i] != 0){
				System.out.println(counter[i] + " " + (char)(i+ 'a') + "'s");
			}
		}
	}
	
	private static void getCount(String string) {
		if (string.length() == 0)
			return;
		else {
			if (isLetter(string.charAt(0)))
				counter[string.charAt(0) - 'a']++;
			getCount(string.substring(1));
		}
	}
	
	private static boolean isLetter(char c){
		return ('a' <= c && c <= 'z');
	}
}
