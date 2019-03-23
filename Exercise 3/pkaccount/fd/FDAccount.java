package pkaccount.fd;

import pkaccount.Account;
import pkbanking.pkinterface.*;


public  class FDAccount extends Account implements InterestRate
{
	public int period;
	
	public FDAccount(int acc, double balance, int per)
	{
		super(acc,balance);
		period=per;
		
	}

	public double calcint()
	{
		double interest;
		interest = balance *fdrate*period ;
		System.out.println("The Interest is " + interest);
		System.out.println(" for the Account No  " + accno + " And the balance is " + balance );
		return interest;
	
	}

	public void close()
	{
		double interest = calcint();
		balance = balance + interest;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
	}


}
