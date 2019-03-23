package pkaccount.sb;

import pkaccount.Account;
import pkbanking.pkinterface.*;

public class SBAccount extends Account implements Transaction, InterestRate
{

	public

	SBAccount(int a, double b)
	{
		super(a,b);
	}

	public void deposit(double a)
	{
		balance =balance+ a;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
	}

	public void withdraw(double b)
	{
		if((balance-b)>minbalance)
		{
			balance =balance-b;
			System.out.println("The Account No is " + accno + " And the balance is " + balance );
		}
		else 
		{
			System.out.println("Not enough balance in the account");
		}
		
	}
	
	public void calcint1()
	{
		double interest;
		interest=balance*sbrate;
		balance=balance+interest;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
	}

}