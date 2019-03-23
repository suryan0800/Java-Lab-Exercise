package pkaccount.sb;

import pkaccount.Account;
import pkbanking.pkinterface.*;
import pkbanking.pkexception.InsufficientFundsException;

public class SBAccount extends Account implements Transaction, InterestRate
{

	public

	SBAccount(int a, double b)
	{
		super(a,b);
	}

	public void deposit(double a) throws IllegalArgumentException
	{
		if(a>0)
		{
		balance =balance+ a;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
		}
		else
		{
		throw new IllegalArgumentException("Amount is Negative ");
		}
	}

	public void withdraw(double b) throws InsufficientFundsException
	{
		if((balance-b)>minbalance)
		{
			balance =balance-b;
			System.out.println("The Account No is " + accno + " And the balance is " + balance );
		}
		else 
		{
			throw new InsufficientFundsException("Low Balance ");
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