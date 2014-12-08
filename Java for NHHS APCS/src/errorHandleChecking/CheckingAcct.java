package errorHandleChecking;

public class CheckingAcct
{
	private double myBalance;
	
	public CheckingAcct()
	{
		myBalance = 0.0;
	}
	
	public CheckingAcct(double initialBalance) throws IllegalArgumentException
	{
		if (initialBalance < 0)
			throw new IllegalArgumentException("You're already in debt!? Get a job.");
		else
			myBalance = initialBalance;
	}
	
	public double getBalance()
	{ return myBalance; }
	
	public void deposit(double amount)
	{ myBalance += amount; }
	
	public void withdraw( double amount ) throws IllegalArgumentException
	{ 
		if (amount> myBalance)
			throw new IllegalArgumentException("You can't overdraw this account");
		else
			myBalance -= amount; 
	}
}