package errorHandleChecking;



public class CheckingDriver {
	public static void main(String[] args) {
		System.out.print("Enter your starting balance: ");
		double bal = defaults.SavitchIn.readLineDouble();
		
		CheckingAcct acct = new CheckingAcct(bal);
		double amount;
		
		boolean wantsToContinue = true;
		
		while (wantsToContinue){
			System.out.print("Would you like to wihdraw (1), deposit (2), or quit (3)? ");
			int selection = defaults.SavitchIn.readLineInt();
			switch (selection){
			case 1:
				System.out.print("How much? ");
				amount = defaults.SavitchIn.readLineDouble();
				acct.withdraw(amount);
				break;
			case 2:
				System.out.print("How much? ");
				amount = defaults.SavitchIn.readLineDouble();
				acct.deposit(amount);
				break;
			case 3:
				wantsToContinue = false;
				break;
			default:
				break;
			}
			System.out.print("Your balance is: " + acct.getBalance());
			
		}
	}

}
