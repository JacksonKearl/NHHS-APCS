package coolSet4;

public class LCM {

	public static int findLCM(int num1, int num2) {
		int larger = (num1 > num2) ? num1 : num2;
		int smaller= (num1 < num2) ? num1 : num2;
		
		int testing = 0;
		while (true) {
			testing += smaller;
			if (testing%larger == 0){
				return testing;
			}
		}
	}

}
