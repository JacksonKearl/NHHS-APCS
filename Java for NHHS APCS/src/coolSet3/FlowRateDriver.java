package coolSet3;

public class FlowRateDriver {

	public static void main(String[] args) {
		
		System.out.print("Enter height: ");
		double height = defaults.SavitchIn.readLineDouble();
		System.out.print("Enter base diameter: ");
		double diamBase = defaults.SavitchIn.readLineDouble();
		System.out.print("Enter opening diameter: ");
		double diamOpen = defaults.SavitchIn.readLineDouble();
		
		FlowRate tank = new FlowRate(height, diamBase, diamOpen);
		
		double timeEmpty = tank.getTimeTillEmpty();
		
		System.out.println("\n   Time  Volume\n-----------------");
		for (int s = 0; s<timeEmpty; s = s+200){
			System.out.printf("%7.2f  %.2f\n", (double)s, tank.getVolumeAtTime(s));
		}
		System.out.printf("%7.2f  %.2f\n", timeEmpty, 0.0);

	}

}
