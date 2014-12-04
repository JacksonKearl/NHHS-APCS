package coolSet3;

public class LettersInName {
	static int counter[] = new int [26];
	public static void main(String args[]){
		String val = "Jackson Kearl";
		val = val.toLowerCase();
		getCount(val);
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
			counter[string.charAt(0) - 'a']++;
			getCount(string.substring(1));
		}
	}
}
